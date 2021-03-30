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
        <a-form-item>
          <a-input v-model:value="param.name" placeholder="Search Keyword">
            <template #prefix>
              <UserOutlined style="color: rgba(0, 0, 0, 0.25)"/>
            </template>
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-button @click="handleSearch()">
            {{ $t('table.search') }}
          </a-button>
        </a-form-item>
      </a-form>

      <a-table
          :columns="columns"
          :row-key="record => record.id"
          :data-source="level1"
          :loading="loading"
          :pagination="false"
      >
        <template #cover="{ cover }">
          <img v-if="cover" :src="cover" alt="avatar" />
        </template>
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
      title="Category Form"
      v-model:visible="modalVisible"
      :confirm-loading="modalLoading"
      @ok="handleModalOk"
  >
    <a-form :model="categoryform" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
      <a-form-item label="Name">
        <a-input v-model:value="categoryform.name" />
      </a-form-item>
      <a-form-item label="Parent Category">
        <a-select
            v-model:value="categoryform.parent"
            style="width: 120px"
            ref="select"
        >
          <a-select-option value="0">None</a-select-option>
          <a-select-option v-for="c in level1" :key="c.id" :value="c.id" :disabled="categoryform.id==c.id">
            {{c.name}}
          </a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="Order">
        <a-input v-model:value="categoryform.sort" type="textarea" />
      </a-form-item>
    </a-form>
  </a-modal>
</template>
<TheFooter></TheFooter>
<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import axios from 'axios';
import { message } from 'ant-design-vue';
import {Tool} from "@/util/tools";
import {useRoute} from "vue-router";
import store from "@/store";


export default defineComponent({
  name: 'AdminCategory',
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
    const categorys = ref();
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
    const level1=ref();

    /**
     * 数据查询
     **/
    const handleQuery = () => {
      loading.value = true;
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      categorys.value = [];
      axios.get("/category/list").then((response) => {
        loading.value = false;
        const data = response.data;
        if (data.success) {
          categorys.value=data.content
          level1.value=[];
          level1.value=Tool.array2Tree(categorys.value,0)
          // 重置分页按钮
        } else {
          message.error(data.message);
        }
      });
    };

    /**
     * Search
     **/
    const handleSearch = () => {
      loading.value = true;
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      level1.value = [];
      if (param.value.name == null) {
        handleQuery()
      } else {
        axios.get("/category/search", {
          params: {
            name: param.value.name,
          }
        }).then((response) => {
          loading.value = false;
          const data = response.data;
          if (data.success) {
            level1.value = data.content.list;
            param.value.name=null;
            // 重置分页按钮
          } else {
            message.error(data.message);
          }
        });
      }
    };



    /**
     * update确认框 and Form
     **/
    const categoryform = ref ({});
    const modalVisible = ref(false);
    const modalLoading = ref(false);
    const handleModalOk = () => {
      modalLoading.value = true;

      axios.post("/category/save",categoryform.value).then(function (response){
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
     * Edit
     */
    const edit = (record: any) => {
      modalVisible.value = true;
      categoryform.value=Tool.copy(record);
    };

    /**
     * Add
     */
    const add=()=>{
      modalVisible.value=true;
      categoryform.value={};
    }

    /**
     * Delete
     */
    const handleDelete = (id:number) => {
      axios.delete("/category/delete/"+id).then(function (response){
        const data=response.data;
        if (data.success){
          // reload
          handleQuery();
        }
      })
    };



    onMounted(() => {

      handleQuery();

    });

    return {
      param,
      // categorys,
      level1,

      columns,
      loading,
      categoryform,
      modalVisible,
      modalLoading,
      edit,
      add,

      handleQuery,
      handleSearch,
      handleModalOk,
      handleDelete,


    }
  }
});
</script>


<style lang='less' scoped>
.a-layout{
  font-size: @font-size-base;
}
</style>