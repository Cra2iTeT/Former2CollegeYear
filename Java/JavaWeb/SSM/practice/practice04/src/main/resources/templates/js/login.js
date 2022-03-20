function login() {
    console.log("=>函数执行")
    let id = document.getElementById('id').value;
    let password = document.getElementById('password').value;

    if (id === '') {
        alert("账号不能为空");
    } else if (password === '') {
        alert("密码不能为空");
    } else {
        $.ajax({
            url: "/login",
            type: "POST",
            async: false,
            data: {
                'id': $('#id').val(),
                'password': $('#password').val()
            },
            success(data) {
                if (data === "login success") {
                    window.location.href = "../main.html"
                } else if (data === "password error") {
                    alert("密码错误")
                } else {
                    alert("账号不存在")
                }
            }
        })
    }
}