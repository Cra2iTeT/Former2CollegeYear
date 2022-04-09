function peekCity() {
    $.ajax({
        url: '/peekCity',
        data: "",
        type: "post",
        success: function (data) {
            let str = data.split(';');
            $('#selectCity').empty()
            for (let i = 0; i < str.length; i++) {
                let strNameZh = str[i].substr(str[i].indexOf(',') + 1)
                let tempStr = "<option value=" + str + ">" + strNameZh + "市" + "</option>"
                $('#selectCity').append(tempStr)
            }
        }
    })
}

function selectCity() {
    console.log('commons请求访问' + document.getElementById('selectCity').value + '市的所有线路')
    $.ajax({
        url: '/commonsToIndex',
        type: 'post',
        data: 'cityName=' + document.getElementById('selectCity').value,
        success: function (data) {
            console.log("success")
            self.location = '/toIndex';
        }
    })
}

function select() {
    console.log('commons请求访问' + document.getElementById('selectCity').value + '市的所有线路')
    $.ajax({
        url: '/selectCity',
        type: 'post',
        data: 'cityName=' + document.getElementById('selectCity').value,
        success: function (data) {
            let str = data.split(';')
            $('#topWelcomeH2').html(str[0])
            console.log("当前加载的是" + str[1] + "市地铁图")
            $.ajax({
                url: '/getAllLines',
                type: 'post',
                success: function (data) {
                    console.log(data)
                }
            })
        }
    })
}

function oneLoad() {
    $.ajax({
        url: '/oneLoad',
        type: 'post',
        data: "",
        success: function (data) {
            console.log(data)

            let sel = document.getElementById('selectCity')
            let ops = sel.getElementsByTagName('option')
            let len = sel.options.length

            if (data !== "null") {
                document.getElementById('selectCity').value = data

                let tempFlag = 0;
                for (let i = 0; i < len && tempFlag === 0; i++) {
                    if (ops[i].value === data) {
                        ops[i].selected = true
                        tempFlag = 1
                    }
                }
            } else {
                document.getElementById('selectCity').value = "beijing,北京"
                ops[0].selected = true
            }
            select()
        }
    })
}

function addLoadEvent(func) {
    var oldonload = window.onload; //把现在有window.onload事件处理函数的值存入变量oldonload。
    if (typeof window.onload != 'function') { //如果这个处理函数还没有绑定任何函数，就像平时那样把新函数添加给它
        window.onload = func;
    } else { //如果在这个处理函数上已经绑定了一些函数。就把新函数追加到现有指令的末尾
        window.onload = function () {
            oldonload();
            func();
        }
    }

}

addLoadEvent(peekCity);
addLoadEvent(oneLoad);