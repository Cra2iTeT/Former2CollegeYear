const express = require('express')

const app = express()

app.get('/user', function(req, resp) {
    resp.send({name: 'Cra2iTeT', age: 20, gender: '男'})
})

app.get('/', function(req, resp) {
    console.log(req.query);
    // req.query可以接收参数默认为空
})

// :id是一个动态参数，id可更换，是匹配后的属性名
app.get('/user/:id', function(req, resp) {
    // 获取动态匹配到的参数，默认为空
    console.log(req.params);
    resp.send(req.params)
})

app.post('/user', function(req, resp) {
    resp.send({name: 'Cra2iTeT', age: 20, gender: '男'})
})

app.listen(8080, () => {
    console.log('express server running at http://127.0.0.0.1:8080');
})