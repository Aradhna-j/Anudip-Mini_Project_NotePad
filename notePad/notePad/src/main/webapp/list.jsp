<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Note" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Notes</title>
    <link rel="stylesheet" href="assets/style.css">
</head>
<body>
<div class="container">
    <h1>All Notes</h1>
    <a href="index.jsp" class="secondary">New Note</a>
    <table class="notes-table">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Created</th>
            <th>Action</th>
        </tr>
        <%
            List<Note> notes = (List<Note>) request.getAttribute("notes");
            if (notes != null) {
                for (Note n : notes) {
        %>
        <tr>
            <td><%= n.getId() %></td>
            <td><%= n.getTitle() %></td>
            <td><%= n.getCreatedAt() %></td>
            <td><a href="note?id=<%= n.getId() %>">Open</a></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>
