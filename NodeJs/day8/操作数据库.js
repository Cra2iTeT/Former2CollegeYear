const mysql = require('mysql')

const db = mysql.createPool({
    // 数据库的ip地址
    host: 'localhost',
    user: 'root',
    password: '123456',
    // 指定要操作的数据库
    database: 'lesson'
})

// 测试
// db.query('select 1', (err, results) => {
//     if (err) {
//         return console.log(err.message);
//     }
//     console.log(results);
// })

// db.query('select * from beijingline', (err, results) => {
//     if (err){
//         return console.log(err.message);
//     }
//     // 执行select语句返回的是数组
//     return console.log(results);
// })

// const data = {line_id: "1", line_name: "一号线", station_id: "101,102"}
// db.query('insert into jinanline (line_id, line_name, station_id) values (?,?,?)', [data.line_id, data.line_name, data.station_id], (err, results) => {
//     if (err) {
//         return console.log(err.message);
//     }
//     if (results.affectedRows === 1) {
//         console.log("插入成功");
//     }
// })

// 如果属性一一对应，可以简写
const data = {line_id: "1", line_name: "一号线", station_id: "101,102"}
db.query('insert into jinanline set ?', data, (err, results) => {
    if (err) {
        return console.log(err.message);
    }
    if (results.affectedRows === 1) {
        console.log("插入成功");
    }
})