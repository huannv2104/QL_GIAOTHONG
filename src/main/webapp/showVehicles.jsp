<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Danh sách Phương tiện Giao thông</title>
</head>
<body>
    <h1>Danh sách Phương tiện Giao thông</h1>

    <form action="addVehicle" method="post">
        <input type="text" name="vehicleName" placeholder="Tên phương tiện" required>
        <input type="text" name="licensePlate" placeholder="Biển số xe" required>
        <input type="hidden" name="userId" value="${userId}">
        <button type="submit">Thêm phương tiện</button>
    </form>

    <table border="1">
        <tr>
            <th>Tên phương tiện</th>
            <th>Biển số xe</th>
            <th>Hành động</th>
        </tr>
        <c:forEach var="vehicle" items="${vehicles}">
            <tr>
                <td>${vehicle.vehicleName}</td>
                <td>${vehicle.licensePlate}</td>
                <td>
                    <!-- Cập nhật hoặc xóa phương tiện -->
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
