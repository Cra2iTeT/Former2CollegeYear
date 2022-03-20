window.onload = function () {
    $.ajax({
        url: '/user/getSessionId',
        type: "POST",
        success(data) {
            $.ajax({
                url: '/user/showInfoById',
                data: 'id=' + data,
                type: 'POST',
                success(data) {
                    console.log(data);
                    console.log(JSON.parse(JSON.stringify(data)).id);
                    let str = "<span>" + data[8];
                    alert(str);
                },
                error() {
                    alert("连接失败");
                }
            })
        }
    })
}