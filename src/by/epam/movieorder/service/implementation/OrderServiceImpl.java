package by.epam.movieorder.service.implementation;

import java.util.ArrayList;
import java.util.List;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.beans.Order;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.factory.DaoFactory;
import by.epam.movieorder.dao.interfaces.OrderDao;
import by.epam.movieorder.service.OrderService;
import by.epam.movieorder.service.exception.ServiceException;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> showOrder(User user) throws ServiceException {

		try {

			DaoFactory daoObjectFactory = DaoFactory.getInstance();
			OrderDao orderDao = daoObjectFactory.getOrderDao();
			List<Order> orderList = new ArrayList<>();
			orderList = orderDao.showOrder(user);

			return orderList;

		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean payOrder(List<Movie> movieList, User user) throws ServiceException {

		boolean isPayOk = false;
		try {

			DaoFactory daoObjectFactory = DaoFactory.getInstance();
			OrderDao orderDao = daoObjectFactory.getOrderDao();

			isPayOk = orderDao.payOrder(movieList, user);

			return isPayOk;

		} catch (DaoException e) {
			throw new ServiceException(e);

		}

	}

}
