<%--
  Created by IntelliJ IDEA.
  User: BabyChen
  Date: 2019/3/12
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>java</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
<div class="n-head">
    <c:if test="${empty user}">
        <div class="g-doc f-cb">
            <div class="user">
                请<a href="/login">[登录]</a>
            </div>
            <ul class="nav">
                <li><a href="/">首页</a></li>
            </ul>
        </div>
    </c:if>
    <c:if test="${user.group=='superAdmin'}">
        <%--<a href="admin/">网站后台</a>--%>
        <div class="g-doc f-cb">
            <div class="user">
                卖家你好，<span class="name">${user.name}</span>！<a href="/logout">[退出]</a>
            </div>
            <ul class="nav">
                <li><a href="/">首页</a></li>
                <li><a href="/public">发布</a></li>
            </ul>
        </div>
    </c:if>
    <c:if test="${user.group=='user'}">
        <%--<a href="/">网站后台</a>--%>
        <div class="g-doc f-cb">
            <div class="user">
                买家你好，<span class="name">${user.name}</span>！<a href="/logout">[退出]</a>
            </div>
            <ul class="nav">
                <li><a href="/">首页</a></li>
                <li><a href="/public">账务</a></li>
                <li><a href="/settleAccount">购物车</a></li>
            </ul>
        </div>
    </c:if>
</div>
<div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="/img/${product.file}" alt=""></div>
        <div class="cnt">
            <h2>${product.name}</h2>
            <p class="summary">${product.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${product.nowPrice}</span>
            </div>
            <div class="number">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">1</span><span id="addNum" class="moreNum"><a>+</a></span></div>
            <div class="oprt f-cb">
                <c:if test="${user.group=='superAdmin'}">
                <a href="/edit?id=${pid}" class="u-btn u-btn-primary">编 辑</a>
                </c:if>
                <c:if test="${user.group=='user'}">
                    <c:if test="${isSold == 'true'}">
                        <span class="u-btn u-btn-primary z-dis">已购买</span>
                        <c:if test="${product.originalPrice >=0}">
                            <span class="buyprice">当时购买价格：¥${product.originalPrice}</span>
                        </c:if>
                    </c:if>
                    <c:if test="${isSold != 'true'}">
                        <button class="u-btn u-btn-primary" id="add" data-id="${pid}" data-title="${product.name}" data-price="${product.nowPrice}">
                            加入购物车</button>
                    </c:if>
                </c:if>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${product.detail}
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div><script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageShow.js"></script><div style="display: none;"></div><div style="display: none;"></div>

</body></html>
