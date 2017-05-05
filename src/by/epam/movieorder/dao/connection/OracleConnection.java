package by.epam.movieorder.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import by.epam.movieorder.dao.exception.DaoException;

public class OracleConnection {

	public static Connection getConnection() throws DaoException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException e) {

			throw new DaoException();
		} catch (SQLException e) {

			throw new DaoException(e);

		}

	}

}
