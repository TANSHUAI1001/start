var ManagementResource = function(){
  var load = function(){
        var table = $('#example').DataTable({
                serverSide:true,
                ajax:{
                  url:"/sys/resource",
                  dataType: "json",
                  data:fix_data_format
                },
                columns: [
                {title:"ID",data:"id"},
                {title:"名称",data:"name"},
                {title:"描述",data:"description"},
                {title:"类型",data:"type"},
                {title:"级别",data:"level"},
                {title:"父节点",data:"parent"},
                {title:"优先级",data:"priority"},
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