const fs = require('fs')
const path = require('path')

// 定义正则表达式，分别匹配style和script
const regStyle = /<style>[\s\S]*<\/style>/
const regScript = /<script>[\s\S]*<\/script>/

fs.readFile (path.join(__dirname, './clock/index.html'), 'utf-8', function(err, dataStr) {
    if (err) {
        return console.log("读取HTML文件失败" + err.message);
    }

    resolveCSS(dataStr)
    resolveJs(dataStr)
    resolveHtml(dataStr)
})

// 定义处理css样式的方法
function resolveCSS(cssStr) {
    // 使用正则提取需要的内容
    const r1 = regStyle.exec(cssStr)

    // 将提取出来的样式字符串，进行字符串的replace替换操作
    const newCss = r1[0].replace('<style>', '').replace('</style>', '')

    // 将提取的样式，存储到index.css文件中
    fs.write(path.join(__dirname, "./clock/index.css"), newCss, function(err) {
        if (err) {
            return console.log("css文件写入失败" + err.message);
        }
        console.log("css文件写入成功");
    })
}

// 定义处理js样式的方法
function resolveJs(JsStr) {
    // 使用正则提取需要的内容
    const r2 = regScript.exec(JsStr)

    // 将提取出来的样式字符串，进行字符串的replace替换操作
    const newJs = r2[0].replace('<script>', '').replace('</script>', '')

    // 将提取的样式，存储到index.css文件中
    fs.write(path.join(__dirname, "./clock/index.js"), newJs, function(err) {
        if (err) {
            return console.log("js文件写入失败" + err.message);
        }
        console.log("js文件写入成功");
    })
}

// 定义处理html文件的方法
function resolveHtml(htmlStr) {
    // 将字符串调用replace方法，把内嵌的style和script替换成内联标签
    const newHtml = htmlStr.replace(regStyle, '<link rel="stylesheet" href="./index.css" />')
    .replace(regScript, '<script src="./index.js"></script>')

    // 写入html文件
    fs.write(path.join(__dirname, './clock/index.html'), newHtml, function(err) {
        if (err) {
            return console.log("html文件写入失败" + err.message);
        }

        console.log("文件写入成功");
    })
}