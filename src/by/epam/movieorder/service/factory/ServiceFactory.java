package by.epam.movieorder.service.factory;

import by.epam.movieorder.service.OrderService;
import by.epam.movieorder.service.UserService;
import by.epam.movieorder.service.implementation.OrderServiceImpl;
import by.epam.movieorder.service.implementation.UserServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final UserService userService = new UserServiceImpl();
	private final OrderService orderService = new OrderServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}
	
	public OrderService getOrderService() {
		return orderService;
	}

}
