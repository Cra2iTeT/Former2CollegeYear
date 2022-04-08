// 导入数据库模块
const db = require('../db/index')

// 导入bcryptjs
const bcryptjs = require('bcryptjs')

// 注册新用户的处理函数
exports.regUser = (req, res) => {
    const userInfo = req.body

    // 校验表单数据
    if(!userInfo.username || !userInfo.password) {
        return res.send({ status: 1, message: "用户名或密码不合法"})
    }

    // 查询账号是否占用
    let sqlStr = 'select * from ev_users where username = ?'
    db.query(sqlStr, [userInfo.username], function (err, results) {
        if (err) {
            // return res.send({status: 1, message: err.message})
            return res.cc(err)
        }

        if (results.length > 0) {
            // return res.send({status: 1, message: "用户名已经被占用，请更换其他用户名！"})
            return res.cc('用户名已经被占用，请更换其他用户名！')
        }

        // 加密密码
        userInfo.password = bcryptjs.hashSync(userInfo.password, 10)

        sqlStr = 'insert into ev_users set ?'
        db.query(sqlStr, {username: userInfo.username, password: userInfo.password}, function (err, results) {
            if (err) {
                // return res.send({status: 1, message: err.message})
                return res.cc(err)
            }

            if (results.length !== 1) {
                // return res.send({status: 1, message: "注册用户失败，请稍后再试"})
                return res.cc('注册用户失败，请稍后再试')
            }

            // return res.send({status: 1, message: "注册成功"})
            return res.cc(1,注册成功)
        })
    })
}

// 登录处理函数
exports.login = (req, res) => {
    res.send("reguser ok")
}