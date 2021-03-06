package by.epam.movieorder.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.service.UserService;
import by.epam.movieorder.service.exception.ServiceException;
import by.epam.movieorder.service.factory.ServiceFactory;

public class Register implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		String login = request.getParameter("login");
	
		String password = request.getParameter("password");
	
		String firstName = request.getParameter("firstName");
		
		String lastName = request.getParameter("lastName");
		
		String email = request.getParameter("email");
		
		String phoneNum = request.getParameter("phoneNum");
		
		HttpSession session = request.getSession();
		
		String goTo = null;

		try {

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userService = serviceFactory.getUserService();

			User user = new User();

			user.setLogin(login);

			user.setPassword(password);

			user.setFirstName(firstName);

			user.setLastName(lastName);

			user.setEmail(email);

			user.setPhoneNum(phoneNum);
			
			user = userService.resistration(user);
			
			if (user != null) {

				session.setAttribute("user", user);
			 
				goTo = "/MainPage.jsp";
			} else {

				throw new ServiceException();
			}

		} catch (ServiceException e) {

			goTo = "/Register.jsp";
		}
		return goTo;

	}
}