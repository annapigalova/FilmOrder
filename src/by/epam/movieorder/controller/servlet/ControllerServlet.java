package by.epam.movieorder.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = null;
		Command command = null;
		String url = null;

		commandName = request.getParameter(COMMAND_NAME);
		command = provider.getCommand(commandName);
		System.out.println(commandName);

		try {
			
			url = command.execute(request, response);
			response.sendRedirect(request.getContextPath() + url);
		} catch (Exception e) {
		
		}
	}

}
