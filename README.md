1.这是一个SpringMVC+Spring+Mybatis的电商web项目

2.项目部署到tomcat的时候要配置成根路径访问的那种，不然会造成静态资源访问不到以及url跳转错误
（部署tomcat：
一、把war包解压，部署到除$TOMCAT_HOME/webapps以外的目录
二、删除$TOMCAT_HOME/ webapps/ROOT目录下的所有文件
三、在$TOMCAT_HOME/conf/Catalina/localhost目录下，新建一个ROOT.xml文件，写入类似于如下内容：
<?xml version='1.0' encoding='utf-8'?> 
<Context path="/" docBase="/usr/local/tomcat-6.0/webdav" debug="0" privileged="true" reloadable="true"/> 
其中，docBase指向的是war包解压后的目录名称，需绝对路径。
  采用idea调试：
一、进入debug configuration
二、将sever 中的url写成根路径
三、将deployment中的artifact选成war exploded
四、application context写成“/”
）

3.用户分为两种，是在数据库预先注入的普通用户（买家）和管理员（卖家），当然也可以注入多个用户。

默认的普通用户：账号：buyer，密码：reyub

默认的管理员：账号：seller，密码：relles

因为登录时候采用MD5加密算法，所以数据库中能看到的password是固定长度的MD5字符串，如果自行创建新的用户则需要用chrome浏览器捕获http请求时候的加密后的密码然后再将这段字符串自行注入到mysql即可。

数据库脚本可见lfc.sql
