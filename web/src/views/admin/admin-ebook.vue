<template>
  <a-layout style="padding: 24px 0; background: #fff">
    <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
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
          :data-source="ebooks"
          :pagination="pagination"
          :loading="loading"
          @change="handleTableChange"
      >
        <template #cover="{ cover }">
          <img v-if="cover" :src="cover" alt="avatar" />
        </template>
        <template v-slot:action="{record}">
          <a-space size="small">
            <router-link :to="'/admin/doc?ebookId=' + record.id">
              <a-button type="primary">
                {{ $t('table.fm') }}
              </a-button>
            </router-link>
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
    <a-form :model="formbook" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
      <a-form-item label="Cover">
        <a-upload
            v-model:file-list="fileList"
            name="cover"
            list-type="picture-card"
            class="avatar-uploader"
            :multiple="false"
            :show-upload-list="false"
            :disabled="ImageLoading"
            :before-upload="beforeUpload"
            @change="handleImage"
        >
          <img v-if="imageUrl" :src="imageUrl" alt="cover" />
          <div v-else>
            <loading-outlined v-if="ImageLoading"></loading-outlined>
            <plus-outlined v-else></plus-outlined>
            <div class="ant-upload-text">Upload</div>
          </div>
        </a-upload>
        <a-button
            type="primary"
            :disabled="fileList.length ==0"
            :loading="ImageLoading"
            @click="AllowUpload"
        >
          {{ ImageLoading ? 'Uploading' : 'Start Upload' }}
        </a-button>
      </a-form-item>
      <a-form-item label="Name">
        <a-input v-model:value="formbook.name" />
      </a-form-item>
      <a-form-item label="Category">
<!--        <a-input v-model:value="formbook.categoryid" />-->
        <a-cascader v-model:value="arr"
                    :options="level1"
                    placeholder="Please select"
                    :field-names="{ label: 'name', value: 'id'}"
        />
      </a-form-item>
      <a-form-item label="Description">
        <a-input v-model:value="formbook.description" type="textarea" />
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import axios from 'axios';
import { message } from 'ant-design-vue';
import {Tool} from "@/util/tools";
import {useRoute} from "vue-router";
import store from "@/store";
import {LoadingOutlined, PlusOutlined} from "@ant-design/icons-vue";

function getBase64(img: Blob, callback: (base64Url: string) => void) {
  const reader = new FileReader();
  reader.addEventListener('load', () => callback(reader.result as string));
  reader.readAsDataURL(img);
}

export default defineComponent({
  name: 'AdminEbook',
  components: {
    LoadingOutlined,
    PlusOutlined,
  },
  setup() {
    /**
     * First Get route information
     * check if menu item is showed
     */
    const route=useRoute();
    store.commit("setPage",route.path);
    const SERVER=axios.defaults.baseURL

    /**
     * search Keyword
     **/
    const param=ref();
    param.value={};

    /**
     * Book related Info
     **/
    const ebooks = ref();
    const pagination = ref({
      current: 1,
      pageSize: 5,
      total: 0
    });
    const loading = ref(false);

    const columns = [
      {
        title: 'Cover',
        dataIndex: 'cover',
        slots: { customRender: 'cover' }
      },
      {
        title: 'Name',
        dataIndex: 'name'
      },
      {
        title: 'Category',
        dataIndex: 'categoryid',
      },
      {
        title: 'Doc No.',
        dataIndex: 'docCount'
      },
      {
        title: 'Views',
        dataIndex: 'viewCount'
      },
      {
        title: 'Likes',
        dataIndex: 'voteCount'
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
      ebooks.value = [];
      axios.get("/ebook/search",{
        params: {
          page: p.page,
          size: p.size,
          name: param.value.name,
        }
      }).then((response) => {
        loading.value = false;
        const data = response.data;
        if (data.success) {
          ebooks.value = data.content.list;
          // 重置分页按钮
          pagination.value.current = p.page;
          pagination.value.total = data.content.total;
        } else {
          message.error(data.message);
        }
      });
    };

    /**
     * Click pagination, jump to another page
     */
    const handleTableChange = (pagination: any) => {
      console.log("Pagination Parameters" + pagination);
      handleQuery({
        page: pagination.current,
        size: pagination.pageSize
      });
    };

    /**
     * 查询数据Category，在修改或增加图书分类时调用，默认当前书的categories，如果没有就显示Please select
     **/
    const level1=ref();
    const categorys=ref();
    categorys.value={};
    const listCategory = () => {
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      categorys.value = [];
      axios.get("/category/list").then((response) => {
        const data = response.data;
        if (data.success) {
          categorys.value=data.content
          level1.value=[];
          level1.value=Tool.array2Tree(categorys.value,0)
          // reset pagination
        } else {
          message.error(data.message);
        }
      });
    };

    /**
     * update确认框 and Form
     **/
    const arr=ref<string[]>([]);
    const formbook = ref ();
    const modalVisible = ref(false);
    const modalLoading = ref(false);
    const handleModalOk = () => {
      modalLoading.value = true;
      //cascader will select all levels of categories as a list, so select the last one
      // console.log("------formbook parameters-------",arr.value.pop());
      formbook.value.categoryid=arr.value.pop();
      axios.post("/ebook/save",formbook.value).then(function (response){
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
      formbook.value=Tool.copy(record);

    };

    /**
     * Add
     */
    const add=()=>{
      modalVisible.value=true;
      formbook.value={};

    }

    /**
     * Delete
     */
    const handleDelete = (id:bigint) => {
      axios.delete("/ebook/delete/"+id).then(function (response){
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

    /**
     * Upload Image Block
     */
    const fileList = ref();
    fileList.value=[];
    const ImageLoading = ref<boolean>(false);
    const imageUrl = ref<string>('');

    const handleImage = (info: any) => {
      console.log('start to upload')
      if (info.file.status == 'uploading') {
        ImageLoading.value = true;
        return;
      }
      if (info.file.status == 'done') {
        // Get this url from response in real world.
        getBase64(info.file.originFileObj, (base64Url: string) => {
          imageUrl.value = base64Url;
          ImageLoading.value = false;
        });
      }
      if (info.file.status == 'error') {
        ImageLoading.value = false;
        message.error('upload error');
      }
    };

    const AllowUpload = ()=>{
      ImageLoading.value = true;
      const formdata = new FormData();
      formdata.append('id',formbook.value.id);
      formdata.append('file', fileList.value.pop());
      axios.post("/ebook/upload/cover", formdata, {
        headers:{
          "Content-type": "multipart/form-data"
        }
      }).then((response)=>{
        const data = response.data;
        if(data.success){
          message.success("successfully upload!");
          fileList.value = [];
        }else{
          message.error(data.message)
        }

        ImageLoading.value = false;
      })
    }

    const beforeUpload = (file: any) => {
      console.log("Execute beforeUpload")
      const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
      if (!isJpgOrPng) {
        message.error('You can only upload JPG file!');
      }
      else if(file.size / 1024 / 1024 > 2) {
        message.error('Image must smaller than 2MB!');
      }else {
        fileList.value.push(file)
      }
      return false
    };

    onMounted(() => {
      handleQuery({
        page:1,
        size: pagination.value.pageSize
      });
      listCategory();
    });

    return {
      param,
      ebooks,
      pagination,
      columns,
      loading,
      handleTableChange,

      formbook,
      modalVisible,
      modalLoading,
      edit,
      add,

      handleQuery,
      handleModalOk,
      handleDelete,

      //categories
      level1,
      arr,

      //Image
      handleImage,
      fileList,
      ImageLoading,
      imageUrl,
      beforeUpload,

      AllowUpload,
      SERVER
    }
  }
});
</script>

<style scoped>
img {
  width: 50px;
  height: 50px;
}
</style>