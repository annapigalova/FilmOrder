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

	private final Map<CommandName, Command> repository = new HashMap<>();

	public CommandProvider() {
		repository.put(CommandName.LOGIN, new LogIn());
		repository.put(CommandName.REGISTER, new Register());
		repository.put(CommandName.ORDER_HISTORY, new ShowOrderHistory());
		repository.put(CommandName.SHOW_MOVIE_INFO, new ShowMovieInfo());
		repository.put(CommandName.SEARCH, new SearchFilm());
		repository.put(CommandName.ADD_TO_CART, new AddToCart());
		repository.put(CommandName.PAY_ORDER, new PayOrder());
		repository.put(CommandName.COMMENT,  new MakeComment());

	}

	public Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			//Change logic
			int indexOfDelimiter = name.length();
			if (name.contains("?")) {
				indexOfDelimiter = name.indexOf("?");

			}

			commandName = CommandName.valueOf(name.toUpperCase().replaceAll(" ", "_").replaceAll("-", "_").substring(0, indexOfDelimiter));
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			e.printStackTrace();

		}
		return command;
	}

}
