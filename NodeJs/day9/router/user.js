const express = require('express')

const router = express.Router()

// 导入与用户路由处理函数对应模块
const user_handler = require('../router_handler/user')

router.post('/reguser', user_handler.regUser)

router.post('/login', user_handler.login)



module.exports = router