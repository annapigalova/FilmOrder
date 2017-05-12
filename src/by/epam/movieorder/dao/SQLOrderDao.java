package by.epam.movieorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.beans.Order;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.connection.OracleConnection;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.interfaces.OrderDao;

public class SQLOrderDao implements OrderDao {

	@Override
	public List<Order> showOrder(User user) throws DaoException {

		Connection connection = null;
		PreparedStatement prepareSt = null;
		ResultSet result = null;
		List<Order> orderList = new ArrayList<>();

		try {

			connection = OracleConnection.getConnection();
			String query = "SELECT o.order_id as order_id, o.order_dt as orderDate, m.name as name, m.price as price, m.movie_id as movie_id, m.director as director, m.duration as duration, m.genre as genre FROM USERS u right join ORDERS o ON o.user_id = u.user_id left join MOVIES m ON o.movie_id = m.movie_id WHERE  u.user_id =?";

			prepareSt = connection.prepareStatement(query);
			prepareSt.setInt(1, user.getId());
			result = prepareSt.executeQuery();

			Map<Integer, Order> orderMap = new HashMap<>();

			if (result != null) {
				while (result.next()) {

					int id = result.getInt("order_id");
					Date orderDate = result.getDate("orderDate");
					Order order = orderMap.get(id);
					if (order == null) {
						order = new Order();
						order.setId(id);
						order.setOrderDate(orderDate);

					}

					Movie movie = new Movie();

					movie.setId(result.getInt("movie_id"));
					movie.setName(result.getString("name"));

					order.addMovie(movie);
					orderMap.put(id, order);

				}
			}

			Collection<Order> c = orderMap.values();
			orderList = new ArrayList<>(c);

			return orderList;

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

	}

	@Override
	public boolean payOrder(List<Movie> movieList, User user) throws DaoException {
		Connection connection = null;
		PreparedStatement prepareSt = null;
		PreparedStatement preparedStId = null;
		ResultSet idSeqResult = null;

		try {

			connection = OracleConnection.getConnection();

			String getIdSeq = "select orders_seq.NEXTVAL from dual";
			preparedStId = connection.prepareStatement(getIdSeq);
			idSeqResult = preparedStId.executeQuery();
			int orderId = -999;
			if (idSeqResult.next()) {
				orderId = idSeqResult.getInt(1);
			}

			String query = "INSERT INTO orders (order_id, movie_id, user_id, pay_flg, amount, order_dt) VALUES (?, ?, ?, ?, ?,"
					+ "to_date('" + getCurrentTimeStamp() + "', 'yyyy-mm-dd hh24-mi-ss'))";

			prepareSt = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			int userId = user.getId();

			for (int i = 0; i < movieList.size(); i++) {

				prepareSt.setInt(1, orderId);
				prepareSt.setInt(2, movieList.get(i).getId());
				prepareSt.setInt(3, userId);
				prepareSt.setInt(4, 1);
				prepareSt.setDouble(5, movieList.get(i).getPrice());

				prepareSt.addBatch();

			}

			prepareSt.executeBatch();
			connection.commit();
			return true;
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

	}

	private static String getCurrentTimeStamp() {

		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		return sdf.format(date);

	}
}
