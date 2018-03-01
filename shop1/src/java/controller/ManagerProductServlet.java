/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author PeUt
 */
@WebServlet(name = "ManagerProductServlet", urlPatterns = {"/ManagerProductServlet"})
public class ManagerProductServlet extends HttpServlet {

    SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");
    ProductDAO spDao = new ProductDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");
           // String publishday = request.getParameter("publishday");
            String idDanhMuc = request.getParameter("idDanhMuc");
            String action = request.getParameter("action");
            // System.out.println(request.getParameter("anh"));
            switch (action) {
                case "add":

                    Product sp = new Product(Integer.parseInt(id), name, Integer.parseInt(quantity),
                            Double.parseDouble(price), new Category(idDanhMuc, ""));
                    
                    

                    if (spDao.addSanPham(sp) == 1) {
                        //out.print("haha");
                        request.setAttribute("LIST_SANPHAM", spDao.getAllSanPham());
                        System.out.println("LIST_SANPHAM:" + spDao.getAllSanPham().size());
                        request.getRequestDispatcher("/admin/manager_product.jsp").forward(request, response);
                    }

                    break;
                case "delete":
                    
                    if (spDao.deleteProduct(id)==1) {
                        request.getRequestDispatcher("/admin/manager_product.jsp").forward(request, response); 
                    }
                break;
                case "edit":
                    
                     request.setAttribute("PRODUCT", ProductDAO.gettProductbyID(id));
                request.setAttribute("CATEGORY_ID", ProductDAO.gettProductbyID(id).getIdDanhMuc());
                
                request.getRequestDispatcher("/admin/update_product.jsp").forward(request, response);
                break;
                case "update":
                    //out.print("mmm");
                    Product pr=new Product(Integer.parseInt(id), name, Integer.parseInt(quantity), Double.parseDouble(price), new Category(idDanhMuc, ""));
                    if (ProductDAO.updateProduct(pr)==1) {
                        request.getRequestDispatcher("/admin/manager_product.jsp").forward(request, response);
                    }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ManagerProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }    }


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
