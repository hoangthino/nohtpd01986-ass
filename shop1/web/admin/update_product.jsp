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
        <title>update sản phẩm</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="<c:url value="/ckeditor/ckeditor.js" />"></script>

    </head>
    <body>
        <% CategoryDAO caedao=new CategoryDAO();%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>
            <form action="<%=request.getContextPath()%>/ManagerProductServlet" method="post">
                <div id="rightContent">
                    <h3>Thông tin sản phẩm</h3>

                    <table width="95%">
                        <tr><td><b>Mã sản phẩm</b></td><td>
                                <input type="text" class="sedang" name="id" value="${PRODUCT.id}" readonly></td></tr>
                        <tr><td><b>Tên sản phẩm</b></td><td>
                                <input type="text" class="sedang" name="name" value="${PRODUCT.name}"></td></tr>
                        <tr><td><b>Số Lượng</b></td><td>
                                <input type="number" class="form-control" placeholder="Enter Quantity" name="quantity" class="sedang" value="${PRODUCT.quantity}" ></td></tr>
                        <tr><td><b>Giá bán</b></td><td>
                                <input type="text" class="sedang" name="price" value="${PRODUCT.price}"></td></tr>
<!--                        <tr><td><b>Ngày Sản Xuất</b></td><td>
                                <input type="date" class="form-control" placeholder="Enter Publishday:" name="publishday" class="sedang" value=""></td></tr>-->
                        <tr><td><b>Loại sản phẩm</b></td><td>
                                <select name="idDanhMuc" >
                                    <option selected>-- chọn loại sản phẩm --</option>
                                <% for (int i = 0; i < caedao.getAllSanPhamCombo().size(); i++) {%>
                                
                                <option value="<%=caedao.getAllSanPhamCombo().get(i).getCategoryID()%>" >   <%=caedao.getAllSanPhamCombo().get(i).getCategoryName()%> </option>
                                    
                                
                                
                                      <%      
                                    }
                                %>
                                  
                                </select>
                            </td></tr>
<!--                        <tr><td><b>Mô tả sản phẩm</b></td>
                            <td>
                                <textarea class="form-textarea" id="noiDung"></textarea>
                                <script type="text/javascript" language="javascript">
                                   CKEDITOR.replace('noiDung', {width: '500px',height: '300px'});
                                </script>
                            </td>
                        </tr>-->
<!--                        <tr><td><b>Hình ảnh</b></td><td><input type="file" name="anh"></td></tr>-->
                        <tr><td></td><td>
                                <input type="hidden" class="button" name="action" value="update">
                                <input type="submit" class="button" value="Luu">
                                
                            </td></tr>
                    </table>
                </div>
                                </form>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
