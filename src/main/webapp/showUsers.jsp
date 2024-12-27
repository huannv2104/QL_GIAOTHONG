<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Danh sách Người dùng</title>
</head>
<body>
    <h1>Danh sách Người dùng</h1>

    <form action="addUser" method="post">
        <input type="text" name="username" placeholder="Tên người dùng" required>
        <input type="password" name="password" placeholder="Mật khẩu" required>
        <button type="submit">Thêm người dùng</button>
    </form>

    <table border="1">
        <tr>
            <th>Tên người dùng</th>
            <th>Mật khẩu</th>
            <th>Hành động</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>
                    <a href="showVehicles?userId=${user.userId}">Xem phương tiện</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
