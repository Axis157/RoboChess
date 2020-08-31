package ru.gurtovenko.model;

import ru.gurtovenko.model.Chess.Chess;

public interface RoboFactoryChess {
	
	void launch(int step) throws InstantiationException, IllegalAccessException;

}
