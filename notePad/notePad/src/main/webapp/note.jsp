<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Note" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Note</title>
    <link rel="stylesheet" href="assets/style.css">
</head>
<body>
<div class="container">
    <%
        Note note = (Note) request.getAttribute("note");
    %>
    <h1><%= note != null ? note.getTitle() : "Note" %></h1>
    <pre class="note-view"><%= note != null ? note.getContent() : "" %></pre>
    <a href="list" class="secondary">Back to list</a>
</div>
</body>
</html>
