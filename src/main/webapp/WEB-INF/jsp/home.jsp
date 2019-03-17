<%--
  Created by IntelliJ IDEA.
  User: BabyChen
  Date: 2019/3/10
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>java</title>
    <link rel="stylesheet" href="/css/style.css"/>
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
                <li><a href="/accountdetail">账务</a></li>
                <li><a href="/settleAccount">购物车</a></li>
            </ul>
        </div>
    </c:if>
</div>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <c:if test="${user.group=='user'}">
                        <c:if test="${isALL.equals(Integer.valueOf(1))}">
                            <li class="z-sel"><a href="/">所有内容</a></li>
                            <li ><a href="/?type=1">未购买的内容</a></li>
                        </c:if>
                </c:if>
                    <c:if test="${user.group=='user'}">
                        <c:if test="${isALL.equals(Integer.valueOf(0))}">
                                <li ><a href="/">所有内容</a></li>
                                <li class="z-sel"><a href="/?type=1">未购买的内容</a></li>
                        </c:if>
                    </c:if>

                <c:if test="${user.group!='user'}">
                    <li class="z-sel"><a href="/">所有内容</a></li>
                </c:if>
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <%--登陆后访问首页--%>
            <c:if test="${!empty user}">
                <%--显示用户未购买的商品--%>
                <c:if test="${isALL.equals(Integer.valueOf(0))}">
                    <c:forEach items="${products}" var="p">
                        <c:if test="${p.isSold =='false'}">
                            <li id="p-1">
                                <a href="/show?id=${p.id}" class="link">
                                    <div class="img"><img src="/img/${p.file}" alt="${p.name}"></div>
                                    <h3>${p.name}</h3>
                                    <div class="price"><span class="v-unit">¥</span><span class="v-value">${p.nowPrice}</span></div>
                                    <%--<span class="had" ${p.stock<=0 ? "hidden" : ""}><b>已售出</b></span>--%>
                                </a>
                            </li>
                        </c:if>
                    </c:forEach>
                </c:if>
                <%--用户和管理员可见的全部商品信息--%>
                <c:if test="${isALL.equals(Integer.valueOf(1)) || user.group=='superAdmin'}">
                    <c:forEach items="${products}" var="p">
                        <li id="p-1">
                            <a href="/show?id=${p.id}&isSold=${p.isSold}" class="link">
                                <div class="img"><img src="/img/${p.file}" alt="${p.name}"></div>
                                <h3>${p.name}</h3>
                                <div class="price"><span class="v-unit">¥</span><span class="v-value">${p.nowPrice}</span></div>
                                <c:if test="${user.group=='superAdmin'}">
                                    <span class="had" ${p.isSold == 'false' ? "hidden" : ""}><b>已售出</b></span>
                                </c:if>
                                <c:if test="${user.group=='user'}">
                                    <span class="had" ${p.isSold == 'false' ? "hidden" : ""}><b>已购买</b></span>
                                </c:if>
                            </a>
                        </li>
                    </c:forEach>
                </c:if>
            </c:if>
            <%--未登陆时候访问首页--%>
            <c:if test="${empty user}">
                <c:forEach items="${products}" var="p">
                    <li id="p-1">
                        <a href="/show?id=${p.id}" class="link">
                            <div class="img"><img src="/img/${p.file}" alt="${p.name}"></div>
                            <h3>${p.name}</h3>
                            <div class="price"><span class="v-unit">¥</span><span class="v-value">${p.nowPrice}</span></div>
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageIndex.js"></script>
</body>
</html>