const fs = require('fs')

fs.readFile('./files/1.txt','utf-8',function(err,daraStr){
    if(err){
        return console.log('读取文件失败'+err.message)
    }
    console.log(daraStr)

})