package by.epam.movieorder.service.implementation;

import by.epam.movieorder.beans.Order;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.factory.DaoFactory;
import by.epam.movieorder.dao.interfaces.OrderDao;
import by.epam.movieorder.service.OrderService;
import by.epam.movieorder.service.exception.ServiceException;

public class OrderServiceImpl implements OrderService {

	@Override
	public Order showOrder(User user) throws ServiceException {
		System.out.println("aaa");
		try {

			DaoFactory daoObjectFactory = DaoFactory.getInstance();
			OrderDao orderDao = daoObjectFactory.getOrderDao();
			System.out.println("aaa");
			Order order = new Order();
			
			order = orderDao.showOrder(user);
			System.out.println("aaa after creat orderDao object in service");
			return order;

		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
