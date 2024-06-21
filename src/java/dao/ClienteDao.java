
package dao;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ClienteDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
     public List listar(){
        List<Product> productos = new ArrayList();
        String sql = "select*from cliente";
        try{
            con =cn.getConnection();
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Product p= new Product();
                p.setId(rs.getInt(1));
                p.setNombre((rs.getString(2)));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescription(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                productos.add(p);
                        
            }
        }catch(Exception e){
            
        }
        return productos;
            
    }
}
