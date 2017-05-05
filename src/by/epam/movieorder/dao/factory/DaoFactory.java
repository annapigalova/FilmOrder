package by.epam.movieorder.dao.factory;

import by.epam.movieorder.dao.SQLOrderDao;
import by.epam.movieorder.dao.SQLUserDao;
import by.epam.movieorder.dao.interfaces.OrderDao;
import by.epam.movieorder.dao.interfaces.UserDao;

public final class DaoFactory {

	private static final DaoFactory instance = new DaoFactory();

	private final UserDao sqlUserImpl = new SQLUserDao();
	private final OrderDao sqlOrderImpl = new SQLOrderDao();

	public static DaoFactory getInstance() {
		return instance;
	}

	public UserDao getUserDao() {
		return sqlUserImpl;
	}

	public OrderDao getOrderDao() {
		return sqlOrderImpl;
	}

}
