const fs = require('fs')

fs.writeFile('./files/2.txt','Cra2iTeT','utf-8',function(err){   
    //写入成功err为空
    //失败就为错误对象
    console.log(err)
})