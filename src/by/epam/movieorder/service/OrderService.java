package by.epam.movieorder.service;

import by.epam.movieorder.beans.Order;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.service.exception.ServiceException;

public interface OrderService {
	 Order showOrder(User user) throws ServiceException;
}
