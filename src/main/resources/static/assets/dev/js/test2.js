var test2 = function(){
  var count = function(){
    var para = 1;
    for(var i = 0; i < 10; i++){
      para = (para + i * para) * 10 << 2;
      para = para % 12;
    }
    console.log("testing ... "+para);
}
return{
  count:count
}
}
