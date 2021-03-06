package by.epam.movieorder.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.movieorder.controller.CommandProvider;
import by.epam.movieorder.controller.command.Command;

//@WebServlet("/ControllerServlet")

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String COMMAND_NAME = "command";
	private final CommandProvider provider = new CommandProvider();

	public ControllerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = null;
		Command command = null;
		String url = null;

		commandName = request.getParameter(COMMAND_NAME);

		command = provider.getCommand(commandName);

		try {
			url = command.execute(request);

			RequestDispatcher dispatcher;
			if (commandName.equals("Add to Cart"))

			{
				dispatcher = request.getRequestDispatcher(url);
			} else {

				dispatcher = getServletContext().getRequestDispatcher(url);
			}

			if (dispatcher != null) {

				dispatcher.forward(request, response);

			}
		} catch (Exception e) {

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String commandName = null;
		Command command = null;
		String url = null;

		commandName = request.getParameter(COMMAND_NAME);
		command = provider.getCommand(commandName);
		try {

			url = command.execute(request);

			if (commandName.equals("Comment")) {
				response.sendRedirect(url);
			} else {
				response.sendRedirect(request.getContextPath() + url);
			}
		} catch (Exception e) {

		}
	}

}
