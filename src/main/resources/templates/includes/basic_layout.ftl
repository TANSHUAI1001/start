<#include "main_header.ftl">
<#include "left_sidebar.ftl">
<#include "main_footer.ftl">
<#include "control_sidebar.ftl">
<#macro BasicLayout>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Starter</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
    page. However, you can choose any other skin. Make sure you
    apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="/dist/css/skins/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <@MainHeader />

    <!-- Left side column. contains the logo and sidebar -->
    <@LeftSidebar />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <!-- Main content -->

        <#nested>

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <@MainFooter />

    <!-- Control Sidebar -->
    <@ControlSidebar />
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>
<!-- DataTables -->
<script src="/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script>
    $.fn.dataTable.defaults.oLanguage = {
    "sProcessing": "处理中...",
    "sLengthMenu": "每页显示 _MENU_ 条记录",
    "sZeroRecords": "没有匹配结果",
    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
    "sInfoPostFix": "",
    "sSearch": "搜索：",
    "sUrl": "",
    "sEmptyTable": "表中数据为空",
    "sLoadingRecords": "载入中...",
    "sInfoThousands": ",",
    "oPaginate": {
        "sFirst": "首页",
        "sPrevious": "上页",
        "sNext": "下页",
        "sLast": "末页"
    },
    "oAria": {
        "sSortAscending": ": 升序",
        "sSortDescending": ": 降序"
    }
};

var fix_data_format = function(d){
    var convert = {};
    for(var item in d){
      if(typeof(d[item]) == "object"){ // 对象层（或数组）
        //console.log(d[item]);
        var arr = d[item];
        for(var arrIndex in arr){ // 对象内嵌一层
          //console.log(arrIndex,arr[arrIndex]);
          if(typeof( arr[arrIndex]) == "object"){
              for(var arrItem in arr[arrIndex]){ // 对象内嵌二层
              if(typeof( arr[arrIndex][arrItem]) == "object"){
                for(var sub in arr[arrIndex][arrItem]){ // 对象内嵌二层所有属性
                  convert[item+"["+arrIndex+"]."+arrItem+"."+sub] = arr[arrIndex][arrItem][sub];
                }
              }else{
               convert[item+"["+arrIndex+"]."+arrItem] = arr[arrIndex][arrItem];
              }
             }
         }else{
          convert[item+"."+arrIndex] = arr[arrIndex];
         }

        }
      }else{
        convert[item] = d[item];
      }
    }
    //console.log(d);
    //console.log(convert);
    return convert;
  }
</script>
</body>
</html>
</#macro>