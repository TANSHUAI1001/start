var ManagementRole = function(){
  var load = function(){
          $('#example').DataTable({
            serverSide:true,
            ajax:{
              url:"/sys/role",
              data:fix_data_format
            },
            searching: false,
            autoWidth: false,
            columns: [
                {title:"ID",orderable:false,render:function(data,type,row,meta){
                  return meta.row+1;
                 }},
                {title:"名称",data:"name"},
                {title:"描述",data:"description"},
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