/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Estudiante
 */
public class Mysql_BD {
    
    private static Mysql_BD instance;
    public Connection cnn;
    private String driver="com.mysql.cj.jdbc.Driver";
    private String user="root";
    private String pss="";
    private String nom_bd="bd_biblioteca";
    private String url= "jdbc:mysql://localhost:3306/";

    private  Mysql_BD() {
        System.out.println("creando instancia");
        try {
            Class.forName(driver);
            cnn=DriverManager.getConnection(url+nom_bd,user,pss);
            System.out.println("Hay conexion");
        } catch (ClassNotFoundException | SQLException  ex) {
            System.out.println("error al cargar drive BD"+ex.getMessage());
        }
        
    }

    public static synchronized Mysql_BD getInstance() {
        if(instance==null){
            instance =new Mysql_BD();
        }
            
     
        return instance;
    }
    public void CerrarConexion(){
        if(cnn !=null){
            try{
                cnn.close();
                System.out.println("conexion cerrada");
            }catch(SQLException ex){
                System.out.println("error al cerrar la base de datos"+ex.getMessage());
            }
        }
        instance=null;
    }
}
    
   
   

   
    

