const fs = require('fs')

fs.readFile('./files/3.txt','utf-8',function(err,daraStr) {
    if(err) {
        return console.log('读取文件失败'+err.message)
    }
    
    const arrOld = daraStr.split(' ')

    const arrNew = []
    arrOld.forEach(item => {
        arrNew.push(item.replace('=','：'))
    })

    const newStr = arrNew.join('\r\n')

    fs.writeFile('./files/4.txt',newStr,function(err) {
        if (err) {
            return console.log("文件写入失败"+err.message);
        }
        return console.log("文件写入成功");
    })

    fs.close()
})