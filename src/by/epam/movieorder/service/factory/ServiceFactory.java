package by.epam.movieorder.service.factory;

import by.epam.movieorder.service.CommentService;
import by.epam.movieorder.service.MovieService;
import by.epam.movieorder.service.OrderService;
import by.epam.movieorder.service.UserService;
import by.epam.movieorder.service.implementation.CommentServiceImpl;
import by.epam.movieorder.service.implementation.MovieServiceImpl;
import by.epam.movieorder.service.implementation.OrderServiceImpl;
import by.epam.movieorder.service.implementation.UserServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final UserService userService = new UserServiceImpl();
	private final OrderService orderService = new OrderServiceImpl();
	private final MovieService movieService = new MovieServiceImpl();
	private final CommentService commentService = new CommentServiceImpl();

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

	public MovieService getMovieService() {
		return movieService;
	}
	
	public CommentService getCommentService() {
		return commentService;
	}
}
