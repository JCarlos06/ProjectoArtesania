package configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private String url="jdbc:mysql://localhost:3306/projectartesania";
    private String user="root";
    private String pass="";
    
    public Connection getConnection(){
        
        Connection con;
        con= null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion exitosa");
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
