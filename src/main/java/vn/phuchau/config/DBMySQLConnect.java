package vn.phuchau.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMySQLConnect {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/DB_UTE";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "admin123";

	public static Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Kết nối thành công đến Database!");
		} catch (SQLException ex) {
			System.err.println("Lỗi kết nối Database: " + ex.getMessage());
		}
		return con;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Connection conn = DBMySQLConnect.getConnection();
			if (conn == null)
				return;

			String sqlInsert = "INSERT INTO User (username, email, password) VALUES (?, ?, ?)";
			String selectAll = "SELECT * FROM User";

			// Thêm dữ liệu mẫu
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			stmt.setString(1, "hau");
			stmt.setString(2, "hau@example.com");
			stmt.setString(3, "admin123");
			stmt.executeUpdate();
			System.out.println("Đã chèn dữ liệu vào bảng User!");

			stmt = conn.prepareStatement(selectAll);
			ResultSet rs = stmt.executeQuery();

			System.out.println("Danh sách User:");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " - " + rs.getString("username") + " - " + rs.getString("email")
						+ " - " + rs.getString("password"));
			}

			rs.close();
			stmt.close();
			conn.close(); // đóng kết nối
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
