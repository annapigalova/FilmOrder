package by.epam.movieorder.dao.interfaces;

import java.util.List;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.beans.Order;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;

public interface OrderDao {

	List<Order> showOrder(User user) throws DaoException;

	boolean payOrder(List<Movie> movieList, User user) throws DaoException;
}
