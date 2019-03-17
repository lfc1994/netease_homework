<%--
  Created by IntelliJ IDEA.
  User: BabyChen
  Date: 2019/3/10
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>java</title>
    <link rel="stylesheet" href="/css/style.css">
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            请<a href="/login">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
        </ul>
    </div>
</div>
<form class="m-form m-form-ht n-login" method="post" action="loginIn" id="form" >
    <div class="fmitem">
        <label class="fmlab">用户名：</label>
        <div class="fmipt">
            <input class="u-ipt" id="name" name="name" autofocus="">
        </div>
    </div>
    <div class="fmitem">
        <label class="fmlab">密码：</label>
        <div class="fmipt">
            <input class="u-ipt" type="password" id="password" name="password">
        </div>
    </div>
    <div class="fmitem fmitem-nolab fmitem-btn">
        <div class="fmipt">
            <button type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block">登 录</button>
        </div>
    </div>
</form>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script>
    var msg = "${msg}";
    if(msg !== ""){
        alert(msg);
    }
    $(function () {
        if(!$("#refer").val()){
            $("#refer").val(document.referrer);
        }
        $("#form").submit(function () {
            if($("#password").val() == "" || $("#name").val() == ""){
                alert("用户名或密码为空");
                return false;
            }
            // alert(md5($("#password").val()));
            $("#password").val(md5($("#password").val()));
            return true;
        });
    });
</script>

<script type="text/javascript" src="/js/md5.js"></script>
<!--<script type="text/javascript" src="/js/global.js"></script>-->
<!--<script type="text/javascript" src="/js/pageLogin.js"></script>-->





<div style="display: none;">

</div>

</body></html>
