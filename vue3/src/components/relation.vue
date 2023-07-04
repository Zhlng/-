<template>
  <div>
    <el-form :model="searchform" style="display: flex">
      <el-form-item label="成员ID1">
        <el-input v-model="searchform.personnelId1" />
      </el-form-item>
      <el-form-item label="成员ID2">
        <el-input v-model="searchform.personnelId2" />
      </el-form-item>
      <el-form-item style="margin-left: 10px">
        <el-button type="primary" @click="getData">搜索</el-button>
        <el-button type="danger" @click="add">新增</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="personnelId1" label="成员1ID" />
      <el-table-column prop="name1" label="成员1名字" />
      <el-table-column prop="personnelId2" label="成员2ID" />
      <el-table-column prop="name2" label="成员2名字" />
      <el-table-column prop="relationType" label="关系" />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button
            type="primary"
            size="small"
            @click.prevent="update(scope.row)"
          >
            编辑
          </el-button>
          <el-button
            type="danger"
            size="small"
            @click.prevent="deleteRow(scope.row)"
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="dialogFormVisible" title="新增">
      <el-form
        ref="ruleFormRef"
        :model="form"
        :rules="rules"
        label-width="120px"
        class="demo-ruleForm"
        :size="formSize"
        status-icon
      >
        <el-form-item
          label="成员1"
          :label-width="formLabelWidth"
          prop="personnelId1"
        >
          <el-select v-model="form.personnelId1" placeholder="Select">
            <el-option
              v-for="item in options"
              :key="item.personnelId"
              :label="item.personnelName"
              :value="item.personnelId"
            />
          </el-select>
        </el-form-item>
        <el-form-item
          label="成员2"
          :label-width="formLabelWidth"
          prop="personnelId2"
        >
          <el-select v-model="form.personnelId2" placeholder="Select">
            <el-option
              v-for="item in options"
              :key="item.personnelId"
              :label="item.personnelName"
              :value="item.personnelId"
            />
          </el-select>
        </el-form-item>
        <el-form-item
          label="关系"
          :label-width="formLabelWidth"
          prop="relationType"
        >
          <el-select v-model="form.relationType" placeholder="Select">
            <el-option
              v-for="item in options1"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm(ruleFormRef)">
            提交
          </el-button>
          <el-button @click="resetForm(ruleFormRef)">关闭</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { onMounted, ref, reactive } from "vue";
import axios from "axios";
import type { FormInstance, FormRules, ElMessage } from "element-plus";

const tableData = ref([]);

const options = ref([]);

const options1 = ref(["父子", "父女", "夫妻","母女","母子","兄妹","兄弟","姐弟","叔侄"]);

const dialogFormVisible = ref(false);
const formLabelWidth = "140px";

const searchform = reactive({
  personnelId1: "",
  personnelId2: ""
});

const formSize = ref("default");
const ruleFormRef = ref<FormInstance>();
let form = reactive({
  personnelId1: "",
  personnelId2: "",
  relationType: "",
  logtime: new Date(),
  deleted: 0,
});
const rules = reactive<FormRules>({
  personnelId1: [{ required: true, message: "请输入", trigger: "blur" }],
  personnelId2: [{ required: true, message: "请输入", trigger: "blur" }],
  relationType: [{ required: true, message: "请输入", trigger: "blur" }],
});

const getData = () => {
  if (searchform.personnelId1 || searchform.personnelId2) {
    axios
      .post("http://localhost:8080/relation/select", searchform)
      .then((res: any) => {
        tableData.value = res.data;
      });
  } else {
    axios.get("http://localhost:8080/relation/list").then((res: any) => {
      tableData.value = res.data;
    });
  }
};

const getOptions = () => {
  axios.get("http://localhost:8080/personnel/list").then((res: any) => {
    options.value = res.data;
  });
};

const add = () => {
  for (const key in form) {
    if (Object.prototype.hasOwnProperty.call(form, key)) {
      form[key] = null;
    }
  }
  dialogFormVisible.value = true;
};

const update = (data: object) => {
  form = Object.assign(form, data);
  dialogFormVisible.value = true;
};

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  await formEl.validate((valid, fields) => {
    if (valid) {
      if (!form.personnelId1) {
        form.logtime = new Date();
      }
      axios
        .post(`http://localhost:8080/relation/${!form.personnelId1?'save':'change'}`, form)
        .then((res: any) => {
          resetForm(formEl);
          ElMessage.success("操作成功");
          getData();
        })
        .catch(() => {
          ElMessage.error("操作失败");
        });
    } else {
      console.log("error submit!", fields);
    }
  });
};

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.resetFields();
  dialogFormVisible.value = false;
};

const deleteRow = (data: object) => {
  axios.post("http://localhost:8080/relation/delete", data).then((res: any) => {
    ElMessage.success("删除成功");
    getData();
  });
};

const getTime = (time) => {
  if (time == null) {
    return "";
  }
  return time.substring(0, 10) + " " + time.substring(11, 19);
};

onMounted(() => {
  getData();
  getOptions();
});
</script>
