package by.epam.movieorder.dao;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.interfaces.UserDao;
import by.epam.movieorder.service.exception.ServiceException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUserDao implements UserDao {

	@Override
	public User logIn(String login, String password) throws DaoException {

		Connection connection = null;
		Statement statement = null;
		PreparedStatement prepareSt = null;
		ResultSet result = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// do special class for connection

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			prepareSt = connection.prepareStatement(
					"select user_id, login, password, first_name, last_name, phone_num, email  from users where login=? and password=?");
			prepareSt.setString(1, login);
			prepareSt.setString(2, password);
			result = prepareSt.executeQuery();

			if (result.next()) {

				User user = new User();

				user.setId(result.getInt("user_id"));
				user.setFirstName(result.getString("first_name"));
				user.setLastName(result.getString("last_name"));
				user.setPhoneNum(result.getString("phone_num"));
				user.setEmail(result.getString("email"));
				user.setLogin(result.getString("login"));
				user.setPassword(result.getString("password"));

				return user;
			} // add exception

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean registration(User user) throws DaoException {

		Connection connection = null;
		Statement statement = null;
		PreparedStatement selectSt = null;
		PreparedStatement insertSt = null;
		ResultSet result = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// do special class for connection

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			selectSt = connection.prepareStatement(
					"select login, password, first_name, last_name,	phone_num, email  from users where login=?");
			selectSt.setString(1, user.getLogin());
			result = selectSt.executeQuery();

			if (!result.next()) {

				insertSt = connection.prepareStatement(
						"INSERT INTO users (user_id, login,  password,  last_name,  first_name,  phone_num,   email,  admin_flg) VALUES(null,?,?,?,?,?,?,null)");
				// insertSt.setLong(1, 999);
				insertSt.setString(1, user.getLogin());

				insertSt.setString(2, user.getPassword());

				insertSt.setString(3, user.getLastName());

				insertSt.setString(4, user.getFirstName());

				insertSt.setString(5, user.getPhoneNum());

				insertSt.setString(6, user.getEmail());

				// insertSt.setLong(8, 0);

				insertSt.executeUpdate();

				connection.commit();

				return true;

			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {

			throw new DaoException();
		} catch (SQLException e) {
			throw new DaoException(e);

		}

	}

}
