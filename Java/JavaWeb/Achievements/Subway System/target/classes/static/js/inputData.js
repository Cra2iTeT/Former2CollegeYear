// var btnadd = document.getElementById("btnadd");
let stationNum = 0;

function add() {
    var i = 0;
    var stationTable = document.getElementById("stationTable");
    var StationNum = document.getElementById("StationNum").value;
    stationNum = Number(StationNum) + Number(stationNum);
    //总站数
    console.log("i  " + i)
    console.log("stationNum  " + stationNum)
    console.log(StationNum)
    while (i < StationNum) {
        let tempStation = "stationName";
        let tempStaionId = "stationId";
        stationTable.innerHTML += "<tr>\n" +
            "<td>" + "<input type='text' name='stationName'</td>" +
            "<td>" + "<input type=\'text\' name='stationId'</td>" +
            "</tr>"
        i++;
    }
}

// var btnsub = document.getElementById("btnsub")
function sub() {
    var stationList = new Array();
    let i = 0;
    // var StationNum = document.getElementById("StationNum").value;

    while (i < stationNum) {
        // let tempStation = "stationName";
        // let tempStationId = "stationId";
        stationList.push(document.getElementsByName("stationName")[i].value);
        stationList.push(document.getElementsByName("stationId")[i].value);

        i++;
    }
    var lineId = document.getElementById("lineId").value;
    var isRing = $("input[name='isRing']:checked").val();
    var lineName = document.getElementById("lineName").value;

    // var stationList = [stationName, stationId];
    console.log(stationList)

    let tempData = new Object();
    tempData.stations = stationList;
    tempData.lineId = lineId;
    tempData.isRing = isRing;
    tempData.lineName = lineName;

    $.ajax({
        type: "post",
        url: "/insertLine",
        dataType: 'json',
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify(tempData),
        success: function (data) {
            if (data === "success") {
                alert("操作成功");
            } else {
                alert("操作失败");
            }
        }
    });
}