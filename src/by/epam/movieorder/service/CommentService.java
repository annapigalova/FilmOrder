package by.epam.movieorder.service;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.service.exception.ServiceException;

public interface CommentService {
	
	  boolean addComment(String text, User user, int movieId) throws ServiceException;
	

}
