package servlet;

import dao.NoteDao;
import model.Note;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/note")
public class ViewNoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        NoteDao dao = new NoteDao();
        try {
            Note note = dao.findById(id);
            request.setAttribute("note", note);
            request.getRequestDispatcher("note.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
