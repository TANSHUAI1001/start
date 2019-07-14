var ManagementResource = function(){
  var load = function(){
        var table = $('#example').DataTable({
                serverSide:true,
                ajax:{
                  url:"/sys/resource",
                  data:fix_data_format
                },
                autoWidth: false,
                columns: [
                    {title:"序号",render:function(data,type,row,meta){
//                      console.log(data,type,row,meta)
                      return meta.row+1;
                    }},
                    {title:"名称",data:"value"},
                    {title:"中文名称",data:"name"},
                    {title:"权限",data:"permission"},
                    {title:"类型",data:"type"},
                    {title:"级别",data:"level"},
                    {title:"上级节点",data:"parentName"},
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
                ],
//                ordering: false,
                columnDefs:[
                  { "orderable": false, "targets": [0,1,2,7] }
                ],
                 order: [[ 4, 'asc' ], [ 6, 'asc' ]] // 动态不能用负数
            });
  }

  return {
    load:load
  }

}()