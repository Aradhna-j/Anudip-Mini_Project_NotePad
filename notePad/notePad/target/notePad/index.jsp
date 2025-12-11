<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mini Notepad</title>
    <link rel="stylesheet" href="assets/style.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h1><span class="logo-dot"></span> Mini Notepad</h1>
    </div>

    <div class="toolbar">
        <div class="toolbar-left">
            <span class="status-dot"></span>
            <span id="autosaveStatus">Autosave</span>
        </div>
        <button type="button" id="themeToggle" class="theme-toggle"></button>
    </div>

    <form action="addNote" method="post">
        <input type="text" name="title" id="title" placeholder="Title" required>
        <textarea name="content" id="content" placeholder="Write your note here..."></textarea>

        <div class="buttons">
            <div class="btn-group">
                <button type="button" id="clearBtn">Clear</button>
                <button type="submit">Save </button>
            </div>
            <a href="list" class="secondary">View All Notes</a>
        </div>
        <p class="small-text">Draft is auto-saved in your browser every 2 seconds.</p>
    </form>
</div>
<script src="assets/app.js"></script>
</body>

</html>
