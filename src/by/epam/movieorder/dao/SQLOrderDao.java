package by.epam.movieorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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

		try {

			connection = OracleConnection.getConnection();

			String query = "SELECT o.order_id as order_id, m.name as name, m.price as price, m.movie_id as movie_id, m.director as director, m.duration as duration, m.genre as genre FROM USERS u left join ORDERS o ON o.user_id = u.user_id left join MOVIES m ON o.movie_id = m.movie_id WHERE  u.user_id =?";

			prepareSt = connection.prepareStatement(query);

			prepareSt.setInt(1, user.getId());

			result = prepareSt.executeQuery();

			Map<Integer, Order> orderMap = new HashMap<>();

			while (result.next()) {

				int id = result.getInt("order_id");
				Order order = orderMap.get(id);
				if (order == null) {
					order = new Order();
					order.setId(id);

				}
				Movie movie = new Movie();
				// add set field for movie
				movie.setId(result.getInt("movie_id"));
				movie.setName(result.getString("name"));

				order.addMovie(movie);
				orderMap.put(id, order);

			}

			Collection<Order> c = orderMap.values();

			List<Order> orderList = new ArrayList<>(c);

			return orderList;

		} catch (SQLException e) {

			throw new DaoException(e);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
