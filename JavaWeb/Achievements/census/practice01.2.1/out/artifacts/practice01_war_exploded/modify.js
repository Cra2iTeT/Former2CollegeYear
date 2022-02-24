function checkId(){
    let id=document.getElementById('id').value;
    let reg = /(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if(reg.test(id)==false){
        alert("身份证输入不合法");
        return false;
    }
}