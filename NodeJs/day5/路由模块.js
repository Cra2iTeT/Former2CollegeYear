let express = require('express')
let app = express()

const router = require('./router')

app.use(router)

app.listen(8080, () => {
    console.log('express server running at http://12700.0.1:8080');
})