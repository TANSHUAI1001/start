var FundData = function(){
  var load = function(){
        var table = $('#example').DataTable({
                serverSide:true,
                ajax:{
                  url:"/api/fund",
                  data:fix_data_format
                },
                searching: false,
                ordering: true,
//                autoWidth: false,
                scrollX: true,
                formatNumber: function ( toFormat ) {
                     //使用正则表达式匹配，替换数字
                    return toFormat.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                 }, // 解决自带解析数字设置自定义语言导致逗号undefined
                order: [[ 1, 'asc' ],], // 动态不能用负数
                columns: [
                    {title:"序号",data:"id",orderable:false,render:function(data,type,row,meta){
                      return meta.row+1;
                    }},
                    {title:"代码",data:"tsCode",orderable:true},
                    {title:"名称",data:"name",orderable:false},
                    {title:"管理人",data:"management",orderable:false},
                    {title:"托管人",data:"custodian",orderable:false},
                    {title:"投资类型",data:"fundType",orderable:false},
                    {title:"管理费(%)",data:"mFee",orderable:true},
                    {title:"托管费(%)",data:"cFee",orderable:true},
                    {title:"业绩比较基准",data:"benchmark",orderable:false},
                    {title:"投资风格",data:"investType",orderable:false},
                    {title:"基金类型",data:"type",orderable:false},
                    {title:"存续状态",data:"status",orderable:false,render:function(data){
                      switch(data){
                        case "D":return "摘牌";
                        case "I":return "发行";
                         case "L":return "已上市";
                      }
                    }},
                    {title:"交易市场",data:"market",orderable:false,render:function(data,type,row,meta){
                      if(data == "E"){
                        return "场内";
                      }else if(data == "O"){
                        return "场外";
                      }else{
                        return data;
                      }
                    }},
                ]
            });
  }

  return {
    load:load
  }

}()