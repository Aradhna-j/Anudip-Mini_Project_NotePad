# Anudip-Mini_Project_NotePad
This mini‑project is a full‑stack “Mini Notepad” web application built with Java (Servlets + JSP), MySQL, HTML, CSS, and vanilla JavaScript.

Project overview
Mini Notepad lets users create, view, and read text notes through a modern web UI. Notes are stored persistently in a MySQL database, and the frontend provides a smooth editing experience with autosave and basic analytics like word/character count.

Tech stack
Java 21, Jakarta Servlet API (Jakarta EE)

JSP for server‑side views

Tomcat 10 as the application server

MySQL + JDBC (mysql‑connector‑j) for persistence

HTML5, CSS3, vanilla JavaScript for the frontend

Maven for build and dependency management

Features
Create notes with a title and rich text body.

Store notes in a MySQL table with timestamps.

List all notes in reverse chronological order.

View a single note on a dedicated page.

Optional “Pinned” flag to keep important notes at the top.

LocalStorage‑based draft autosave in the browser (no data loss on refresh).

Live word and character count for the note body.

Dark, glassmorphism‑style UI with animated focus and button micro‑interactions.

Light/dark theme toggle persisted in LocalStorage.

Client‑side search filter on the notes list page.

Learning objectives
This project demonstrates:

How to structure a classic JSP/Servlet/JDBC web app.

Connecting a Java web application to MySQL using JDBC.

Implementing a simple DAO layer (CRUD‑style queries) and model classes.

Using Maven to manage dependencies and build a WAR for Tomcat.

Designing a responsive, modern UI with pure CSS and small animations.

Enhancing UX with JavaScript: autosave, theme toggling, live counters, and filtering.

How to run (high level)
Create the notepad_db database and notes table in MySQL.

Configure DB credentials in DBUtil.

Run mvn clean package to build, or use your IDE’s Maven integration.

Deploy the generated WAR (or WAR exploded) to a local Tomcat 10 server.

Open http://localhost:8080/notePad/ to start using the app.
