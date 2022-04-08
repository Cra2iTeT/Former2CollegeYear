// 导入模块
const http = require('http')

// 创建web服务器实例
const server = http.createServer()

server.on('request', (req, resp) => {
    // 设置编码格式
    resp.setHeader('Content-Type', 'text/html; charset=utf-8')

    const url = req.url
    const method = req.method
    const str = `你请求的url是 ${url},请求方法是 ${method}`
    console.log(str);

    // 调用resp.end方法，响应信息
    resp.end(str)
})

// 启动服务器
server.listen(8080, function () {
    console.log("server running at http://120.0.0.1:8080");
})