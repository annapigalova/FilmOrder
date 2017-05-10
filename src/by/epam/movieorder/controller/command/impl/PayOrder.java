package by.epam.movieorder.controller.command.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.service.OrderService;
import by.epam.movieorder.service.exception.ServiceException;
import by.epam.movieorder.service.factory.ServiceFactory;

public class PayOrder implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		String goTo = null;

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		List<Movie> movieList = (ArrayList<Movie>) session.getAttribute("movieList");

		try {

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			OrderService orderService = serviceFactory.getOrderService();
			boolean isPayOk = orderService.payOrder(movieList, user);

			if (isPayOk) {

				session.removeAttribute("movieList");
				goTo = "/ShoppingCart.jsp";
			} else {

				throw new ServiceException();
			}

		} catch (ServiceException e) {

			goTo = "/ErrorPage.jsp";
		}
		return goTo;

	}
}
