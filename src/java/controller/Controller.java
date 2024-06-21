
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import dao.ProductDao;
import model.Carrito;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    
    ProductDao pdao = new ProductDao();
    Product p = new Product();
    List<Product> productos = new ArrayList();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar=0.0;
    int cantidad=1;
    Carrito car;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String accion = request.getParameter("accion");
        String categoria = request.getParameter("categoria");

        if (categoria != null && !categoria.isEmpty()) {
            productos = pdao.listarPorCategoria(categoria);
        } else {
            productos = pdao.listar();
        }
        productos=pdao.listar();
        switch(accion){
            case "Comprar":
                int idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarId(idp);
                item = item + 1;
                Carrito carr = new Carrito();
                carr.setItem(item);
                carr.setIdProducto(p.getId());
                carr.setNombres(p.getNombre());
                carr.setDescripcion(p.getDescription());
                carr.setPrecioCompra(p.getPrecio());
                carr.setCantidad(cantidad);
                carr.setSubtotal(cantidad * p.getPrecio());
                listaCarrito.add(carr);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
                
            case "Agregar":
                int pos=0;
                cantidad = 1;
                idp=Integer.parseInt(request.getParameter("id"));
                p = pdao.listarId(idp);
                
                if(listaCarrito.size()>0){
                    for (int i=0; i<listaCarrito.size(); i++){
                        if(idp==listaCarrito.get(i).getIdProducto()){
                            pos =i;
                        }
                    }
                    if(idp == listaCarrito.get(pos).getIdProducto()){
                        cantidad=listaCarrito.get(pos).getCantidad()+cantidad;
                        double subtotal = listaCarrito.get(pos).getPrecioCompra()*cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal(subtotal);
                    }else{
                        item = item + 1;
                        carr = new Carrito();
                        carr.setItem(item);
                        carr.setIdProducto(p.getId());
                        carr.setNombres(p.getNombre());
                        carr.setDescripcion(p.getDescription());
                        carr.setPrecioCompra(p.getPrecio());
                        carr.setCantidad(cantidad);
                        carr.setSubtotal(cantidad * p.getPrecio());
                        listaCarrito.add(carr);
                    }
                    
                }else{
                    item = item + 1;
                    carr = new Carrito();
                    carr.setItem(item);
                    carr.setIdProducto(p.getId());
                    carr.setNombres(p.getNombre());
                    carr.setDescripcion(p.getDescription());
                    carr.setPrecioCompra(p.getPrecio());
                    carr.setCantidad(cantidad);
                    carr.setSubtotal(cantidad * p.getPrecio());
                    listaCarrito.add(carr);

                }

                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("Controller?accion=productos").forward(request, response);
                
                break;
                
            case "Carrito":
                totalPagar=0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
               
                break;
                
            case "Delete":
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                for(int i=0; i<listaCarrito.size();i++){
                    if(listaCarrito.get(i).getIdProducto()== idproducto){
                        listaCarrito.remove(i);
                    }
                }   
                break;
                
            case "ActualizarCantidad":
                int idpro=Integer.parseInt(request.getParameter("idp"));
                int cant = Integer.parseInt(request.getParameter("cantidad"));
                for(int i=0; i<listaCarrito.size(); i++){
                    if(listaCarrito.get(i).getIdProducto()==idpro){
                        listaCarrito.get(i).setCantidad(cant);
                        double st = listaCarrito.get(i).getPrecioCompra()*cant;
                        listaCarrito.get(i).setSubtotal(st);
                    }
                }
                break;
                
            default:
                request.setAttribute("productos",productos);
                request.getRequestDispatcher("productos.jsp").forward(request, response);
              
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
