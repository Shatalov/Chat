<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<head>--%>
    <%--<script src="http://code.jquery.com/jquery.js"></script>--%>
    <%--<script src="./js/enterChat.js"></script>--%>
<%--</head>--%>
<%--<body>--%>



<%--</body>--%>


</head>
<%@ page import = "java.util.*" %>
<%@ page import="com.teamdev.students.chat.model.User" %>

<body>
<div align = 'center'>
    <%--<form action="/data/userNickName" method="get">--%>
        <form action="user.form" method="get">
        <%
//            request.getSession().setAttribute("formed",Boolean.valueOf(true));
            User user = (User)request.getAttribute("user");

//Person per = (Person)request.getAttribute("pers");
        %>

        <h1>Enter chat page</h1>

        Enter your nick name without spaces:  <br>
        <input type="text" name="nickName"/>
        <%--<button id="nickNameEnterBtn">Enter chat</button>--%>


        <%--<br>--%>
        <%--<br>--%>
        <%--Enter your name:--%>
        <%--<INPUT TYPE=TEXT SIZE=20 NAME=name VALUE=<%=request.getAttribute("mess") %>>--%>
        <%--<br>--%>
        <%--<INPUT TYPE=TEXT SIZE=20 NAME=name2 VALUE=<% request.getAttribute("mess"); %>>--%>

        <%--Enter your status:--%>
        <%--<SELECT NAME="status">--%>
            <%--<OPTION VALUE=a>Manager--%>
            <%--<OPTION VALUE=b>Worker--%>
            <%--<OPTION VALUE=c>Director--%>
            <%--<OPTION VALUE=d>Slave--%>
        <%--</SELECT>--%>
        <%--<br>--%>
        <%--Enter your sex:--%>
        <%--<SELECT NAME="sex">--%>
            <%--<OPTION VALUE=a>Male--%>
            <%--<OPTION VALUE=b>Female--%>
            <%--<OPTION VALUE=c>Do not know--%>
        <%--</SELECT>--%>
        <%--<br>--%>
        <%--Enter your age:--%>
        <%--<INPUT TYPE=TEXT SIZE=20 NAME=age Value=<%=user. %>>--%>
        <br>
        <INPUT TYPE=submit value="Ok">
    </form>
</div>
</body>
</html>