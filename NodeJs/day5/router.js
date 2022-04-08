const express = require('express')

const router = express.Router()

// 挂载具体路由模块
router.get('/user/list', function(req, resp) {
    resp.send('Get')
})

router.post('/user/add', function(req, resp) {
    resp.send('Post')
})

module.exports = router