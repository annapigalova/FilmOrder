package by.epam.movieorder.dao.factory;

import by.epam.movieorder.dao.SQLCommentDao;
import by.epam.movieorder.dao.SQLMovieDao;
import by.epam.movieorder.dao.SQLOrderDao;
import by.epam.movieorder.dao.SQLUserDao;
import by.epam.movieorder.dao.interfaces.CommentDao;
import by.epam.movieorder.dao.interfaces.MovieDao;
import by.epam.movieorder.dao.interfaces.OrderDao;
import by.epam.movieorder.dao.interfaces.UserDao;

public final class DaoFactory {

	private static final DaoFactory instance = new DaoFactory();

	private final UserDao sqlUserImpl = new SQLUserDao();
	private final OrderDao sqlOrderImpl = new SQLOrderDao();
	private final MovieDao sqlMovieImpl = new SQLMovieDao();
	private final CommentDao sqlCommentImpl = new SQLCommentDao();

	public static DaoFactory getInstance() {
		return instance;
	}

	public UserDao getUserDao() {
		return sqlUserImpl;
	}

	public OrderDao getOrderDao() {
		return sqlOrderImpl;
	}

	public MovieDao getMovieDao() {
		return sqlMovieImpl;
	}

	public CommentDao getCommentDao() {
		return sqlCommentImpl;
	}
}
