package by.epam.movieorder.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.controller.command.impl.LogIn;
import by.epam.movieorder.controller.command.impl.Register;
import by.epam.movieorder.controller.command.impl.ShowMovieInfo;
import by.epam.movieorder.controller.command.impl.ShowShoppingCart;

public final class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();

	public CommandProvider() {
		repository.put(CommandName.LOG_IN, new LogIn());
		repository.put(CommandName.REGISTER, new Register());
		repository.put(CommandName.SHOW_SHOPPING_CART, new ShowShoppingCart());
		repository.put(CommandName.SHOW_MOVIE_INFO, new ShowMovieInfo());

	}

	public Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			int indexOfDelimiter = name.length();
			if (name.contains("?")) {
				indexOfDelimiter = name.indexOf("?");

			}

			commandName = CommandName.valueOf(name.toUpperCase().replaceAll("-", "_").substring(0, indexOfDelimiter));
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			e.printStackTrace();

		}
		return command;
	}

}
