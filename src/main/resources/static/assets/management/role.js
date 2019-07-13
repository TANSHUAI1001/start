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
    $('#rolePermissionModal').modal({
      keyboard: false
    });
    if(ManagementRole.rolePermissionTable){
      ManagementRole.rolePermissionTable.destroy();
    }

    ManagementRole.rolePermissionTable = $('#rolePermissionTable').DataTable({
    serverSide:true,
    ajax:{
      url:"/sys/rolePermission",
      data:function(d){
        d.roleId = id;
        return fix_data_format(d);
      }
    },
    lengthChange: false,
    pageLength: 5,
    searching: false,
    autoWidth: false,
    columns: [
        {title:"ID",orderable:false,render:function(data,type,row,meta){
          return meta.row+1;
         }},
        {title:"值",data:"value"},
        {title:"描述",data:"description"},
        {title:"类型",data:"type"},
        {title:"是否拥有",data:"hasPermission",render: function(data,type,row,meta){
          if(data == 1) return "<span class='label label-success'>是</span>";
          return "<span class='label label-danger'>否</span>";
        }},
        {title:"操作",render: function(data,type,row,meta){
          if(row.hasPermission == 1) return "<div class='label label-danger permission-remove' "+
          "role='button' onclick='ManagementRole.removePermission("+row.id+","+id+")' >" +
          "<i class='fa fa-fw fa-minus-square'></i>移除</div>";
          return "<div class='label label-success permission-add' "+
          "role='button' onclick='ManagementRole.addPermission("+row.id+","+id+")' >"+
          "<i class='fa fa-fw fa-plus-square'></i>增加</div>";
        }},
    ]
    });
  }


  var removePermission = function(pid,rid){
    console.log(pid,rid);
    console.log("remove");
    $.post("/sys/updateRolePermission",{roleId:rid,permissionId:pid,state:0},function(res){
      console.log(res);
    });
    ManagementRole.rolePermissionTable.draw('page');
  }
  var addPermission = function(pid,rid){
    console.log(pid,rid);
    console.log("add");
    $.post("/sys/updateRolePermission",{roleId:rid,permissionId:pid,state:1},function(res){
      console.log(res);
    });
    ManagementRole.rolePermissionTable.draw('page');
  }
  return {
    load:load,
    search:search,
    getPermission:getPermission,
    removePermission:removePermission,
    addPermission:addPermission
  }

}()