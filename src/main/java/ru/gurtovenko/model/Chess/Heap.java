package ru.gurtovenko.model.Chess;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	private List<Chess> chessList;
	
	public Heap() {
		chessList = new ArrayList<Chess>();
		//Pawn
		for(int i = 0; i < (8*10); i++) {
			chessList.add(new Pawn());
		}
		//Rook
		for(int i = 0; i < (2*10); i++) {
			chessList.add(new Rook());
		}
		//Knight
		for(int i = 0; i < (2*10); i++) {
			chessList.add(new Knight());
		}
		//Bishop
		for(int i = 0; i < (2*10); i++) {
			chessList.add(new Bishop());
		}
		//Queen
		for (int i = 0; i < (10); i++) {
			chessList.add(new Queen());
		}
		//King
		for (int i = 0; i < (10); i++) {
			chessList.add(new King());
		}
	}
	
	public List<Chess> getChessList(){
		return chessList;
	}
}
