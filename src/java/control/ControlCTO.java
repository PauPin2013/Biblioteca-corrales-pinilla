/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modelo.dao.LibroDAO;
import modelo.dto.LibroDTO;

/**
 *
 * @author Estudiante
 */
public class ControlCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    long ide;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        LibroDAO dao = new LibroDAO();
        LibroDTO dto = new LibroDTO();

        switch (menu) {
            case ("Libros"): {
                List<LibroDTO> lista = dao.readAll();
                if (accion.equalsIgnoreCase("Listar")) {

                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("libro_vta.jsp").forward(request, response);

                } else {
                    request.getRequestDispatcher("error.html").forward(request, response);
                }
                break;

            }
            case ("Agregar"): {
                String isbn = request.getParameter("txtIsbn");
                String nom = request.getParameter("txtNombre");
                String autor = request.getParameter("txtAutor");
                String editorial = request.getParameter("txtEditorial");
                String anio = request.getParameter("txtAnio");
                dto.setIsbn(Long.parseLong(isbn));
                dto.setNombre(nom);
                dto.setAutor(autor);
                dto.setEditorial(editorial);
                dto.setAnio(Integer.parseInt(anio));
                dao.create(dto);
                request.getRequestDispatcher("ControlCTO?menu=Libros&accion=Listar").forward(request, response);
                break;
            }
            case ("Editar"): {
                ide = Long.parseLong(request.getParameter("id"));
                dto.setIsbn(ide);
                LibroDTO libro = dao.read(dto);
                request.setAttribute("libro", libro);
                request.getRequestDispatcher("ControlCTO?menu=Libros&accion=Listar").forward(request, response);
                break;
            }
            case ("Actualizar"): {
                String isbn = request.getParameter("txtIsbn");
                String nom = request.getParameter("txtNombre");
                String autor = request.getParameter("txtAutor");
                String editorial = request.getParameter("txtEditorial");
                String anio = request.getParameter("txtAnio");
                dto.setIsbn(ide);
                dto.setNombre(nom);
                dto.setAutor(autor);
                dto.setEditorial(editorial);
                dto.setAnio(Integer.parseInt(anio));
                dao.update(dto);
                request.getRequestDispatcher("ControlCTO?menu=Libros&accion=Listar").forward(request, response);
                break;
            }
            case ("Eliminar"): {
                ide = Long.parseLong(request.getParameter("id"));
                dao.delete(ide);
                request.getRequestDispatcher("ControlCTO?menu=Libros&accion=Listar").forward(request, response);
                break;
            }
            default: {
                request.getRequestDispatcher("error.html").forward(request, response);
            }
            request.getRequestDispatcher("libro_vta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
