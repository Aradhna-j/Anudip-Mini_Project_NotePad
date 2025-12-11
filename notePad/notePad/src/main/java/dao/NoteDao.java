package dao;

import model.Note;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDao {

    public void insert(Note note) throws Exception {
        String sql = "INSERT INTO notes(title, content) VALUES (?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContent());
            ps.executeUpdate();
        }
    }

    public List<Note> findAll() throws Exception {
        List<Note> list = new ArrayList<>();
        String sql = "SELECT id, title, content, created_at FROM notes ORDER BY created_at DESC";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Note n = new Note();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setCreatedAt(rs.getString("created_at"));
                list.add(n);
            }
        }
        return list;
    }

    public Note findById(int id) throws Exception {
        String sql = "SELECT id, title, content, created_at FROM notes WHERE id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Note n = new Note();
                    n.setId(rs.getInt("id"));
                    n.setTitle(rs.getString("title"));
                    n.setContent(rs.getString("content"));
                    n.setCreatedAt(rs.getString("created_at"));
                    return n;
                }
            }
        }
        return null;
    }
}
