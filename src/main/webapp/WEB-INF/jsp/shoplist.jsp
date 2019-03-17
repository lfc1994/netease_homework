<%--
  Created by IntelliJ IDEA.
  User: BabyChen
  Date: 2019/3/13
  Time: 15:59
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
</div><div class="g-doc" id="settleAccount">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已添加到购物车的内容</h2>
    </div>
    <table id="newTable" class="m-table m-table-row n-table g-b3">
        <tbody>
        <tr><th>内容名称</th><th>数量</th><th>价格</th></tr>
        <tr>
            <c:forEach items="${shoplist}" var="p">
            <td>${p.title}</td>
            <td>
                <span class="lessNum">-</span>
                <span class="totalNum" id="allNum">${p.number}</span>
                <span id="thisId">${p.id}</span>
                <span class="moreNum">+</span>
            </td>
            <td>${p.price}</td>
            </c:forEach>
        </tr>
        </tbody>
    </table>
    <div id="act-btn"><button class="u-btn u-btn-primary" id="back">退出</button>
        <button class="u-btn u-btn-primary" id="Account">购买</button></div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div><script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/settleAccount.js"></script><div style="display: none;"></div><div style="display: none;"></div>

</body></html>
