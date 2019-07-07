var ManagementUser = function(){
  var load = function(){
          $('#example').DataTable({
            serverSide:true,
            ajax:{
              url:"/sys/user",
              data:fix_data_format
            },
            'autoWidth':false,
            columns: [
                {title:"ID",data:"id"},
                {title:"用户名",data:"username"},
                {title:"联系电话",data:"telephone"},
                {title:"Email",data:"email"},
                {title:"salt",data:"salt"},
                {title:"创建时间",data:"createTime",render:function(data,type,row,meta){
                  return moment(data).format('YYYY-MM-DD HH:mm:ss');
                }},
                {title:"状态",data:"state",render:function(data,type,row,meta){
                  if(data == "1"){
                    return "正常";
                  }else if(data == "-1"){
                    return "锁定";
                  }else{
                    return "已删除";
                  }
                }},
            ]
        });
  }

  return {
    load:load
  }

}()