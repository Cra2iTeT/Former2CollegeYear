const express = require('express')
const app = express()

const mw = function(req, resp, next) {
    req.startTime = Date.now()
    next()
}

// 注册全局有效的中间件
app.use(mw)

app.get('/', function(req, resp) {
    resp.send(req.startTime)
})

app.listen(80, () => {
    console.log('express server running at http://127.0.0.0.1');
})