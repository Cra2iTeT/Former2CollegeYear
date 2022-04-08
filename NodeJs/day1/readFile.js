const fs = require('fs')

fs.readFile('./files/11.txt','utf-8',function(err,daraStr){
    //读取成功err为null
    //读取失败err为错误对象，dataStr为undefined
    console.log(err)
    console.log('-----')

    console.log(daraStr)
})