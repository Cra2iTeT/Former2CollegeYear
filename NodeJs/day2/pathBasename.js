const path = require('path')

const fpath = '/a/b/c/index.html'

var fullName = path.basename(fpath)

console.log(fullName);

// var extName = path.basename(fpath,'.html')
// console.log(extName);

var fext = path.extname(fpath)
console.log(fext);