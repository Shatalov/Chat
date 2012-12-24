<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

</head>
<%@ page import="com.teamdev.students.chat.model.User" %>
<%@ page import="java.util.List" %>

<body>
<div align='center'>

    <form action="user.form" method="post">

        <h1>Enter chat page</h1>

        Enter your nick name without spaces:
        <br>
        <input type="text" SIZE=20 name="nickName" value="<%= request.getAttribute("userNick")%>"/>
        <br>

         Select color:
        <select name="colorSelected">
            <c:forEach items="${colors}" var="color">
                <option value="${color}">${color}</option>
            </c:forEach>
        </select>


        <br>
        <p style="color:red">
        <%= request.getAttribute("errorMessage")%>    </p>
        <br>

        <INPUT TYPE=submit value="Ok">
    </form>
</div>
</body>
</html>

