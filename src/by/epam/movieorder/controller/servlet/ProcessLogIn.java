package by.epam.movieorder.controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.movieorder.beans.User;

import by.epam.movieorder.service.UserService;
import by.epam.movieorder.service.factory.ServiceFactory;


public class ProcessLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcessLogIn() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		try {
			if (login != null && password != null) {
				UserService userService = ServiceFactory.getInstance().getUserService();

				User user = userService.logIn(login, password);

				if (user != null) {
					

					response.sendRedirect("/main.jsp");
					return;
				}
			}
			response.sendRedirect("/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
