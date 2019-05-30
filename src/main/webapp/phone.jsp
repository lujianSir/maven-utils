<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script src="<%=basePath %>/js/jquery-3.1.1.min.js"></script>
  <script>
    function getBasePath(){
        return '<%=basePath%>';
    }
  </script>
</head>
<body>
   <form>
       <div>
           账号: <input name="userId">
       </div>
       <div>
           密码: <input name="password">
       </div>
       <div>
           手机号: <input name="number">
       </div>
       <div>
           验证码: <input name="verifyCode"><button type="button" class="sendVerifyCode">获取短信验证码</button>
       </div>
       <div><button type="button" class="sub-btn">提交</button></div>
   </form>
</body>
</html>
<script>
$(function(){ 
    //发送验证码
    $(".sendVerifyCode").on("click", function(){
        var number = $("input[name=number]").val();
        $.ajax({
            url: getBasePath()+"/sendSms.do",
            async : true,
            type: "post",
            dataType: "json",
            data: {"number":number},
            success: function (data) {
                if(data == 'fail'){
                    alert("发送验证码失败");
                    return ;
                }
            }
        });
    })
    //提交
    $(".sub-btn").on("click", function(){
        var data = {};
        data.userId = $.trim($("input[name=userId]").val());
        data.password = $.trim($("input[name=password]").val());
        data.number = $.trim($("input[name=number]").val());
        data.verifyCode = $.trim($("input[name=verifyCode]").val());
        $.ajax({
            url: getBasePath()+"/register.do",
            async : true,
            type: "post",
            dataType: "json",
            data: data,
            success: function (data) {
                if(data == 'fail'){
                    alert("注册失败");
                    return ;
                }
                alert("注册成功");
            }
        });
    })
});

</script>