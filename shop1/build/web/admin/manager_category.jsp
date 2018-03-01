<%-- 
    Document   : manager_category
    Created on : 19-May-2016, 7:30:15 PM
    Author     : TUNGDUONG
--%>

<
<%@page import="model.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý danh mục</title>


        <link href=" <%=request.getContextPath()%>/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>


        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>
                <form action="../ManagerCategoryServlet" method="post">
                    <div id="rightContent">
                        <h3>Quản lý danh mục</h3>

                        <a href=" <%=request.getContextPath()%>/admin/insert_category.jsp">Thêm danh mục </a>

                    <table class="data">

                        <tr class="data">

                            <th class="data" >Mã danh mục</th>
                            <th class="data">Tên danh mục</th>
                            <th class="data" width="90px">Tùy chọn</th>
                        </tr>


                        <%  for (int i = 0; i < CategoryDAO.getAllCategory().size(); i++) {%>

                        <tr class="data">

                            <td class="data"> <%=CategoryDAO.getAllCategory().get(i).getCategoryID()%></td>
                            <td class="data"><%=CategoryDAO.getAllCategory().get(i).getCategoryName()%></td>
                            <td class="data" width="90px">
                        <center>
                            <!--<a href='" /admin/update_category.jsp?command=update&idDanhMuc="'>Sửa</a>&nbsp;&nbsp; | &nbsp;&nbsp;-->
                            <a href='<%=request.getContextPath()%><%="/ManagerCategoryServlet?command=edit&&idDanhMuc=" + CategoryDAO.getAllCategory().get(i).getCategoryID()%>'>Sửa</a>
                            <a href='<%=request.getContextPath()%><%="/ManagerCategoryServlet?command=delete&&idDanhMuc=" + CategoryDAO.getAllCategory().get(i).getCategoryID()%>'>Xóa</a>
                        </center>
                        </td>
                        </tr>



                        <% }%>






                    </table>

                </div>
                <div class="clear"></div>
            </form>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>

    </body>
</html>
