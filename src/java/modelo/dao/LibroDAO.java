/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.List;
import modelo.dto.LibroDTO;
import conexion.Mysql_BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class LibroDAO implements Contrato<LibroDTO> {

    private static final String SQL_READALL = "SELECT * FROM tb_libro ";
    private static final String SQL_CREATE = "INSERT INTO tb_libro (isbn, nombre, autor, editorial, anio) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM tb_libro WHERE isbn = ?";
    private static final String SQL_UPDATE = "UPDATE tb_libro SET nombre = ?, autor = ?, editorial = ?, anio = ? WHERE isbn = ?";
    private static final String SQL_READ = "SELECT * FROM tb_libro WHERE isbn = ?";
    
    @Override
    public boolean create(LibroDTO nuevo) {
        try {
            Connection con = Mysql_BD.getInstance().cnn;
            PreparedStatement ps = con.prepareStatement(SQL_CREATE);
            ps.setLong(1, nuevo.getIsbn());
            ps.setString(2, nuevo.getNombre());
            ps.setString(3, nuevo.getAutor());
            ps.setString(4, nuevo.getEditorial());
            ps.setInt(5, nuevo.getAnio());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            System.out.println("Error al insertar libro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Object item) {
        if (item instanceof Long) {
            try {
                Connection con = Mysql_BD.getInstance().cnn;
                PreparedStatement ps = con.prepareStatement(SQL_DELETE);
                ps.setLong(1, (Long) item);
                int result = ps.executeUpdate();
                return result > 0;
            } catch (SQLException ex) {
                System.out.println("Error al eliminar libro: " + ex.getMessage());
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean update(LibroDTO libro) {
        try {
            Connection con = Mysql_BD.getInstance().cnn;
            PreparedStatement ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, libro.getNombre());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getEditorial());
            ps.setInt(4, libro.getAnio());
            ps.setLong(5, libro.getIsbn());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar libro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public LibroDTO read(LibroDTO filter) {
        try {
            Connection con = Mysql_BD.getInstance().cnn;
            PreparedStatement ps = con.prepareStatement(SQL_READ);
            ps.setLong(1, filter.getIsbn());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new LibroDTO(
                        rs.getLong("isbn"),
                        rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("editorial"),
                        rs.getInt("anio")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error al leer libro: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<LibroDTO> readAll() {
        List<LibroDTO> lista = null;
        Connection con = Mysql_BD.getInstance().cnn;
        PreparedStatement psnt = null;
        ResultSet rs = null;
        try {

            psnt = con.prepareStatement(SQL_READALL);
            rs = psnt.executeQuery();
            lista = new ArrayList<LibroDTO>();
            while (rs.next()) {
                LibroDTO libro = new LibroDTO(rs.getLong("isbn"),
                        rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("editorial"),
                        rs.getInt("anio"));
                lista.add(libro);
            }

        } catch (SQLException ex) {
            System.out.println("eeror al consultar toda la tabla de libro" + ex.getMessage());
        }
        return lista;
    }

}
