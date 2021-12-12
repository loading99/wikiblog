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
              <a-form-item class="custom-col">
                <ckeditor
                    :content="txt"
                    @sendContent = 'updateContent'
                />
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
import store from "@/store";
import ckeditor from './ckeditor4.vue';
declare let katex: any

export default defineComponent({
  name: 'AdminDoc',
  components:{
    ckeditor
  },
  setup() {
    /**
     * First Get route information
     * check if menu item is showed
     */
    const route=useRoute();
    store.commit("setPage",route.path);
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

    //Quill-Vue Editor settings
    const editoroption = {
    }

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
    const editor = ref();
    const treeSelect= ref();
    treeSelect.value={};
    const docform = ref ();
    docform.value={};
    const modalVisible = ref(false);
    const modalLoading = ref(false);

    const txt = ref();
    txt.value = '';
    const handleModalOk = () => {
      modalLoading.value = true;
      docform.value.content=txt.value;
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
     * Query Rich text from database.
     * @param id
     */
    const handleContent=(id:bigint)=>{
      console.log("---start to retrive data-----");
      axios.get("/doc/content/"+id).then((response)=>{
        const data=response.data;
        console.log('value',data.content);
        if (data.success){
          txt.value = data.content;
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
      docform.value=Tool.copy(record);
      treeSelect.value=Tool.copy(level1.value);
      Tool.setDisable(treeSelect.value,record.id);
      treeSelect.value.unshift({id:0,name:"None"});
      //rich text editor show
      handleContent(docform.value.id);
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
    }

    let IDlist:Array<bigint>=[];
    const handleDelete = (id:bigint) => {
      Tool.deleteIDs(level1.value,id,IDlist);
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
      drawerVisible.value = true;
    };
    const onDrawerClose = () => {
      drawerVisible.value = false;
    };

    const updateContent = (val: any)=>{
      txt.value = val;
    }

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
      previewHtml,

      editoroption,
      editor,
      txt,
      editorData: '<p>test</p>',
      updateContent
    }
  }
});
</script>


<style lang='less' scoped>
.a-layout{
  font-size: @font-size-base;
}
.custom-col /deep/.ant-col.ant-col-18.ant-form-item-control-wrapper{
  display: block;
  flex: 0 0 100%;
  max-width: 100%;
}
/deep/.ant-form-item-control{
  line-height: 20px;
}
</style>