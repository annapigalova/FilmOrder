package by.epam.movieorder.controller;

import java.util.HashMap;
import java.util.Map;

 
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.controller.command.impl.AddToCart;
import by.epam.movieorder.controller.command.impl.MakeComment;
import by.epam.movieorder.controller.command.impl.LogIn;
import by.epam.movieorder.controller.command.impl.PayOrder;
import by.epam.movieorder.controller.command.impl.Register;
import by.epam.movieorder.controller.command.impl.SearchFilm;
import by.epam.movieorder.controller.command.impl.ShowMovieInfo;
import by.epam.movieorder.controller.command.impl.ShowOrderHistory;

public final class CommandProvider {
    private static final String LOGIN            = "Login";
    private static final String REGISTER         = "Register";
 //   private static final String SHOPPING_CART    = "Shopping Cart";
    private static final String SHOW_MOVIE_INFO  = "Show Movie Info";
    private static final String SEARCH           = "Search";
    private static final String ADD_TO_CART      = "Add to Cart";
    private static final String ORDER_HISTORY    = "Order History";
    private static final String PAY_ORDER        = "Pay Order";
    private static final String COMMENT          = "Comment";
    private static final String SHOW_MOVIE_INFO_LNK = "show-movie-info";
	private final Map<String, Command> repository = new HashMap<>();
	public CommandProvider() {
		repository.put(LOGIN, new LogIn());
		repository.put(REGISTER, new Register());
		repository.put(ORDER_HISTORY, new ShowOrderHistory());
		repository.put(SHOW_MOVIE_INFO, new ShowMovieInfo());
		repository.put(SEARCH, new SearchFilm());
		repository.put(ADD_TO_CART, new AddToCart());
		repository.put(PAY_ORDER, new PayOrder());
		repository.put(COMMENT,  new MakeComment());
		repository.put(SHOW_MOVIE_INFO_LNK, new ShowMovieInfo());

	}
/*	public CommandProvider() {
		repository.put(CommandName.LOGIN, new LogIn());
		repository.put(CommandName.REGISTER, new Register());
		repository.put(CommandName.ORDER_HISTORY, new ShowOrderHistory());
		repository.put(CommandName.SHOW_MOVIE_INFO, new ShowMovieInfo());
		repository.put(CommandName.SEARCH, new SearchFilm());
		repository.put(CommandName.ADD_TO_CART, new AddToCart());
		repository.put(CommandName.PAY_ORDER, new PayOrder());
		repository.put(CommandName.COMMENT,  new MakeComment());

	}*/

	public Command getCommand(String name) {
		String commandName = null;
		Command command = null;

		try {
			//Change logic
			int indexOfDelimiter = name.length();
			if (name.contains("?")) {
				indexOfDelimiter = name.indexOf("?");

			}

	//		commandName =  name.toUpperCase().replaceAll(" ", "_").replaceAll("-", "_").;
			commandName = name.substring(0, indexOfDelimiter);
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			e.printStackTrace();

		}
		return command;
	}

}
