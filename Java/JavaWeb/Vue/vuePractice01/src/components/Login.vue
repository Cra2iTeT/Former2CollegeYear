<template>
    <div style="width:400px;margin:auto;text-align:center;">
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="账号" prop="id">
                <el-input type="text" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
  export default {
    data() {
      var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('年龄不能为空'));
        }
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
            if (value < 18) {
              callback(new Error('必须年满18岁'));
            } else {
              callback();
            }
          }
        }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          pass: '',
          checkPass: '',
          age: ''
        },
        rules: {
          id: [
            { validator: validatePass, trigger: 'blur' }
          ],
          password: [
            { validator: validatePass2, trigger: 'blur' }
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>