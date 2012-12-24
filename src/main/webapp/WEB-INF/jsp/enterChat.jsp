<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

</head>
<%@ page import="com.teamdev.students.chat.model.User" %>
<%@ page import="java.util.List" %>

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


        <form:form commandName="colors">
            <%--<form:select path="color" items="${colors}"/>--%>
             <%--<br>--%>

            <form:select  path="Color">
                <form:options items="${colors}" itemValue="color" itemLabel="color"/>
            </form:select>

            <%--<form:select path="colors">--%>
                <%--<form:option value="-" label="--Please Select"/>--%>
                <%--<form:options items="${colors}" itemValue="code" itemLabel="name"/>--%>
            <%--</form:select>--%>

        </form:form>

            <%--<SELECT NAME="sex">--%>
                <%--<OPTION VALUE=a>Male--%>
                <%--<OPTION VALUE=b>Female--%>
                <%--<OPTION VALUE=c>Do not know--%>
            <%--</SELECT>--%>

        <br>
        <INPUT TYPE=submit value="Ok">
    </form>
</div>
</body>
</html>