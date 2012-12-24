<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

</head>
<%@ page import="com.teamdev.students.chat.model.User" %>

<body>
<div align = 'center'>

        <form action="user.form" method="post">
        <%
            User user = (User)request.getAttribute("user");
//            if(user == null){
//                user = new User(0, "");
//            }
//            List<String> col = (List<String>) request.getAttribute("colors");
//            if(col == null){
//                System.out.println("***************FTYUYYT: ");
//            }
        %>

        <h1>Enter chat page</h1>

        Enter your nick name without spaces:
            <br>
        <input type="text" SIZE=20 name="nickName" value="<%= user.getNickName()%>"/>
            <br>


            <select name="colorCombo">
                <c:forEach items="${colors}" var="color">
                    <option value="${color}">${color}</option>
                </c:forEach>
            </select>



        <br>
        <INPUT TYPE=submit value="Ok">
    </form>
</div>
</body>
</html>