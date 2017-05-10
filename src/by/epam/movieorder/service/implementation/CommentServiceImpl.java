package by.epam.movieorder.service.implementation;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.factory.DaoFactory;
import by.epam.movieorder.dao.interfaces.CommentDao;
import by.epam.movieorder.service.CommentService;
import by.epam.movieorder.service.exception.ServiceException;

public class CommentServiceImpl implements CommentService {

	@Override
	public boolean addComment(String text, User user, int movieId) throws ServiceException {
		boolean isStatusOk = false;
		try {

			DaoFactory daoObjectFactory = DaoFactory.getInstance();
			CommentDao commentDao = daoObjectFactory.getCommentDao();
			isStatusOk = commentDao.addComment(text, user, movieId);

			return isStatusOk;

		} catch (DaoException e) {

			throw new ServiceException(e);
		}

	}
}
