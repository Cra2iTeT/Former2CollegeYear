// console.log(module);

// 执行顺序不同，结果也不同
// module.exports = {
//     name : 'Cra2iTeT',
//     hi() {
//         console.log('hi');
//     }
// }

// 挂在userName属性
module.exports.userName = '张三'

module.exports.hello = function() {
    console.log('hello');
}

module.exports = {
    name : 'Cra2iTeT',
    hi() {
        console.log('hi');
    }
}