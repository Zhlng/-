<template>
  <div>
    <el-form :model="searchform" style="display: flex">
      <el-form-item label="类型">
        <el-input v-model="searchform.inccidentType" />
      </el-form-item>
      <el-form-item style="margin-left: 10px">
        <el-button type="primary" @click="getData">搜索</el-button>
        <el-button type="danger" @click="add">新增</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="personnelId" label="成员ID" />
      <el-table-column prop="inccidentDate" label="事迹时间" />
      <el-table-column prop="inccidentType" label="类型" />
      <el-table-column prop="inccidentDescription" label="内容" />
      <el-table-column prop="inccidentAttachments" label="附件" />
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
          label="成员"
          :label-width="formLabelWidth"
          prop="membersId"
        >
          <el-select v-model="form.personnelId" placeholder="Select">
            <el-option
              v-for="item in options"
              :key="item.personnelId"
              :label="item.personnelName"
              :value="item.personnelId"
            />
          </el-select>
        </el-form-item>
        <el-form-item
          label="事迹时间"
          :label-width="formLabelWidth"
          prop="inccidentDate"
        >
          <el-input v-model="form.inccidentDate" autocomplete="off" />
        </el-form-item>
        <el-form-item
          label="类型"
          :label-width="formLabelWidth"
          prop="inccidentType"
        >
          <el-input v-model="form.inccidentType" autocomplete="off" />
        </el-form-item>

        <el-form-item
          label="内容"
          :label-width="formLabelWidth"
          prop="inccidentDescription"
        >
          <el-input v-model="form.inccidentDescription" autocomplete="off" />
        </el-form-item>
        <el-form-item
          label="附件"
          :label-width="formLabelWidth"
          prop="inccidentAttachments"
        >
          <el-input v-model="form.inccidentAttachments" autocomplete="off" />
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

const dialogFormVisible = ref(false);
const formLabelWidth = "140px";

const searchform = reactive({
  inccidentType: "",
});

const formSize = ref("default");
const ruleFormRef = ref<FormInstance>();
let form = reactive({
  personnelId: null,
  inccidentDate: "",
  inccidentType: "",
  inccidentDescription: "",
  inccidentAttachments: "",
  logtime: new Date(),
  deleted: 0,
});
const rules = reactive<FormRules>({
  inccidentDate: [{ required: true, message: "请输入", trigger: "blur" }],
  inccidentType: [{ required: true, message: "请输入", trigger: "blur" }],
  inccidentDescription: [
    { required: true, message: "请输入", trigger: "blur" },
  ],
  inccidentAttachments: [
    { required: true, message: "请输入", trigger: "blur" },
  ],
  personnelId: [
    {
      required: true,
      message: "请选择",
      trigger: "change",
    },
  ],
});

const getData = () => {
  if (searchform.inccidentType) {
    axios
      .post("http://localhost:8080/inccident/select", searchform)
      .then((res: any) => {
        tableData.value = res.data;
      });
  } else {
    axios.get("http://localhost:8080/inccident/list").then((res: any) => {
      tableData.value = res.data;
    });
  }
};

const getOption = () => {
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
      if (!form.personnelId) {
        form.logtime = new Date();
      }
      axios
        .post(`http://localhost:8080/inccident/${!form.personnelId?'save':'change'}`, form)
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
  axios
    .post("http://localhost:8080/inccident/delete", data)
    .then((res: any) => {
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
  getOption();
});
</script>
