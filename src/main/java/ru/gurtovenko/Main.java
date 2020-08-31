package ru.gurtovenko;

import ru.gurtovenko.model.RoboFactoryChessImpl;
import ru.gurtovenko.model.Set;
import ru.gurtovenko.model.Chess.Chess;
import ru.gurtovenko.model.Chess.Pawn;

public class Main {
	static RoboFactoryChessImpl robo = new RoboFactoryChessImpl();

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		while(robo.getSizeHeap() != 0) {
			if(robo.getCountSets() >= 5) {				
				robo.launch(1);
			}
			else {
				robo.launch(2);
			}
		}
		System.out.println("Done!");
	}

}
