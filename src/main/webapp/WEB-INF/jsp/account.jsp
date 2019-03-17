<%--
  Created by IntelliJ IDEA.
  User: BabyChen
  Date: 2019/3/14
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>java</title>
    <link rel="stylesheet" href="/css/style.css">
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            买家你好，<span class="name">${user.name}</span>！<a href="/logout">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <li><a href="/accountdetail">账务</a></li>
            <li><a href="/settleAccount">购物车</a></li>
        </ul>
    </div>
</div><div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"><col><col class="time"><col><col class="number"><col><col class="price"><col></colgroup>
        <thead>
        <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买数量</th><th>购买价格</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${accountUtilList}" var="a">
        <tr>
            <td><a href="/show?id=${a.pid}"><img src="${a.filePath}" alt=""></a></td>
            <td><h4><a href="/show?id=${a.pid}">${a.name}</a></h4></td>
            <td><span class="v-time">${a.timeString}</span></td>
            <td><span class="v-number">${a.num}</span></td>
            <td><span class="v-unit">¥</span><span class="value">${a.price}</span></td>
        </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4"><div class="total">总计：</div></td>
            <td><span class="v-unit">¥</span><span class="value">${totalPrice}</span></td>
        </tr>
        </tfoot>
    </table>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
</body></html>
