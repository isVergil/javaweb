# JavaWeb

## 1、Tomcat

web应用服务器：tomcat，jboos，weblogic，jetty

> **tomcat文件结构**
>
> bin：存放各个平台启动和停止Tomcat服务的脚本文件
>
> conf：存放各种  tomcat  服务器的配置文件
>
> lib：放的  jar  包
>
> logs：存放 tomcat 服务运行的日志
>
> temp：存放运行时的临时文件
>
> webapps；存放允许客户端访问的资源，java程序
>
> work：存放 tomcat 讲JSP 转换之后的 Servlet 文件

## 2、Servlet

> 是javaweb开发的基石，与平台无关的服务器组件，他是运行在Servlet容器/web应用服务器/tomcat，负责与客户端进行通信

* 功能

> 1、创建并返回基于客户端请求的动态HTML页面。
>
> 2、与数据库进行通信。

* 使用

> Servlet本身是一组接口，自定义一个类，并且实现Servlet接口，这个类就具备了接受客户端请求以及做出响应的功能
>
> javax.servlet，java.lang、 java.util 、javax.sql
>
> javax是从java扩展出来的东西

### Servlet 访问

> 浏览器不能直接访问Servlet文件，只能通过映射的方式来间接访问Servlet，映射需要开发者手动配置，有两种方式。

1、基于XML文件  在web.xml中配置

```xml
<servlet>
	<servlet-name>MyServlet</servlet-name>
	<servlet-class>com.servlet.MyServlet</servlet-class>
</servlet>  
<servlet-mapping>
<servlet-name>demo</servlet-name>
	<url-pattern>/myservlet</url-pattern>
</servlet-mapping>
```

2、基于注解

```java
// 上述两种配置方式完全一致，都是将 demo 和  MyServlet 进行映射
// 即在浏览器地址栏直接访问demo就可以映射到 MyServlet
@WebServlet("/demo")
public class MyServlet implements Servlet {

}
```



### Servlet 的生命周期

> 调用时 Servlet 容器会检测是否有指定的对象，若没有则创建，存在则直接执行业务方法。类似字符串常量池，节约内存开销。是通过反射机制实现的。
>

> 1、浏览器访问Servlet时，Tomcat会查询当前Servlet的实例化对象是否存在，若不存在，则通过反射机制动态创建对象。如果存在，直接执行第三步。
>
> 2、调用 init 方法完成初始化操作。一般不用
>
> 3、调用service方法完成业务逻辑操作。
>
> 4、关闭tomcat时，会调用destory方法，释放当前对象所占用的资源。

Servlet 的生命周期方法：无参构造函数、init、service、destory

1、无参构造函数只调用一次，创建对象。

2、init 只调用一次，初始化对象。很少用

3、service 调用 N 次，执行业务方法。

4、destory 只执行一次，卸载对象。



### ServletConfig

> 该接口用来描述 Servlet 的基本信息。
>
> getServletName()   返回 Servlet 的名称，全类名
>
> getInitParameter(String key)   获取init参数的值 value (在web.xml中配置)    用的少
>
> getInitParameterNames();  返回所有 initParamter 的name值，一般用作遍历初始化参数
>
> getServletContext();    返回 ServletContext 对象，他是 Servlet 的上下文，整个 Servlet 的管理者

*  ServletConfig 和 ServletContext 的区别

  > ServletConfig 作用于某个Servlet 的实例，每个Servlet 都有对应的 ServletConfig
  >
  > ServletContext 作用于整个Web应用，多个Servlet 实例对应于一个 ServletContext 
  >
  > 一个局部对象，一个全局对象

### 层次结构

Servlet———>    GenericServlet  ———>    HTTPServlet

> GenericServlet  实现了 Servlet 接口，同时为他的子类屏蔽了不常用的方法，子类只需要重写 service 方法即可
>
> HttpServlet 继承 GenericServlet ，根据请求类型进行分发处理，GET 进入 doGET 方法，POST 进入 doPOST方法
>
> 开发者自定义的Servlet 类只需要继承 HttpServlet 即可，重新 doGet 和 doPost。

Http 请求有很多种类型，常用的有四种   （RESTful）

> GET           读取
>
> POST         保存
>
> PUT            修改
>
> DELETE     删除

## 3、JSP

*  jsp 本质上就是一个 Servlet ，主要负责与用户交互，将最终的界面呈现给用户，html+css+js+程序后台的混合文件。

* 当服务器接收到一个后缀为 jsp 的请求时，将该请求交给 jsp 引擎去处理，每一个jsp页面第一次被访问时，JSP引擎会把他翻译成一个 Servlet 文件，由 Web 容器调用 Servlet 完成响应。

* 单纯从开发角度看，jsp 就是在 HTML 中嵌入Java 程序。

### 3.1 具体的嵌入方式有三种：

> （1）JSP脚本
>
> ```java
> <%! Java 代码 %>
> ```
>
> （2）JSP声明：定义 Java 方法
>
> ```java
> <%
>     声明 Java 方法
> %>
> ```
>
> （3）JSP表达式：把Java对象直接输出到对象中
>
> ```java
> <%=  java变量  %>
> ```
>
> <img src="images/1603260302543.png" alt="1603260302543" style="zoom: 80%;" />
>
> <img src="images/1603260745683.png" alt="1603260745683" style="zoom:67%;" />

### 3.2 JSP  内置对象  9  个

#### （1）request      表示一次请求，来自HttpServletRequest

#### （2）reponse     表示一次响应，来自HttpServletRequest

#### （3）pageContext      页面上下文，获取页面信息，PageContext

#### （4）session      表示一次会话（包含很多个request和reponse），保存用户信息，来自HttpSession

#### （5）application   表示当前web应用，全局信息，保存所有用户共享的信息，来自ServletContext 的实例对象

#### （6）config    当前JSP对应的Servlet的ServletConfig对象，获取当前Servlet的信息。

#### （7）out     JspWriter对象，向浏览器输出数据

#### （8）page     当前JSP对应的Servlet对象

#### （9）exception   表示JSP页面发生的异常，exception

* request常用方法

> String  getParameter(String key) 获取客户端传来的参数
>
> void setAttribute(String key,Object  value)    通过键值对的形式保存数据
>
> Object getAttribute(String key)   通过 key 取出 value
>
> RequestDispatcher    getRequestDispatcher(String path)  返回一个RequestDispatcher对象，**该对象的forward方法用于请求转发。**
>
> String[] getParameterValues() 用数组取得参数值，获取客户端传来的多个同名参数
>
> void setCharacterEncoding(String charset)  指定每个请求的编码   
>
> //request.setCharacterEncoding("UTF-8");

```java
//test1.jsp   设置值
<%    
    String idStr = request.getParameter("id");    
    Integer id = Integer.parseInt(idStr);    
    id++;    
    //将数据存入到request中    
    request.setAttribute("id", id);   
    out.println(id);    
   //将请求转发给test2.jsp  
   request.getRequestDispatcher("test2.jsp").forward(request, response);
%>

//test2.jsp   取数据并展示
<%
   out.print(request.getAttribute("id"));
%>
```

**！！！  request 生命周期太短，因此需要session**

#### 状态码

> 200 正常
>
> 404 资源找不到
>
> 400 请求类型不匹配  get post 等请求
>
> 500 java程序异常

* response 常用方法

  > 转发  getRequestDispatcher 和 重定向 sendRedirect 区别：
  >
  > * 转    发    是将同一个请求传给下一个页面   同一个请求在服务器之间传递，地址栏不变，也加服务器跳转
  >
  > * 重定向    是创建一个**新的请求**传给下一个页面之前的请求结束生命周期。由客户端发送一次新的请求来访问跳转后的目标资源，地址栏改变，也叫客户端跳转
  > * 如果两个页面之间需要通过 request 来传值，则必须使用转发，不能使用重定向。

> sendRedirect(String path)   重定向方法，页面之间的跳转跟request 请求转发类似

### 3.3 Session 用户会话

服务器无法识别每一次  HTTP  请求的出处（不知道来自于哪个终端），它只会接受到一个请求信号，所以就存在一个问题：将用户的响应发给其他人，必须有一种技术来让服务器知道请求来自哪里，这就是会话技术。

> 会话：客户端和服务器之间发生的一系列连续的请求和响应过程。打开浏览器进行操作到关闭浏览器的过程。
>
> 会话状态：指服务器和浏览器在会话过程中产生的状态信息，借助于会话状态，服务器能够把属于同一次会话的一系列请求和响应关联起来。
>
> 实现会话的两种方式：
>
> * session   服务端存储（java程序）
> * cookie     客户端存储（浏览器）

属于同一次会话的请求都有一个相同的标识符 sessionID

#### 常用方法

> String getid()     获取sessionID
>
> void setMaxINactiveInterval(int interval)    设置session 失效时间，单位为秒
>
> int getMaxINactiveInterval()        获取当前session 失效时间，单位为秒                 默认1800秒   30分钟
>
> void invalidate()          设置  session  立即失效     **退出登录的时候用**
>
> void setAttribute(String key,Object value)        通过键值对的形式来存储数据或者修改已存在的键值对
>
> Object  setAttribute(String key)          通过键获取对应的数据
>
> void removeAttribute(String key)           通过键删除对应的数据

### 3.4 Cookie

> Cookie是服务端在 HTTP 响应中附带传给浏览器的一个小文本文件，一旦浏览器保存了这个 Cookie ，之后的请求响应过程中，会将此Cookie来回传递，这样就可以通过 Cookie 这个载体完成客户端和服务端的数据交互。
>

* 创建Cookie

  ```java
  Cookie cookie=new Cookie("name","tom");
  response.addCookie(cookie);
  ```

* 请求Cookies

```java
Cookie[] cookies = request.getCookies();
for (Cookie cookie : cookies) {    
    out.write(cookie.getName() + "  " + cookie.getValue() + "<br/>");
}
```

* Cookie 常用的方法

> void setMaxAge(int age);      设置 Cookie 的有效时间，单位为秒
>
> void gettMaxAge() ;            获取 Cookie 的有效时间，单位为秒                            默认为 -1，一关浏览器就没了     
>
> String getName();      String getValue();         获取name，value

* Session  和   Cookie 区别

> Session 保存在服务器   Object类型   会随着会话结束而销毁  保存重要信息
>
> Cookie  保存在浏览器    String类型     可以长期保存在浏览器中，与会话无关，保存不重要信息

> * 存储用户信息：
>
>   Session：    setAttribute("name","admin")   存
>
>   ​                    getAttribute("name")    取
>
>   ​                    生命周期：服务端：只要 WEB 应用重启就销毁  
>
>   ​                                      客户端：只要浏览器关闭就销毁
>
>   ​                    退出登录  session.invalidate();
>
>   Cookie：response.addCookie(new Cookie(name,"admin"))  存
>
>   ​               遍历cookie[]   依次判断      取
>
>   ​                  生命周期：不随服务端的重启而销毁   客户端默认关闭浏览器就销毁  可通过 setMaxAge() 来设置有效期，一旦设置了有效期，则不随着浏览器的关闭而销毁，而是由设置的时间来决定。
>
>   ​                 退出登录：setMaxAge();



### 3.5 JSP内置对象作用域（4个）

> page、request、session、application
>
> 都有 setAttribute 、getAttribute 方法
>
> cookie不是内置对象 ，而是存在浏览器中的，java中有这种方法将其对象取出

* page 作用域 ：对应内置对象是pageContext
* request 作用域：对应的内置对象是request
* session作用域：对应的内置对象是session
* application作用域：对应的内置对象是application

> page < request  < session < application

* page 只在当前页面有效
* request 在一次请求内有效（内部请求转发也有效）
* session 在一次会话内有效 （换浏览器不行）
* application 对应于整个web应用（想当于存到 tomcat 中了）网站的访问量统计

> page 只在当前页面有效，转发、重定向都不行

> application  换浏览器后会继续累加
>
> session  换客户端后count会重置

### 3.6 EL 表达式 （只能在JSP页面中写）

Expression Language 表达式语言，替代 JSP 页面中f数据访问时的复杂编码，非常便捷的取出域对象（上面4个内置对象）中保存的数据，前提是一定要先 setAttribute, EL就相当于在简化 getAttribute

${变量名}  域对象里面取键值对应的值

* 优先级问题 -- 对于 4 种域对象的默认查找顺序

> pageContext   >  request   >   session  >   application 
>
> 按照上述的顺序进行查找，找到立即返回，在 application 中也无法找到，则返回 null

* 指定作用域进行查找

> pageContext  :  ${pageScope.name}
>
> request  :  ${requestScope.name}
>
> session  :  ${sessionScope .name}
>
> application:  ${applicationScope.name}

* EL 表达式也具有赋值功能，但更多的是取值功能

![1604402778703](images/1604402778703.png)

> EL表达式不能遍历，在复杂页面中用起来不简洁，代码看起来会很混乱
>

### 3.7  JSTL  jsp标准标签库

* JSP Standard Tag Library     jsp标准标签库，jsp为开发者提供的一系列标签，使用这些标签可以完成一些逻辑处理，比如循环遍历集合，让代码变得简洁，不再出现JSP脚本穿插的情况

* 实际开发中 EL 和 JSTL 结合起来使用，JSTL 侧重于逻辑处理， EL 负责数据展示。

```jsp
// JSTL的使用：
// 1、 需要导入 jar 包（两个 jstl.jar  standard.jar） ，存放位置 web/WEB-INF
// 2、 在 JSP 页面开始的地方导入 JSTL 标签库
<%--c表示标签前缀--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.number}</td>
    </tr>
</c:forEach>
```

> JSTL 优点
>
> 1、提供了统一的标签
>
> 2、可以用于编写各种动态功能

* 常用标签

set   、 out  、  remove  、  catch

```JSP
// set： 向域对象中添加数据
// 默认给 page 存 也可用 scope 指定要存储的对象
<c:set var="name" value="tom" scope="request"></c:set>
// 相当于下面
<%
  request.setAttribute(key,value)
%>
//设置对象里面的某个属性值
<c:set target="${userTest}" property="name" value="李四" ></c:set>
```

```JSP
// out： 输出  default 属性可以设置默认值
<c:out value="${userTest.name}" default="未定义"></c:out>
```

```jsp
// remove： 删除域对象中的数据
<c:remove var="${name}" scope="page"></c:remove>
```

```jsp
// catch: 捕捉异常 存到 var 中
<c:catch var="error">
    <%
        int a = 10 / 0;
    %>
</c:catch>
```

```jsp
// if 逻辑判断 在 test 里面写表达式
<c:if test="${user.age>user.number}">ok</c:if>
```

```jsp
// 条件判断标签 相当于 if else
<c:choose>
    <c:when test="${user.age>user.number}">ok</c:when>
    <c:otherwise>fail</c:otherwise>
</c:choose>
```

```jsp
// 迭代标签  begin 设置起始位置   step 每次走的步数
<c:forEach items="${users}" var="user" begin="2" step="2" varStatues="sta">
   ${sta.index}  ${sta.count}   ${user.name}<br/>
</c:forEach>
```

* fomat 格式化标签库  数据格式化

```jsp
// 引入 fmt 库
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
        request.setAttribute("date", new Date());
%>
${date}<br/>
<fmt:formatDate value="${date}" pattern="yyyy-mm-dd HH:mm:ss"></fmt:formatDate>
<fmt:formatNumber value="3548151.15641" maxFractionDigits="3" maxIntegerDigits="2"></fmt:formatNumber>
```

* 函数标签库常用标签

```jsp
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
        request.setAttribute("info", "java.c");
%>
${fn:contains(info,"c")}
${fn:startsWith(info,"c")}
${fn:endsWith(info,"c")}
${fn:indexOf(info,"c")}
${fn:replace(info,"c","python")}
```

![1604658528477](images/1604658528477.png)

### 3.8  过滤器 Filter  

> 对请求进行过滤和处理，比如中文乱码问题

* 功能：

> 1、用来拦截传出的请求和传出的响应
>
> 2、修改或某种方式处理正在客户端和服务器之间交换的数据流

* 使用：

> 和 Servlet 类似，Filter 是 java web 提供的一个接口，开发者只需要自定义一个类并且实现该接口即可

<img src="images/1604836520114.png" alt="1604836520114" style="zoom:67%;" />

> java 8 新特性 接口方法前面加 default 可实现也可不实现
>
> 没加就要去实现 

```java
package com.filter;
import javax.servlet.*;
import java.io.IOException;
public class CharacterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException     {
            servletRequest.setCharacterEncoding("UTF-8");
            filterChain.doFilter(servletRequest, servletResponse);
    }
}
```

```XML	
<filter>
        <filter-name>charcatar</filter-name>
        <filter-class>com.filter.CharacterFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>charcatar</filter-name>
    <url-pattern>/login</url-pattern>
    <url-pattern>/test</url-pattern>
</filter-mapping>
```

* 注意：

>  doFilter 方法中处理业务逻辑之后，必须添加  
>
> filterChain.doFilter(servletRequest, servletResponse);
>
> 否则请求/响应无法向后传递，一直停留在过滤器中。

* Filter 的生命周期

> 当 Tomcat 启动时，通过反射机制调用 Filter 的无参构造函数创建实例化对象，同时调用 init 方法实现初始化，doFilter 方法调用多次，当 Tomcat 服务关闭时，调用 destory 来销毁 Filter对象

> 无参构造函数：只调用一次，当 tomcat 启动时调用（filter 一定要配置 xml）
>
> init 方法：只调用一次，当 Filter 的实例化对象创建完成之后调用
>
> doFilter：调用多次，访问 Filter 的业务逻辑卸载 Filter 中
>
> destory：只调一次，tomcat关闭时

### 3.9  文件上传下载

#### 上传

* JSP

1、input 的 type 设置为 file

2、form 表单的 method 必须为 post 

​      get 请求传输是文件名，get 请求会将文件名传给服务端，而不是文件本身

3、form 表单的 enctype 设置为 multipart/form-data ,以二进制的形式传输数据

* Servlet

  fileupload 组件可以将所有的请求信息都解析成 FileItem 对象的操作完成上传，面向对象的思想。

#### 下载

```java
//设置响应 让客户端下载 否则直接响应了
resp.setContentType("application/x-msdownload");
```

```java
String type = req.getParameter("type");
String fileName = "";
switch (type) {
    case "png":
        fileName = "1.png";
        break;
    case "txt":
        fileName = "test.txt";
        break;
 }
//设置响应方式 down方式 让客户端下载 否则直接响应了
resp.setContentType("application/x-msdownload");
//设置下载之后的文件名
resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//获取输出流
OutputStream outputStream = resp.getOutputStream();
String path = req.getServletContext().getRealPath("files/" + fileName);
InputStream inputStream = new FileInputStream(path);
int temp = 0;
while ((temp = inputStream.read()) != -1)
    outputStream.write(temp);
inputStream.close();
outputStream.close();
```

### 3.10 Ajax

Asynchronous JavaScript And XML ：异步的 JavaScript 和 XML

AJAX 不是新的编程，指的是一种交互方式，异步加载，客户端和服务器的数据交互更新再局部页面的技术，不需要刷新整个页面（局部刷新）

优点：

1、局部刷新，效率更高

2、用户体验更好

基于 jQuery 的Ajax

不能用表单提交，改用 jQuery 方式动态绑定事件来提交。

Servlet 不能跳转到 JSP，只能将数据返回。

```html
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var btn=$("#btn");
            btn.click(function () {
                $.ajax({
                    //url 相当于servlet
                    url:'/ajaxtest',
                    type:'post',
                    //参数
                    data:'id=1',
                    //服务器返回类型
                    dataType:'text',
     //由于后台写的返回是 test.jsp 故此时返回的是 整个 test.jsp 的前台代码
                    success:function (data) {
                        var text=$('#text');
                        text.before("<span>"+data+"</span>");
                    }
                });
            });
        })
</script>
```

* 传统的 web 数据交互 vs AJAX 数据交互

客户端请求的方式不同：

​      传统：浏览器发布同步请求（form 、 a）   

​      AJAX：异步引擎对象发布异步请求

服务器的响应不同：

​      传统：响应一个完整的 JSP 页面   

​      AJAX：响应需要的数据

客户端处理方式不同：

​      传统：需要等待服务器完成响应并且重新加载整个页面之后，用户才能进行后续操作

​      AJAX：响应需要的数据，动态更新页面的局部内容，不影响用户的其他操作



* AJAX原理

![1606738659945](images/1606738659945.png)



*  AJAX语法

$.ajax({属性})

常用的属性参数：

url：请求的后端服务地址

type：请求方式 默认get

data：请求参数

dataType：服务器返回的数据类型， text/json

success：请求成功的回调

error：请求失败的回调函数

complete：请求完后的回调（无论成功或失败  都会调用）

> 请求成功  先进 complete 再进 success
>
> 请求失败  先进 error 再进 complete 

* JSON

JavaScript Object Notation 一种轻量级数据交互格式，完成 js 与 java 等后端开发语言对象数据之间的转换，客户端和服务器之间传递对象数据，需要用 JSON 格式。



## 4、JDBC

> Java DataBase Connectivity

是一个独立于特定数据库的管理系统。通用的 SQL 数据库存取和操作的公共接口。

顶一个一组标准，为访问不同的数据库提供了统一途径。

![1607317882223](images/1607317882223.png)

### 4.1 JDBC  体系结构

* 面向应用的 API ，供程序员调用
* 面向数据库的 API，供厂商开发数据库的驱动程序

* JDBC API

  > JAVA官方提供  的  供开发者调用的接口  java.sql 和javax.sql
  >
  > DriverManager 类   
  >
  > ​             管理不同的JDBC驱动 数据厂商提供，负责连接不同数据库
  >
  > Connection 接口
  >
  > Statement  接口
  >
  > ResultSet 接口

### 4.2 JDBC 的使用

1、加载数据库驱动，java程序和数据库之间的桥梁。

2、获取 Connection，java程序和数据库的一次连接。

3、创建 Statement 对象，由 Connection 产生，执行 SQL语句。

4、如果需要接受返回值，创建 ResultSet 对象，保存 Statement 执行之后所查询到的结果。

```java
try {
    //加载驱动
    Class.forName("com.mysql.cj.jdbc.Driver");
    //获取连接
    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    String user = "root";
    String password = "bill";
    Connection connection = DriverManager.getConnection(url, user, password);
    System.out.println(connection);
    //创建 statement 对象，执行sql语句
    //String sql = "insert into t_users(name,school,t1,t2) values('周六','清华大学','','')";
    String sql = "select * from t_users";
    System.out.println(sql);
    Statement statement = connection.createStatement();
    //int result= statement.executeUpdate()
    ResultSet resultSet = statement.executeQuery(sql);
    //System.out.println(result);
    //ResultSet resultSet=statement.getResultSet();
    while (resultSet.next()) {
        String name = resultSet.getString("name");
        String school = resultSet.getString(3);
        System.out.println(name + "-" + school);
    }
    System.out.println(resultSet);
} catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch (SQLException e) {
    e.printStackTrace();
}
```

### 4.3 PreparedStatement

statement 的子类，提供了 SQL 占位符的功能

使用 Statement 进行开发有两个问题 

> 1、需要频繁拼接 String 字符串，出错率较高。
>
> 2、存在 SQL 注入的风险 
>
> SQL注入：利用某些系统没有对用户输入的信息进行充分检测，在用户输入的数据中注入非法的 SQL 语句，从而利用系统的 SQL 引擎完成恶意行为的做法。 or ’1‘=’1‘

```java
try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "root";
            String password = "bill";
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            //创建 statement 对象，执行sql语句
            //String sql = "insert into t_users(name,school,t1,t2) values('周六','清华大学','','')";
            //String sql = "select * from t_users where name='周六' and school='清华大学'";
            String sql = "select * from t_users where name=? and school=?";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet=statement.executeQuery(sql);
//            if (resultSet.next())
//                System.out.println("登录成功");
//            else
//                System.out.println("登录失败");
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,"周六1");
            preparedStatement.setString(2,"清华大学");
            ResultSet resultSet=  preparedStatement.executeQuery();
            if (resultSet.next())
                System.out.println("登录成功");
            else
                System.out.println("登录失败");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
```



### 4.4 数据库连接池

JDBC 开发流程

> 1、加载数据库驱动（只需要加载一次）
>
> 2、建立数据库连接（ Connection ）
>
> 3、创建 Statement 对象，由 Connection 产生，执行 SQL语句。（ Statement  ）
>
> 4、如果需要接受返回值，创建 ResultSet 对象，保存 Statement 执行之后所查询到的结果。（查询）
>
> 5、断开连接，释放资源

数据库连接对象是通过 DriverManager 来获取的，每次获取都需要向数据库申请获取链接，验证 用户名和密码。

执行完 SQL 语句后断开连接，这样的方式会造成资源浪费，数据连接资源没有得到很好的重复利用。

可以使用数据库连接池来解决这一问题。

数据库连接池的基本思想就是为数据库建立一个缓冲池，预先向缓冲池中放入一定数量的连接对象，当需要获取数据库连接的时候，只需要从缓冲池中取出一个对象，用完之后再放回到缓冲池中，供下一次请求使用，做到了资源的重复利用，允许程序重复使用一个现有的数据库连接对象，而不需要重复创建了。

当数据库连接池中没有空闲的连接时，新的请求就会进入等待队列，等待其他线程释放连接。



### 4.5  数据库连接池实现

JDBC 的数据库连接池使用 javax.sql.DataSource 接口来完成，DataSource 是 java官方提供的接口，使用的时候开发者并不需要自己来实现该接口，可以使用第三方的工具，C3P0 是一个常用的第三方实现，实际开发中直接使用 C3P0  即可完成数据库连接池的操作。

> 有关与数据库连接的部分离不开c3p0包，然而当高版本的c3p0包（如：0.9.5.2版本）使用时，必须引入mchange-commons-java-0.2.12.jar包，这个包是c3p0的辅助包，如果不引入，那么会在spring中报 ***no default constructor found*** 的错误 

```java
//传统方式 拿到的 Connection
com.mysql.cj.jdbc.result.ResultSetImpl@5419f379
// close(); 方法是释放资源
    
//C3P0 拿到的 Connection
com.mchange.v2.c3p0.impl.NewProxyConnection@2c8d66b2
// close(); 方法是还原回来    
```

```java
try {
            //创建一个 C3P0
            ComboPooledDataSource dataSource=new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("bill");
            Connection  connection= dataSource.getConnection();
            System.out.println(connection);
} catch (PropertyVetoException e) {
            e.printStackTrace();
} catch (SQLException e) {
            e.printStackTrace();
}
```

实际开发中，将 C3P0 的配置信息定义在 xml 文件中，Java程序只需要加载配置文件即可完成数据库连接池的初始化操作。

1、配置文件的名字必须是 c3p0-config.xml 

2、初始化 ComboPooledDataSource 时，传入的参数必须是 c3p0-config.xml 中的 name-config 标签的 name属性值。

* xml 文件中 & 符号要用转义字符 &amp; amp;    代替。



### 4.6 DBUtils

* 使用原生查询处理查询结果时，需要手动封装，DBUtils 可以帮助开发者完成数据的封装（结果集到 java对象的映射）。

1、导入 jar 包。

ResultHandler 接口是用来处理结果集的，可以将查询到的结果集转换成 java 对象，提供了 4种 实现类。

* BeanHandler           将结果集映射成 java 对象    Student
* BeanListHandler     将结果集映射成 List  集合     List<Student>
* MapHandler            将结果集映射成 Map 对象  
* MapListHandler      将结果集映射成 MapList 对象        

> 没有无参构造程序报错：反射机制找到无参构造再创建对象，没有无参构造就创建不了对象，程序就会报错。







