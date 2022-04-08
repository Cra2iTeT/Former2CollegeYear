const fs = require('fs')

// 执行C:\CS\Node.js>node .\day2\fsRoad.js
// 文件打开失败ENOENT: no such file or directory, open 'C:\CS\day1\files\1.txt'

// 执行C:\CS\Node.js\day2>node fsRoad.js
// 文件打开成功

// fs.readFile('../day1/files/1.txt','utf-8',function(err){
//     if (err) {
//         return console.log("文件打开失败"+err.message);
//     }
//     return console.log("文件打开成功");
// })


// 解决方法一：绝对路径————不推荐使用

// 执行C:\CS\Node.js>node .\day2\fsRoad.js
// 文件打开成功

// fs.readFile('C:\\CS\\Node.js\\day1\\files\\1.txt','utf-8',function(err){
//     if (err) {
//         return console.log("文件打开失败"+err.message);
//     }
//     return console.log("文件打开成功");
// })


// 解决方法二：动态拼接__dirname
// 这个只能使用与项目同文件夹下的，例如下面一样打开失败

// fs.readFile(__dirname + '/day1/files/1.txt','utf-8',function(err){
//     if (err) {
//         return console.log("文件打开失败"+err.message);
//     }
//     return console.log("文件打开成功");
// })