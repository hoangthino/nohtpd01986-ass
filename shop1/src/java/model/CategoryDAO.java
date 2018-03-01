/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 8470p
 */
public class CategoryDAO {

    public static ArrayList<Category> getAllCategory() throws SQLException {
        ArrayList<Category> list = new ArrayList<>();
        ConnectDB cn = new ConnectDB();
        Connection con = cn.getConnect();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `danhmuc`");
            while (rs.next()) {
                Category cate = new Category(String.valueOf(rs.getInt(1)), rs.getString(2));
                list.add(cate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.close();
        return list;
    }

    public int addCategory(Category cate) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedsttm = null;
        try {
            conn = new ConnectDB().getConnect();
            String sSQLInsert = "INSERT INTO `danhmuc` (`idDanhMuc`, `tenDanhMuc`) VALUES (?, ?)";
            preparedsttm = conn.prepareStatement(sSQLInsert);
            preparedsttm.setInt(1, Integer.parseInt(cate.getCategoryID()));
            preparedsttm.setString(2, cate.getCategoryName());
            if (preparedsttm.executeUpdate() == 1) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            return -1;
        }
        return -1;
    }

    public int findCategory(String id) throws SQLException {
        for (int i = 0; i < getAllCategory().size(); i++) {
            if (id.equalsIgnoreCase(getAllCategory().get(i).getCategoryID())) {
                return i;
            }
        }
        return -1;
    }

    public static Category gettCategorybyID(String id) throws SQLException {
        Connection con=null;
        Category cate=null;
        ConnectDB cn=new ConnectDB();
        con=cn.getConnect();
        Statement st=con.createStatement();
    
        ResultSet rs=st.executeQuery("SELECT * FROM danhmuc");
        while (rs.next()) {            
            cate=new Category(rs.getString(1), rs.getString(2));
        }
        return cate;
        
    }



    public List<Category> getAllSanPhamCombo() throws SQLException {
        Connection conn = null;
        List<Category> listSP = new ArrayList<>();
        ConnectDB cn = new ConnectDB();
        conn = cn.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT danhmuc.idDanhMuc,danhmuc.tenDanhMuc FROM danhmuc ");
            while (rs.next()) {
                Category book = new Category(rs.getString(1), rs.getString(2));
                listSP.add(book);

            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }

        conn.close();
        return listSP;
    }

    public int delmoCategory(String id) throws SQLException {
        Connection conn = null;
        ConnectDB cn=new ConnectDB();
        conn = cn.getConnect();
        PreparedStatement preparedsttm = null;
        PreparedStatement xoa = null;
        
        try {
            

                xoa = conn.prepareStatement("DELETE FROM `sanpham` WHERE `idDanhMuc` like '" + Integer.parseInt(id) + "'");
                xoa.executeUpdate();
           

            String sSQLInsert = "DELETE FROM `danhmuc` WHERE `idDanhMuc`='" + Integer.parseInt(id) + "'";
            preparedsttm = conn.prepareStatement(sSQLInsert);
            if (preparedsttm.executeUpdate() == 1) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            return -1;
        }
         conn.close();
        xoa.close();
        return -1;
       
    }
    public int UpdateCategory(Category cate) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedsttm = null;
        try {
            conn = new ConnectDB().getConnect();
            String sSQLInsert = "UPDATE `danhmuc` SET `tendanhMuc`=? WHERE `idDanhmuc`=?";
            preparedsttm = conn.prepareStatement(sSQLInsert);
            preparedsttm.setInt(2, Integer.parseInt(cate.getCategoryID()));
            preparedsttm.setString(1, cate.getCategoryName());
            if (preparedsttm.executeUpdate() == 1) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            return -1;
        }
        return -1;
    }
    public static void main(String[] args) {
        try {
            CategoryDAO c=new CategoryDAO();
            System.out.println(c.delmoCategory("1"));
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
