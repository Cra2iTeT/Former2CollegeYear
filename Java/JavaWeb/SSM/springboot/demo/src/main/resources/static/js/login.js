import("./jquery-3.6.0")

function login() {
    let username = document.getElementById("name").value;
    let password = document.getElementById("password").value;

    console.log(username);
    console.log(password);

    $.post({
        url: "${pageContext.request.contextPath}/login",
        data: {'username': username, 'password': password},
        success: function (data) {
            if()
        }
    });
}