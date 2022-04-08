const http = require('http')
const fs = require('fs')
const path = require('path')

const server = http.createServer()

server.on('request', (req, resp) => {
    const url = req.url

    const fPath = path.join(__dirname, '../day2', url)
    console.log(fPath);

    fs.readFile(fPath, 'utf-8', function(err, dataStr) {
        if (err) {
            console.log("404 not found" + err.message);
        }
        
        // 加上响应头以后css样式无法显示
        // resp.setHeader('Content-Type', 'text/html; charset=utf-8')
        resp.end(dataStr)
    })
})

// server.on('request', (req, resp) => {
//     const url = req.url

//     let fPath = ''
//     if (url === '/' || url === '/clock/index.html' || url === '') {
//         fPath = path.join(__dirname, '../day2', '/clock/index.html')
//     } else {
//         fPath = path.join(__dirname, '../day2', url)
//     }

//     console.log(fPath);

//     fs.readFile(fPath, 'utf-8', function(err, dataStr) {
//         if (err) {
//             console.log("404 not found " + err.message);
//         }
//         // 加上响应头以后css样式无法显示
//         // resp.setHeader('Content-Type', 'text/html; charset=utf-8')
//         resp.end(dataStr)
//     })
// })

server.listen(8080, () => {
    console.log('server running at http://127.0.0.1:8080');
})