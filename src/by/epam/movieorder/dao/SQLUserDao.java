package by.epam.movieorder.dao;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.connection.OracleConnection;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.interfaces.UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDao implements UserDao {

	@Override
	public User logIn(String login, String password) throws DaoException {

		Connection connection = null;
		PreparedStatement prepareSt = null;
		ResultSet result = null;

		try {

			connection = OracleConnection.getConnection();
			String query = "select user_id, login, password, first_name, last_name, phone_num, email  from users where login=? and password=?";
			prepareSt = connection.prepareStatement(query);

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
			}

		} catch (SQLException e) {

			throw new DaoException();
		} finally {

			try {

				if (prepareSt != null) {
					prepareSt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				throw new DaoException();
			}
		}
		return null;
	}

	@Override
	public User registration(User user) throws DaoException {

		Connection connection = null;
		PreparedStatement selectSt = null;
		PreparedStatement insertSt = null;
		PreparedStatement getIdSt = null;
		ResultSet result = null;
		ResultSet getIdResult = null;

		try {

			connection = OracleConnection.getConnection();
			String query = "select login, password, first_name, last_name,	phone_num, email  from users where login=?";
			selectSt = connection.prepareStatement(query);

			selectSt.setString(1, user.getLogin());
			result = selectSt.executeQuery();

			connection.setAutoCommit(false);

			if (!result.next()) {

				insertSt = connection.prepareStatement(
						"INSERT INTO users (user_id, login,  password,  last_name,  first_name,  phone_num,   email,  admin_flg) VALUES(users_seq.NEXTVAL,?,?,?,?,?,?,0)");

				insertSt.setString(1, user.getLogin());

				insertSt.setString(2, user.getPassword());

				insertSt.setString(3, user.getLastName());

				insertSt.setString(4, user.getFirstName());

				insertSt.setString(5, user.getPhoneNum());

				insertSt.setString(6, user.getEmail());

				insertSt.executeUpdate();

				connection.commit();

				String queryForGetId = "select user_id from users where login=?";

				getIdSt = connection.prepareStatement(queryForGetId);

				getIdSt.setString(1, user.getLogin());

				getIdResult = getIdSt.executeQuery();

				if (getIdResult != null) {
					while (getIdResult.next()) {
						int id = getIdResult.getInt("user_id");
						user.setId(id);
					}
				}
				return user;

			} else {
				return new User();
			}
		} catch (SQLException e) {

			throw new DaoException();
		} finally {

			try {

				if (selectSt != null) {
					selectSt.close();
				}
				if (insertSt != null) {
					insertSt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				throw new DaoException();
			}
		}
	}

}
