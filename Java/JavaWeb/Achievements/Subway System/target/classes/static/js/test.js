function sub() {
    var lineList = new Array();
    var StationNum = document.getElementById("StationNum").value;
    while (i < StationNum) {
        lineList.push(document.getElementsByClassName())
    }
    var lineId = document.getElementById("lineId");
    var isRing = document.getElementById("isRing");
    7
    var stationName = document.getElementsByClassName("stationName");
    var stationIds = document.getElementsByClassName("stationId");
    console.log(stationIds)
    var stationList = [stationName, stationIds];

    console.log(stationList)
    $.ajax({
        type: "post",
        url: "/insertLine",
        data: {
            'stationList': stationList,
            'lineId': lineId,
            'isRing': isRing
        },
        success: function (data) {
            if (data) {
                alert("操作成功");
            } else {
                alert("操作失败");
            }
        }
    });
}