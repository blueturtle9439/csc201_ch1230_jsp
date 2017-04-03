
<%@ page import="ch1230core.ch1230" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.FileNotFoundException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ch1230 result</title>
</head>
<body>

<%
    ch1230 core = new ch1230();
    Map temp = null;
    try {
        temp = core.count("D:\\programs\\workplace\\intellijworkspace\\csc201_ch1230_jsp\\"+request.getParameter("input"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    for (int i = 65; i < 91; i++)
        out.println("Numbers of " + (char) i + "\'s: " + temp.get((char) i)+"<br>");





%>

</body>
</html>
