// 导入模块
const http = require('http')

// 创建web服务器实例
const server = http.createServer()

server.on('request', (req) => {
    const url = req.url
    const method = req.method
    const str = `Your request url is ${url},and request method is ${method}`
    console.log(str);
})

// 启动服务器
server.listen(8080, function () {
    console.log("server running at http://120.0.0.1:8080");
})