const express = require('express')
const app = express()

// 在这里调用static方法，对外提供静态资源
// 同时托管多个文件夹时，文件夹内有同名文件则优先访问先导入的资源
app.use(express.static('../day2/clock'))
// 给取别名，要访问就得加别名路径
// app.use('/public', express.static('../day2/clock'))

app.get('/get', function(req, resp) {
    resp.send('Hello world')
})

app.post('/post', function(req, resp) {
    resp.send('Post')
})

app.listen(8080, () => {
    console.log('express server running at http://12700.0.1:8080');
    // console.log('测试是否自动重启');
})