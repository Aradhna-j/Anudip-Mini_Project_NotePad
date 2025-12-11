package servlet;

import dao.NoteDao;
import model.Note;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListNotesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NoteDao dao = new NoteDao();
        try {
            List<Note> notes = dao.findAll();
            request.setAttribute("notes", notes);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
