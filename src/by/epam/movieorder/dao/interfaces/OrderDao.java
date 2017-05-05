package by.epam.movieorder.dao.interfaces;

import by.epam.movieorder.beans.Order;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;

public interface OrderDao {
	 
	Order showOrder(User user) throws DaoException;
}
