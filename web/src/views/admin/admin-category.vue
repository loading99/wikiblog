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
          <a-button @click="handleQuery({page: pagination.current, size: pagination.pageSize})">
            {{ $t('table.search') }}
          </a-button>
        </a-form-item>
      </a-form>

      <a-table
          :columns="columns"
          :row-key="record => record.id"
          :data-source="categorys"
          :pagination="pagination"
          :loading="loading"
          @change="handleTableChange"
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
      title="Book Form"
      v-model:visible="modalVisible"
      :confirm-loading="modalLoading"
      @ok="handleModalOk"
  >
    <a-form :model="categoryform" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
      <a-form-item label="Name">
        <a-input v-model:value="categoryform.name" />
      </a-form-item>
      <a-form-item label="Parent Category">
        <a-input v-model:value="categoryform.parent" />
      </a-form-item>
      <a-form-item label="Order">
        <a-input v-model:value="categoryform.sort" type="textarea" />
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import axios from 'axios';
import { message } from 'ant-design-vue';
import {Tool} from "@/util/tools";


export default defineComponent({
  name: 'AdminCategory',
  setup() {
    /**
     * search Keyword
     **/
    const param=ref();
    param.value={};

    /**
     * Book related Info
     **/
    const categorys = ref();
    const pagination = ref({
      current: 1,
      pageSize: 10,
      total: 0
    });
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

    /**
     * 数据查询
     **/
    const handleQuery = (p: any) => {
      loading.value = true;
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      categorys.value = [];
      axios.get("/category/search",{
        params: {
          page: p.page,
          size: p.size,
          name: param.value.name,
        }
      }).then((response) => {
        loading.value = false;
        const data = response.data;
        if (data.success) {
          categorys.value = data.content.list;
          // 重置分页按钮
          pagination.value.current = p.page;
          pagination.value.total = data.content.total;
        } else {
          message.error(data.message);
        }
      });
    };

    /**
     * 表格点击页码时触发
     */
    const handleTableChange = (pagination: any) => {
      console.log("看看自带的分页参数都有啥：" + pagination);
      handleQuery({
        page: pagination.current,
        size: pagination.pageSize
      });
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
          handleQuery({
            page: pagination.value.current,
            size: pagination.value.pageSize
          });
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

          handleQuery({
            page: pagination.value.current,
            size: pagination.value.pageSize
          });
        }
      })
    };



    onMounted(() => {

      handleQuery({
        page:1,
        size: pagination.value.pageSize
      });

    });

    return {
      param,
      categorys,
      pagination,
      columns,
      loading,
      handleTableChange,

      categoryform,
      modalVisible,
      modalLoading,
      edit,
      add,

      handleQuery,
      handleModalOk,
      handleDelete,


    }
  }
});
</script>


<style lang='css' scoped>
.a-layout{
  font-size: 16px;
}
</style>