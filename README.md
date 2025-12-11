📝 Mini Notepad – Java Servlet + JSP Full-Stack Web App

Mini Notepad is a lightweight, full-stack note-taking web application built using Java Servlets, JSP, MySQL, and vanilla JavaScript. It provides a clean writing experience, autosave drafts, real-time counters, theme toggling, and a modern glassmorphic UI — all while storing notes securely in a MySQL database.

🚀 Features
✍️ Note Management

Create notes with title + text body

View individual notes on a dedicated page

List all notes sorted by latest first

Optional Pinned Notes (stay at top)

💾 Persistence

MySQL database storage for all notes

DAO-based CRUD architecture

JDBC (mysql-connector-j) integration

🖥️ Frontend UX Enhancements

LocalStorage draft autosave (never lose text on refresh!)

Live word & character count

Modern glassmorphism UI

Smooth animations & micro-interactions

Light/Dark theme toggle (stored in LocalStorage)

Instant search filter on notes list page

🛠️ Tech Stack
Backend

Java 21

Jakarta Servlet API (Jakarta EE)

JSP

Tomcat 10

MySQL + JDBC

Maven for build/dependency management

Frontend

HTML5

CSS3

JavaScript (vanilla)

📚 Learning Objectives

This project demonstrates:

Structuring a classic Servlet–JSP–JDBC web app

Connecting Java to MySQL using JDBC + DAO pattern

Using Maven to manage dependencies and build WAR files

Building interactive UI using pure CSS + JS

Implementing features like autosave, live counters, search, and theme persisting

Deploying Java apps on Tomcat 10

🗄️ Database Setup
CREATE DATABASE notepad_db;

CREATE TABLE notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    content TEXT,
    pinned BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

▶️ How to Run

Create the database notepad_db and table (SQL above).

Update DB credentials inside DBUtil.

Run:

mvn clean package


Deploy the generated .war file to Tomcat 10.

Open in browser:

http://localhost:8080/notePad/
