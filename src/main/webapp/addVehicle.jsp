<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>Thêm Phương Tiện Giao Thông</title>
</head>
<body>
    <h2>Thêm Phương Tiện Giao Thông</h2>
    <form action="AddVehicleServlet" method="post">
        <label for="vehicleName">Tên Phương Tiện:</label>
        <input type="text" id="vehicleName" name="vehicleName" required>
        <br><br>
        <label for="licensePlate">Biển Số Xe:</label>
        <input type="text" id="licensePlate" name="licensePlate" required>
        <br><br>
        <label for="userId">ID Người Dùng:</label>
        <input type="number" id="userId" name="userId" required>
        <br><br>
        <button type="submit">Thêm</button>
    </form>
    <br>
    <a href="ShowVehiclesServlet">Xem Danh Sách Phương Tiện</a>
</body>
</html>