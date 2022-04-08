// 导入
const express = require('express')
// 创建服务器实例对象
const app = express()

// 配置json中间件
app.use(express.json())

// 响应数据的中间件
app.use(function (req, res, next) {
    res.cc = function (err, status = 1) {
        res.send({
            status,
            message: err instanceof Error ? err.message : err
        })

    }

    next()
})

// 导入并配置cors中间件
const cors = require('cors')
app.use(cors())
app.use(express.urlencoded({ extended: false}))

// 导入并使用用户路由模块
const userRouter = require('../router/user')
app.use('/api', userRouter)

app.listen(3007, (req, res) => {
    console.log('api_server running at http://127.0.0.1:3007');
})