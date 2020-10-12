import java.awt.List;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Dao {

	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "abeg");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static int save(String book_name, int book_id, String author) {
		Connection conn = Dao.getConnection();
		int status = 0;
		try {
			String query = "insert into book (book_name, book_id, author) values (?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, book_name);
			preparedStatement.setInt(2, book_id);
			preparedStatement.setString(3, author);
			status = preparedStatement.executeUpdate();

			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static ArrayList<String> getName() {
		ArrayList<String> list = new ArrayList<>();
		Connection conn = Dao.getConnection();
		try {
			String query = "select * from book";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("book_name");
				list.add(name);
			}
			rs.close();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static DefaultTableModel getBookListDataInTableModelForm() {
		Connection conn = Dao.getConnection();
		String[] str = { "id", "Book Name", "Book ID", "Author" };
		DefaultTableModel defaultTableModel = new DefaultTableModel(str, 0);
		try {
			String query = "select * from book";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String[] strings = new String[4];
				strings[0] = String.valueOf(rs.getInt(1));
				strings[1] = rs.getString(2);
				strings[2] = String.valueOf(rs.getInt(3));
				strings[3] = rs.getString(4);
				defaultTableModel.addRow(strings);
			}
			rs.close();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return defaultTableModel;
	}
}