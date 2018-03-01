<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

<%@page import="model.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý danh mục</title>

       
        <link href=" <%=request.getContextPath() %>/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
        
     

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
               
               
<!--                                          <div class="informasi">
                                        ini adalah notifikasi pertanda informasi
                                    </div>
                
                                    <div class="gagal">
                                        ini adalah notifikasi pertanda gagal
                                    </div>
                
                                    <div class="sukses">
                                        ini adalah notifikasi pertanda sukses
                                    </div>-->
                    <h3>Thêm Danh Mục</h3>
                    <form action="../ManagerCategoryServlet" method="post">
                    <table width="95%">
                          <tr>
                            <td style="float: right"><b>ID danh mục </b></td>
                            <td><input type="text" class="sedang" name="idDanhMuc"></td>
                        </tr>
                        <tr>
                            <td style="float: right"><b>Tên danh mục:</b></td>
                            <td><input type="text" class="sedang" name="tenDanhMuc"></td>
                        </tr>
                        <tr><td></td><td>
                                <input type="hidden" name="command" value="insert">
                                <input type="submit" class="button" value="Lưu dữ liệu">
                            </td>
                        </tr>
                    </table>
                    </form>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
