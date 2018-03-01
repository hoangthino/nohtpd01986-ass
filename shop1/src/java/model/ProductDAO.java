/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 8470p
 */
public class ProductDAO {

    SimpleDateFormat simpleDayFomat = new SimpleDateFormat("yyyy-MM-dd");

    public int addSanPham(Product sanpham) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedsttm = null;
        try {
            conn = new ConnectDB().getConnect();
            String sSQLInsert = "INSERT INTO `sanpham` (`id`, `name`, `quaty`, `price`, `IDDanhMuc`) VALUES ( ?, ?, ?, ?, ?);";
            preparedsttm = conn.prepareStatement(sSQLInsert);
            preparedsttm.setInt(1, sanpham.getId());
            preparedsttm.setString(2, sanpham.getName());
            preparedsttm.setInt(3, sanpham.getQuantity());
            preparedsttm.setDouble(4, sanpham.getPrice());

            preparedsttm.setInt(5, Integer.parseInt(sanpham.getIdDanhMuc().getCategoryID()));
            if (preparedsttm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            return -1;
        }
        return -1;
    }

    public static List<Product> getAllSanPham() throws SQLException {
        Connection conn = null;
        List<Product> listSP = new ArrayList<>();
        ConnectDB cn = new ConnectDB();
        conn = cn.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sanpham.id,sanpham.name,sanpham.quaty,sanpham.price,danhmuc.idDanhMuc,danhmuc.tenDanhMuc  FROM sanpham INNER JOIN danhmuc ON danhmuc.idDanhMuc=sanpham.idDanhmuc");
            while (rs.next()) {
                Product book = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                        new Category(rs.getString(5), rs.getString(6)));
                listSP.add(book);

            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }

        conn.close();
        return listSP;
    }

    public int deleteProduct(String id) {//DELETE FROM `product` WHERE 
        Connection conn = null;
        PreparedStatement preparedsttm = null;
        try {
            conn = new ConnectDB().getConnect();
            String sSQLInsert = "DELETE FROM `sanpham` WHERE `id`='" + Integer.parseInt(id) + "'";
            preparedsttm = conn.prepareStatement(sSQLInsert);
            if (preparedsttm.executeUpdate() == 1) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            return -1;
        }
        return -1;
    }

    public static Product gettProductbyID(String id) throws SQLException {
        Connection con = null;
        Product pr = null;
        ConnectDB cn = new ConnectDB();
        con = cn.getConnect();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT `id`,`name`,`quaty`,`price`,danhmuc.idDanhMuc,danhmuc.tenDanhMuc FROM sanpham INNER JOIN danhmuc ON danhmuc.idDanhmuc=sanpham.idDanhMuc where id='" + Integer.parseInt(id) + "'");
        while (rs.next()) {
            pr = new Product(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getInt(3), rs.getInt(4), new Category(rs.getString(5), rs.getString(6)));
        }
        con.close();
        return pr;

    }

    public static int updateProduct(Product sanpham) throws SQLException {
   Connection conn = null;
        PreparedStatement preparedsttm = null;
        try {
            conn = new ConnectDB().getConnect();
            String sSQLInsert = "UPDATE `sanpham` SET `name`=?,`quaty`=?,`price`=?,`idDanhMuc`=? WHERE `id`=?;";
            preparedsttm = conn.prepareStatement(sSQLInsert);
            preparedsttm.setInt(5, sanpham.getId());
            preparedsttm.setString(1, sanpham.getName());
            preparedsttm.setInt(2, sanpham.getQuantity());
            preparedsttm.setDouble(3, sanpham.getPrice());

            preparedsttm.setInt(4, Integer.parseInt(sanpham.getIdDanhMuc().getCategoryID()));
            if (preparedsttm.executeUpdate() > 0) {
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
            Product pr = new Product(1, "tuyen", 12, 120000, new Category("1", ""));

            System.out.println(updateProduct(pr));
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
