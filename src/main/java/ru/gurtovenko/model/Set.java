package ru.gurtovenko.model;

import java.util.ArrayList;
import java.util.List;

import ru.gurtovenko.model.Chess.Bishop;
import ru.gurtovenko.model.Chess.King;
import ru.gurtovenko.model.Chess.Knight;
import ru.gurtovenko.model.Chess.Pawn;
import ru.gurtovenko.model.Chess.Queen;
import ru.gurtovenko.model.Chess.Rook;

public class Set {
	private static int count = 0;
	public String name;
	private List<Pawn> pawns;
	private List<Rook> rooks;
	private List<Bishop> bishops;
	private List<Knight> knights;
	private Queen queen;
	private King king;

	public Set() {
		count++;
		name = "Set №" + count;
		this.pawns = new ArrayList<Pawn>();
		this.rooks = new ArrayList<Rook>();
		this.bishops = new ArrayList<Bishop>();
		this.knights = new ArrayList<Knight>();
	}

	public List<Pawn> getPawns() {
		return pawns;
	}

	public List<Rook> getRooks() {
		return rooks;
	}

	public List<Bishop> getBishops() {
		return bishops;
	}

	public List<Knight> getKnights() {
		return knights;
	}

	public Queen getQueen() {
		return queen;
	}

	public void setQueen(Queen queen) {
		this.queen = queen;
	}

	public King getKing() {
		return king;
	}

	public void setKing(King king) {
		this.king = king;
	}
	
	public String toString() {
		String s = name + " собран: " +
					"Pawns: " + pawns.size()+
					"; Rooks: " + rooks.size()+
					"; Knights: " + knights.size()+
					"; Bishops: " + bishops.size()+
					"; Queen: " + queen.getClass().getSimpleName()+
					"; King: " + king.getClass().getSimpleName();
		return s;
	}
	
}
