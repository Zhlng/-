<template>
  <div>
    <el-form :model="searchform" style="display: flex">
      <el-form-item label="成员名字">
        <el-input v-model="searchform.personnelName" />
      </el-form-item>
      <el-form-item style="margin-left: 10px">
        <el-button type="primary" @click="getData">搜索</el-button>
        <el-button type="danger" @click="add">新增</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="personnelId" label="成员ID" />
      <el-table-column prop="familyId" label="家族ID" />
      <el-table-column prop="personnelName" label="成员名字" />
      <el-table-column prop="personnelSex" label="性别" />
      <el-table-column prop="personnelBrithdate" label="出生日期" />
      <el-table-column prop="personnelDeathdate" label="死亡日期" />
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
          label="家族"
          :label-width="formLabelWidth"
          prop="familyId"
        >
          <el-select v-model="form.familyId" placeholder="Select">
            <el-option
              v-for="item in options"
              :key="item.familyId"
              :label="item.familyName"
              :value="item.familyId"
            />
          </el-select>
        </el-form-item>
        <el-form-item
          label="成员名字"
          :label-width="formLabelWidth"
          prop="personnelName"
        >
          <el-input v-model="form.personnelName" autocomplete="off" />
        </el-form-item>
        <el-form-item
          label="性别"
          :label-width="formLabelWidth"
          prop="personnelSex"
        >
          <el-select v-model="form.personnelSex" placeholder="请选择">
            <el-option label="男" value="男" />
            <el-option label="女" value="女" />
          </el-select>
        </el-form-item>
        <el-form-item
          label="出生日期"
          :label-width="formLabelWidth"
          prop="personnelBrithdate"
        >
          <el-input v-model="form.personnelBrithdate" autocomplete="off" />
        </el-form-item>
        <el-form-item
          label="死亡日期"
          :label-width="formLabelWidth"
          prop="personnelDeathdate"
        >
          <el-input v-model="form.personnelDeathdate" autocomplete="off" />
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
  personnelName: "",
});

const formSize = ref("default");
const ruleFormRef = ref<FormInstance>();
let form = reactive({
  familyId: "",
  personnelId: "",
  personnelName: "",
  personnelSex: "",
  personnelBrithdate: "",
  personnelDeath: "",
  logtime: new Date(),
  deleted: 0,
});
const rules = reactive<FormRules>({
  personnelName: [
    { required: true, message: "请输入成员名字", trigger: "blur" },
  ],
  personnelDeath: [
    { required: true, message: "请输入死亡日期", trigger: "blur" },
  ],
  personnelBrithdate: [
    { required: true, message: "请输入出生日期", trigger: "blur" },
  ],
  familyId: [{ required: true, message: "请选择家族", trigger: "change" }],
  personnelSex: [
    {
      required: true,
      message: "请选择性别",
      trigger: "change",
    },
  ],
});

const getData = () => {
  if (searchform.personnelName) {
    axios
      .post("http://localhost:8080/personnel/select", searchform)
      .then((res: any) => {
        tableData.value = res.data;
      });
  } else {
    axios.get("http://localhost:8080/personnel/list").then((res: any) => {
      tableData.value = res.data;
    });
  }
};

const getFamily = () => {
  axios.get("http://localhost:8080/family/list").then((res: any) => {
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
        .post(
          `http://localhost:8080/personnel/${
            !form.personnelId ? "save" : "change"
          }`,
          form
        )
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
    .post("http://localhost:8080/personnel/delete", data)
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
  getFamily();
});
</script>
