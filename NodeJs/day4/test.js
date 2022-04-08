// 传统方式
// const Time = require('./dataFormat')

// const dt = new Date()

// const newDt = Time.dateFormat(dt)
// console.log(newDt);


// 通过导入第三方包形式
// const moment = require('moment')

// const dt = moment().format('YYYY-MM-DD HH-mm-ss')
// console.log(dt);


// 导入自己的包
const Cra2iTeT = require('../Cra2iTeT-tools')
// const dt = new Date()
// const newDt = Cra2iTeT.dateFormat(dt)
// console.log(newDt);

const htmlStr = '<h1 title="abc">这是一个h1标签<span>123&nbsp;</span></h1>'
let str = Cra2iTeT.htmlEscape(htmlStr)
console.log(str);

str = Cra2iTeT.htmlUnEscape(str)
console.log(str);