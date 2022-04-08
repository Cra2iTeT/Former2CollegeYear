const path = require('path')
const fs = require('fs')

// C:\CS\Node.js>node day2\path.js
// 文件打开成功

// C:\CS\Node.js\day2>node path.js
// 文件打开成功

fs.readFile(path.join(__dirname,'../day1/files/1.txt'),function(err){
    if (err) {
        return console.log("文件打开失败"+err.message);
    }
    return console.log("文件打开成功");
})