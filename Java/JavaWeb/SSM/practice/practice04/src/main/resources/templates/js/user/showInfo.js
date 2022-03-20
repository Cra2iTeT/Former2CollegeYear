function showInfo() {
    $.ajax({
        url: '/user/getSessionId',
        type: "POST",
        success() {
            window.location.href = '../../showInfoById.html'
        }
    })
}