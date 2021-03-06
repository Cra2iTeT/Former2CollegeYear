const http = require('http')
const server = http.createServer()

server.on('request', (req, resp) => {
    const url = req.url

    let content = '<h1>404 not found</h1>'

    if (url === '/' || url === '/index.html') {
        content = '<h1>首页</h1>'
    } else if (url === '/about.html') {
        content = '<h1>关于页面</h1>'
    }

    resp.setHeader('Content-Type', 'text/html; charset=utf-8')
    resp.end(content)
})

server.listen(8080, () => {
    console.log('server running at http://127.0.0.1:8080');
})