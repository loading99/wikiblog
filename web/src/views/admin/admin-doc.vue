<template>
  <a-layout style="padding: 24px 0; background: #fff;">
    <a-layout-content :style="{ padding: '0 24px', minHeight: '280px'}">
      <a-form
          layout="inline"
          :model="param"
      >
        <a-form-item>
          <a-button type="primary" @click="add()" size="small">
            {{ $t('table.add') }}
          </a-button>
        </a-form-item>
      </a-form>

      <a-table
          v-if="level1.length>0"
          :columns="columns"
          :row-key="record => record.id"
          :data-source="level1"
          :loading="loading"
          :pagination="false"
          :defaultExpandAllRows="true"
      >
        <template v-slot:action="{record}">
          <a-space size="small">
            <a-button type="primary" @click="edit(record)">
              {{ $t('table.edit') }}
            </a-button>
            <a-popconfirm
                title="Cannot be recovered, Please Confirm"
                ok-text="Yes"
                cancel-text="cancel"
                @confirm="handleDelete(record.id)"
            >
              <a-button type="danger">
                {{ $t('table.deletion') }}
              </a-button>
            </a-popconfirm>
          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>

  <a-modal
      title="Doc Form"
      width="80%"
      v-model:visible="modalVisible"
      :confirm-loading="modalLoading"
      @ok="handleModalOk"
  >
        <a-form :model="docform" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }" >
          <a-row justify="space-between">
            <a-col :span="8">
              <a-form-item :label="$t('form.name') ">
                <a-input v-model:value="docform.name"/>
              </a-form-item>
              <a-form-item label="父文档">
                <a-tree-select
                    v-model:value="docform.parent"
                    style="width: 100%"
                    :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
                    :tree-data="treeSelect"
                    placeholder="Please select"
                    :replaceFields="{ title:'name', key: 'id', value: 'id' }"
                    tree-default-expand-all
                >
                </a-tree-select>
              </a-form-item>
              <a-form-item :label="$t('form.order')">
                <a-input v-model:value="docform.sort" type="textarea"/>
              </a-form-item>
              <a-form-item>
                <a-button type="primary" @click="handlePreviewContent()">
                  <EyeOutlined /> {{ $t('preview') }}
                </a-button>
              </a-form-item>
            </a-col>
            <a-col :span="14">
              <a-form-item>
                <div id="content"></div>
              </a-form-item>
            </a-col>
          </a-row>
        </a-form>
  </a-modal>

  <a-drawer width="1000" placement="right" :closable="false" :visible="drawerVisible" @close="onDrawerClose">
    <div class="wangeditor" :innerHTML="previewHtml"></div>
  </a-drawer>
</template>
<TheFooter></TheFooter>
<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import axios from 'axios';
import { message } from 'ant-design-vue';
import {Tool} from "@/util/tools";
import {useRoute} from "vue-router";
import E from 'wangeditor'


export default defineComponent({
  name: 'AdminDoc',
  setup() {
    const route=useRoute();
    console.log("-----route 的各种变量------",route)

    /**
     * search Keyword
     **/
    const param=ref();
    param.value={};

    /**
     * Book related Info
     **/
    const docs = ref();
    const loading = ref(false);
    const columns = [
      {
        title: 'Name',
        dataIndex: 'name'
      },
      {
        title: 'ParentID',
        dataIndex: 'parent',
        slots: { customRender: 'parent' }
      },
      {
        title: 'Order',
        dataIndex: 'sort'
      },
      {
        title: 'Action',
        key: 'action',
        slots: { customRender: 'action' }
      }
    ];
    //Category Tree Strucutre
    const level1=ref();
    level1.value=[];

    /**
     * Rich text Edit
     */
    const editor = new E('#content');



    /**
     * 数据查询
     **/
    const handleQuery = () => {
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      docs.value = [];
      level1.value=[];
      axios.get("/doc/list/"+ route.query.ebookId).then((response) => {
        const data = response.data;
        if (data.success) {
          docs.value=data.content
          if(!Tool.isEmpty(docs.value)){
            level1.value=Tool.array2Tree(docs.value,0)
          }
        } else {
          message.error(data.message);
        }
      });
    };




    /**
     * update确认框 and Form
     **/
    const treeSelect= ref();
    treeSelect.value={};
    const docform = ref ();
    docform.value={};
    const modalVisible = ref(false);
    const modalLoading = ref(false);
    const handleModalOk = () => {
      modalLoading.value = true;
      docform.value.content=editor.txt.html();
      axios.post("/doc/save",docform.value).then(function (response){
        modalLoading.value=false;
        const data=response.data;
        if (data.success){
          modalVisible.value=false;
          // reload
          handleQuery();
        }else{
          message.error(data.message);
        }
      })
    };

    /**
     * Recursively set node and children node as disabled
     * cannot be chosen
     */
    const setDisable = (treeSelect: any, id: number) => {
      for (let i = 0; i < treeSelect.length; i++) {
        const node = treeSelect[i];
        if (node.id == id) {
          console.log("-----Disable Node-----",node.id);
          node.disabled = true;
          const child = node.children;
          if(Tool.isEmpty(child)){
            continue;
          }
          for (let j = 0; j < child.length; j++) {
            const c = child[j];
            setDisable(child, c.id);
          }
        } else {
          const child = node.children;
          if (!Tool.isEmpty(child)) {
            setDisable(child, id);
          }
        }
      }
    }
    /**
     * Query Rich text from database.
     * @param id
     */
    const handleContent=(id:bigint)=>{
      axios.get("/doc/content/"+id).then((response)=>{
        const data=response.data;
        if (data.success){
          editor.txt.html(data.content);
        }else{
          message.error(data.message);
        }
      })
    }

    /**
     * Edit
     */
    const edit = (record: any) => {
      modalVisible.value = true;
      editor.txt.html("");
      docform.value=Tool.copy(record);
      treeSelect.value=Tool.copy(level1.value);
      setDisable(treeSelect.value,record.id);
      treeSelect.value.unshift({id:0,name:"None"});
      console.log("-----Upgraded Tree------",treeSelect.value);
      //rich text editor show
      handleContent(docform.value.id);
      setTimeout(()=>{
        editor.create();
      },1000);

    };

    /**
     * Add
     */
    const add=()=>{
      modalVisible.value=true;
      docform.value={
        ebookId:route.query.ebookId
      };

      treeSelect.value=Tool.copy(level1.value);
      if(Tool.isEmpty(treeSelect.value)){
        treeSelect.value=[{id:0,name:"None"}]
        console.log("-----Manully add options if treeselect is empty-------")
      }else{
        treeSelect.value.unshift({id:0,name:"None"})
      }

      /**
       * Online Rich Text editor Rendering class content
       * Note the scripts within the function may run asynchronously
       * So The content tag may not show on the screen when the function begins,
       * Setting a timeout solves this issue.
       */
      setTimeout(()=>{
        editor.create();
      },1000);
    }

    /**
     * Recursively search the tree and add IDs in one entire branch
     */
    let IDlist:Array<bigint>=[];
    const deleteIDs = (tree: any, id: bigint) => {
      for (let i = 0; i < tree.length; i++) {
        const node = tree[i];
        if (node.id == id) {
          const child = node.children;
          IDlist.push(id);
          if (Tool.isEmpty(child)) {
            continue;
          }
          for (let j = 0; j < child.length; j++) {
            const c = child[j];
            deleteIDs(child, c.id);
          }
        } else {
          const child = node.children;
          if (!Tool.isEmpty(child)) {
            deleteIDs(child, id);
          }
        }
      }
    }



    const handleDelete = (id:bigint) => {
      deleteIDs(level1.value,id);
      console.log("-----IDs to be deleted------",IDlist);
      if(Tool.isEmpty(IDlist)){
        message.error("Deleting Empty records")
      }else{
      axios.delete("/doc/delete/"+IDlist.join(',')).then(function (response){
        const data=response.data;
        if (data.success){
          // reload
          IDlist=[];
          handleQuery();
        }
      })
      }
    };

    // ----------------富文本预览--------------
    const drawerVisible = ref(false);
    const previewHtml = ref();
    const handlePreviewContent = () => {
      const html = editor.txt.html();
      previewHtml.value = html;
      drawerVisible.value = true;
    };
    const onDrawerClose = () => {
      drawerVisible.value = false;
    };

    onMounted(() => {
      handleQuery();
      console.log("-------Tree 结构------", level1);
    });

    return {
      param,
      // docs,
      level1,

      columns,
      loading,
      docform,
      modalVisible,
      modalLoading,
      edit,
      add,

      handleQuery,
      handleModalOk,
      handleDelete,

      treeSelect,

      //Preview
      handlePreviewContent,
      onDrawerClose,
      drawerVisible,
      previewHtml


    }
  }
});
</script>


<style lang='less' scoped>
.a-layout{
  font-size: @font-size-base;
}
</style>