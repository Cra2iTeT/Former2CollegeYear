const express = require('express')
const app = express()

// 执行顺序和函数定义顺序无关，和use的先后顺序有关
const myS = function(req, resp, next) {
    console.log("第二个");
    next()
}

const myF = function(req, resp, next) {
    console.log("第一个");
    next()
}

// const myS = function(req, resp, next) {
//     console.log("第二个");
//     next()
// }


// app.use(myS)
app.use(myF)
app.use(myS)

app.get('/', function(req, resp) {
    resp.send("test")
})

app.listen(80, () => {
    console.log('express server running at http://127.0.0.0.1');
})