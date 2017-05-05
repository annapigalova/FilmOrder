package by.epam.movieorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.beans.Order;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.connection.OracleConnection;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.interfaces.OrderDao;

public class SQLOrderDao implements OrderDao {

	@Override
	public Order showOrder(User user) throws DaoException {
		
		Connection connection = null;
		PreparedStatement prepareSt = null;
		ResultSet result = null;
	
		try {

			connection = OracleConnection.getConnection();
			
			String query = "SELECT o.order_id as order_id, m.name as name, m.price as price, m.movie_id as movie_id, m.director as director, m.duration as duration, m.genre as genre FROM USERS u left join ORDERS o ON o.user_id = u.user_id left join MOVIES m ON o.movie_id = m.movie_id WHERE  u.user_id =?";
	
			System.out.println(query);
			prepareSt = connection.prepareStatement(query);
			prepareSt.setInt(1, user.getId());
			 
			System.out.println(user.getId());
			result = prepareSt.executeQuery();
			int records = 0;
	 
			System.out.println("Number of records: " + records);
			Order order = new Order();

			int i = 0;

			while (result.next()) {
				System.out.println(i);
				List<Movie> movieList = new ArrayList<>();

				movieList.add(new Movie());
				movieList.get(i).setName(result.getString("name"));
				System.out.println(movieList.get(i).getName());
				movieList.get(i).setPrice(result.getDouble("price"));

				order.setId(result.getInt("order_id"));
				order.addMovie(movieList.get(i));
				i++;

			}

		} catch (SQLException e) {

			throw new DaoException(e);

		}
		return null;
	}
}
