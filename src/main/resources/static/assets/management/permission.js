var ManagementPermission = function(){
  var load = function(){
          $('#example').DataTable({
            serverSide:true,
            ajax:{
              url:"/sys/permission",
              data:fix_data_format
            },
            searching: false,
            autoWidth: false,
            columns: [
                {title:"ID",orderable:false,render:function(data,type,row,meta){
                  return meta.row+1;
                 }},
                {title:"值",data:"value"},
                {title:"描述",data:"description"},
                {title:"类型",data:"type"},
            ]
        });
  }

  return {
    load:load
  }

}()