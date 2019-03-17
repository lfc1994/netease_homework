<%--
  Created by IntelliJ IDEA.
  User: BabyChen
  Date: 2019/3/15
  Time: 16:15
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
</div><div class="g-doc">
    <div class="n-result">
        <h3>编辑成功！</h3>
        <p>
            <a href="/show?id=${pid}">[查看内容]</a>
            <a href="/">[返回首页]</a>
        </p>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
</body></html>
