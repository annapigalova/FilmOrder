package by.epam.movieorder.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.service.UserService;
import by.epam.movieorder.service.exception.ServiceException;
import by.epam.movieorder.service.factory.ServiceFactory;

public class LogIn implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String goTo = null;
		HttpSession session = request.getSession();

		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userService = serviceFactory.getUserService();

			User user = userService.logIn(login, password);

			if (user != null) {
				
				session.setAttribute("user", user);
				goTo = "/mainPage.jsp";
			} else {
				
				throw new ServiceException();

			}

		} catch (ServiceException e) {
			goTo = "/login.jsp";

		}
		return goTo;

	}

}
