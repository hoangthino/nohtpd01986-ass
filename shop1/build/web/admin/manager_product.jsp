<%-- 
    Document   : manager_product
    Created on : 19-May-2016, 7:33:54 PM
    Author     : TUNGDUONG
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>


        <link href=" <%=request.getContextPath()%>/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
        <% ProductDAO da=new ProductDAO();
        SimpleDateFormat simpleDayFomat = new SimpleDateFormat("dd-MM-yyyy");%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Quản lí Sản Phẩm</h3>
                    <a href=" <%=request.getContextPath()%>/admin/insert_product.jsp">Thêm Sản Phẩm</a>
                <!--                    <div class="informasi">
                                        ini adalah notifikasi pertanda informasi
                                    </div>
                
                                    <div class="gagal">
                                        ini adalah notifikasi pertanda gagal
                                    </div>
                
                                    <div class="sukses">
                                        ini adalah notifikasi pertanda sukses
                                    </div>-->
                <table class="data">
                    <tr class="data">
                        <th class="data" width="30px">ID</th>
                        <th class="data">Tên</th>
                        <th class="data">Số Lượng</th>
                        <th class="data">Giá</th>
<!--                        <th class="data">Ngày Sản Xuất</th>-->
                        <th class="data">Danh Mục</th>
                        <th class="data" width="75px">Tùy chọn</th>
                    </tr>
                    <% for (int i = 0; i < da.getAllSanPham().size(); i++) {%>
                            
                        
                    
                     
                         <tr class="data">
                             <td class="data" width="30px"><%=da.getAllSanPham().get(i).getId() %></td>
                        <td class="data"><%=da.getAllSanPham().get(i).getName() %></td>
                        <td class="data"><%=da.getAllSanPham().get(i).getQuantity()%></td>
                        <td class="data"><%=da.getAllSanPham().get(i).getPrice()%></td>
                        <!--<td class="data">  null </td>-->
                        
                        <td class="data"><%=da.getAllSanPham().get(i).getIdDanhMuc().getCategoryName() %></td>
                        <td class="data" width="75px">
                    <center>
                        <a href='<%=request.getContextPath() %><%="/ManagerProductServlet?action=edit&&id="+ ProductDAO.getAllSanPham().get(i).getId()%>'> <img src=" <%=request.getContextPath()%>mos-css/img/oke.png">Sửa</a>&nbsp;&nbsp;&nbsp;|
                        <a href='<%=request.getContextPath() %><%="/ManagerProductServlet?action=delete&&id=" +ProductDAO.getAllSanPham().get(i).getId() %>'>Xóa</a>
                    </center>
                    </td>
                    </tr>
                 
                <% }%>
                   

                </table>
            </div>
            <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
