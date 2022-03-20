function check1(){
    let len=document.getElementById('id').value.length;
    if (len!=8){
        alert("学号输入位数错误，应当为8位数字")
    }
}
function check2(){
    let len=document.getElementById('phone').value.length;
    console.log(len);
    if (len!=11){
        alert("联系电话输入位数错误，应当为11位数字")
    }
}