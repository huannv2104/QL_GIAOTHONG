<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>Thêm Người Dùng</title>
</head>
<body>
    <h2>Thêm Người Dùng</h2>
    <form action="AddUserServlet" method="post">
        <label for="username">Tên Người Dùng:</label>
        <input type="text" id="username" name="username" required>
        <br><br>
        <label for="password">Mật Khẩu:</label>
        <input type="password" id="password" name="password" required>
        <br><br>
        <button type="submit">Thêm</button>
    </form>
    <br>
    <a href="ShowUsersServlet">Xem Danh Sách Người Dùng</a>
</body>
</html>