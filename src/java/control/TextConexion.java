/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;
import conexion.Mysql_BD;
import java.sql.SQLException;
import java.util.List;
import modelo.dao.LibroDAO;
import modelo.dto.LibroDTO;
/**
 *
 * @author Estudiante
 */
public class TextConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
 //       Mysql_BD.getInstance();
   //     Mysql_BD.getInstance().CerrarConexion();
        LibroDAO dao=new LibroDAO();
        List<LibroDTO>lista=dao.readAll();
        
        for(LibroDTO i:lista){
            System.out.println(i.toString());
            
        }
        Mysql_BD.getInstance().CerrarConexion();
        
   
    }
    
}
