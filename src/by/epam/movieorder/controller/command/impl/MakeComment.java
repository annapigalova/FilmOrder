package by.epam.movieorder.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.service.CommentService;
import by.epam.movieorder.service.exception.ServiceException;
import by.epam.movieorder.service.factory.ServiceFactory;

public class MakeComment implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		String goTo = null;

		boolean isStatusOk = false;

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		String movieIdStr = request.getParameter("movieId");

		int movieId = Integer.parseInt(movieIdStr);

		String text = request.getParameter("CommentText");

		try {

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			CommentService commentService = serviceFactory.getCommentService();
			isStatusOk = commentService.addComment(text, user, movieId);

			if (isStatusOk) {
				goTo =  request.getRequestURL().append('?').append((request.getParameter("url"))).toString();

			} else {

				throw new ServiceException();
			}

		} catch (ServiceException e) {

			goTo = "/ErrorPage.jsp";
		}
		return goTo;

	}

}
