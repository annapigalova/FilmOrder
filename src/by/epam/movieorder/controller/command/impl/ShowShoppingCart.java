package by.epam.movieorder.controller.command.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.movieorder.beans.Order;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.service.OrderService;
import by.epam.movieorder.service.UserService;
import by.epam.movieorder.service.exception.ServiceException;
import by.epam.movieorder.service.factory.ServiceFactory;

public class ShowShoppingCart implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String goTo = null;
		HttpSession session = ((HttpServletRequest) request).getSession();
		User user = (User) session.getAttribute("user");

		try {

			ServiceFactory serviceFactory = ServiceFactory.getInstance();

			OrderService orderService = serviceFactory.getOrderService();
			System.out.println(user);
			List<Order> orderList = new ArrayList<>();
			orderList = orderService.showOrder(user);
			request.setAttribute("orderList", orderList);

			for (int i = 0; i < orderList.size(); i++) {
				System.out.println(orderList.get(i));
			}

			if (orderList.size() != 0) {
				
				System.out.println("User has orders");
				goTo = "/ShoppingCart.jsp";

			} else {

				throw new ServiceException();

			}

		} catch (ServiceException e) {
			goTo = "/ShoppingCart.jsp";

		}

		return goTo;
	}

}
