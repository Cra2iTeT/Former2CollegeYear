var btn = document.getElementById("");

btn.onclick=function(){
    var city=document.getElementById("cityName");
    var cityName = city.split(',')
    var selectCity = document.getElementById("selectCity");
    //citiName[1]为需要的文字
    if(cityName==null)
    {
        alert("输入内容为空")
    }
    selectCity.append("<option value='city'>" + cityName[1] + "</option>");
}