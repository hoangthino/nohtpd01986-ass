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
        <title>Thêm khách hàng</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="<c:url value="/ckeditor/ckeditor.js" />"></script>

    </head>
    <body>
        <% CategoryDAO caedao=new CategoryDAO();%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>
            <form action="../khservlet" method="post">
                <div id="rightContent">
                    <h3>Thông tin khách hàng</h3>

                    <table width="95%">
                        <tr><td><b>Mã </b></td><td>
                                <input type="number" class="sedang" name="id"></td></tr>
                        <tr><td><b>Tên </b></td><td>
                                <input type="text" class="sedang" name="name"></td></tr>
                        <tr><td><b>SDT</b></td><td>
                                <input type="number" class="form-control" placeholder="Enter Quantity" name="quantity" class="sedang" ></td></tr>
                      <tr><td><b>Địa chỉ </b></td><td>
                                <input type="text" class="sedang" name="name"></td></tr>
                      <tr><td><b>mail </b></td><td>
                                <input type="text" class="sedang" name="name"></td></tr>
                        <tr><td><b>Loại sản phẩm</b></td><td>
                                <select name="idDanhMuc">
                                    <option selected>-- chọn loại sản phẩm --</option>
                                <% for (int i = 0; i < caedao.getAllSanPhamCombo().size(); i++) {%>
                                
                                <option value="<%=caedao.getAllSanPhamCombo().get(i).getCategoryID()%>"><%=caedao.getAllSanPhamCombo().get(i).getCategoryName()%></option>
                                    
                                
                                
                                      <%      
                                    }
                                %>
                                  
                                </select>
                            </td></tr>
                        
                            <td>
                                <textarea class="form-textarea" id="noiDung"> null</textarea>
                                <script type="text/javascript" language="javascript">
                                   CKEDITOR.replace('noiDung', {width: '500px',height: '300px'});
                                </script>
                            </td>
                        </tr>
                        <tr><td><b>Hình ảnh</b></td><td><input type="file" name="anh"></td></tr>
                        <tr><td></td><td>
                                <input type="hidden" class="button" name="action" value="add">
                                <input type="submit" class="button" value="Thêm">
                                
                            </td></tr>
                    </table>
                </div>
                                </form>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
