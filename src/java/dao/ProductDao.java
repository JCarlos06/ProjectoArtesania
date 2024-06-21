
package dao;

import configuration.Conexion;
import java.sql.Connection;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<Product> productos = new ArrayList();
 
        try{
            con =cn.getConnection();
            String sql = "select*from producto";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Product p= new Product();
                p.setId(rs.getInt(1));
                p.setNombre((rs.getString(2)));
                p.setCategoria((rs.getInt(3)));
                p.setFoto(rs.getBinaryStream(4));
                p.setDescription(rs.getString(5));
                p.setPrecio(rs.getDouble(6));
                p.setStock(rs.getInt(7));
                productos.add(p);          
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return productos;
            
    }
        public void listarImg(int id, HttpServletResponse response){
            
            String sql = "select*from producto where idProducto" + id;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            BufferedInputStream bufferedInputStream = null;
            BufferedOutputStream bufferedOutputStream = null;   
            try{
                outputStream = response.getOutputStream();
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    inputStream=rs.getBinaryStream("Foto");
                }
                
                bufferedInputStream= new BufferedInputStream(inputStream);
                bufferedOutputStream = new BufferedOutputStream(outputStream);
                int i= 0;
                
                while ((i=bufferedInputStream.read())!=-1){
                    bufferedOutputStream.write(i);
                }
            }catch(Exception e){
                
            }
        }
        
        public Product listarId(int id){
            String sql = "select * from producto where idProducto="+id;
            Product p = new Product();
            
            try{
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre((rs.getString(2)));
                p.setCategoria((rs.getInt(3)));
                p.setFoto(rs.getBinaryStream(4));
                p.setDescription(rs.getString(5));
                p.setPrecio(rs.getDouble(6));
                p.setStock(rs.getInt(7));
                }
            }
                catch(Exception e){
                }
            
            return p;
        }
        
        public List<Product> listarPorCategoria(String categoria) {
        List<Product> productos = new ArrayList<>();

        try {
            con = cn.getConnection();
            String sql = "SELECT * FROM producto WHERE IDCategoria = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, categoria);
            rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescription(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                productos.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productos;
    }
}
