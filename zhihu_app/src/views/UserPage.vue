<template>
  <div class="container">
    <el-form :model="user" :rules="rules" ref="userForm" label-width="80px" class="form" >
      <el-form-item label="用户名" prop="username">
        <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="user.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input-number v-model="user.age" :min="1" placeholder="请输入年龄"></el-input-number>
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input v-model="user.phone" placeholder="请输入手机号"></el-input>
      </el-form-item>
      <el-form-item label="身份证" prop="idCard">
        <el-input v-model="user.idCard" placeholder="请输入身份证号"></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-radio-group v-model="user.gender">
          <el-radio label="男">男</el-radio>
          <el-radio label="女">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button @click="addUser">提交</el-button>
      </el-form-item>
    </el-form>
    <!-- 成功提示 -->
    <el-alert
        v-if="successMessage"
        title="成功"
        type="success"
        show-icon
        :closable="false"
        :center="true"
    >{{ successMessage }}</el-alert>
  </div>
</template>

<script setup>
import { ref, nextTick, onMounted } from 'vue'
import axios from 'axios'
import {
  ElForm,
  ElFormItem,
  ElInput,
  ElInputNumber,
  ElButton,
  ElRadio,
  ElRadioGroup,
  ElAlert,
  ElMessage
} from 'element-plus'

const userFormRef = ref(null)
const user = ref({
  username: '',
  password: '',
  age: 0,
  phone: '',
  idCard: '',
  gender: ''
})
const successMessage = ref('')



const addUser = async () => {
  await nextTick()
  try {
    await axios.post('http://localhost:8080/user/add', user.value)
        .then(response => {
          if (response.data.code === 200) {
            ElMessage({
              message: "添加成功",
              type: 'success',
            })
          } else {
            throw new Error(response.data.msg)
          }
        })
        .catch(error => {
          ElMessage({
            message: error.message,
            type: 'warning',
          })
        })
  } catch (error) {
    console.error(error)
  }
}
</script>


<style scoped>
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}
.form {
  margin-bottom: 20px;
}
.success-message {
  margin-top: 20px;
}
</style>
