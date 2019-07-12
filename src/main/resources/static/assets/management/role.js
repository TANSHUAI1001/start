var ManagementRole = function(){
  var table;
  var load = function(){
          table = $('#example').DataTable({
            serverSide:true,
            ajax:{
              url:"/sys/role",
              data:function(d){
              return{
                draw: d.draw,
                start: d.start,
                length: d.length,
                name: $("#name-search").val(),
                state: $("#state-search").val()
               }
              }

            },
            dom: "frtlip",
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
                {title: "权限",render:function(data,type,row,meta){
                  return '<a href="#'+row.name+'" onclick="ManagementRole.getPermission('+row.id+')">查看</a>';
                }}

            ]
        });
  }

  var search = function(){
     table.draw();
  }

  var getPermission = function(id){
   console.log(id);
  }

  return {
    load:load,
    search:search,
    getPermission:getPermission
  }

}()