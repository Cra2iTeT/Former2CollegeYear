const { match } = require("assert")

function dateFormat(dataStr) {
    const dt = new Date(dataStr)

    const y = padZero(dt.getFullYear())
    const m = padZero(dt.getMonth() + 1)
    const d = padZero(dt.getDay())

    const hh = padZero(dt.getHours())
    const mm = padZero(dt.getMinutes())
    const ss = padZero(dt.getSeconds())

    return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
}

function padZero(n) {
    return n > 9 ? n : '0' + n
}

function htmlEscape(htmlStr) {
    return htmlStr.replace(/<|>|"|&/g, (match) => {
        switch (match) {
            case '<':
                return '&lt';
            case '>':
                return '&gt';
            case '"':
                return '&quot';
            case '&':
                return '&amp';
        }
    })
}

function htmlUnEscape(htmlStr) {
    return htmlStr.replace(/&lt|&gt|&quot|&amp/g, (match) => {
        switch(match) {
            case '&lt':
                return '<';
            case '&gt':
                return '>';
            case '&quot':
                return '"';
            case '&amp':
                return '&';
        }
    })
}

module.exports = {
    dateFormat,
    htmlEscape,
    htmlUnEscape
}