package servlet;

import dao.NoteDao;
import model.Note;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addNote")
public class AddNoteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);

        NoteDao dao = new NoteDao();
        try {
            dao.insert(note);
            response.sendRedirect("list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
