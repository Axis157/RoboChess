package ru.gurtovenko.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ru.gurtovenko.model.Chess.Bishop;
import ru.gurtovenko.model.Chess.Chess;
import ru.gurtovenko.model.Chess.Heap;
import ru.gurtovenko.model.Chess.King;
import ru.gurtovenko.model.Chess.Knight;
import ru.gurtovenko.model.Chess.Pawn;
import ru.gurtovenko.model.Chess.Queen;
import ru.gurtovenko.model.Chess.Rook;

public class RoboFactoryChessImpl extends Thread implements RoboFactoryChess{
	
//	private static Map<Integer, Set> sets = new HashMap<>();
	private static List<Set> sets = new ArrayList<>();
	private static Heap heap = new Heap();
	
	public RoboFactoryChessImpl() {
		for(int i = 0; i < 10; i++) {
			Set set = new Set();
//			sets.put(i, set);
			sets.add(set);
		}
	}
	
	public int getSizeHeap() {
		return heap.getChessList().size();
	}
	public int getCountSets() {
		return sets.size();
	}
	
	@Override
	public void launch(int step) throws InstantiationException, IllegalAccessException {
		Chess chess = getChess();
//		chessAdded(chess, sets.size());
		if(step == 1) {
			chessAdded(chess, 5);
		}
		else if(step == 2) {
			chessAdded(chess, sets.size());
		}
	}
	

	private boolean chessAdded(Chess chess, int max) throws IllegalAccessException {
		for(int i = 0; i < max; i++) {
			Set set = sets.get(i);
			if (chess instanceof Pawn && set.getPawns().size() < 8) {
				set.getPawns().add((Pawn) chess);
				isDoneSet(set);
				return true;
			} else if (chess instanceof Rook && set.getRooks().size() < 2) {
				set.getRooks().add((Rook) chess);
				isDoneSet(set);
				return true;
			} else if (chess instanceof Knight && set.getKnights().size() < 2) {
				set.getKnights().add((Knight) chess);
				isDoneSet(set);
				return true;
			} else if (chess instanceof Bishop && set.getBishops().size() < 2) {
				set.getBishops().add((Bishop) chess);
				isDoneSet(set);
				return true;
			} else if (chess instanceof Queen && set.getQueen() == null) {
				set.setQueen((Queen) chess);
				isDoneSet(set);
				return true;
			} else if (chess instanceof King && set.getKing() == null) {
				set.setKing((King) chess);
				isDoneSet(set);
				return true;
			}
		}
		returnChess(chess);
		return false;
	}


	private Chess getChess() throws InstantiationException, IllegalAccessException {
		Random random = new Random();
		int index = random.nextInt(heap.getChessList().size());
		Chess chess = heap.getChessList().get(index).getClass().newInstance();
		heap.getChessList().remove(index);
		return chess;
	}


	private void returnChess(Chess chess) {
		heap.getChessList().add(chess);
		System.out.println("Фигура возвращена!");
	}


	private boolean isDoneSet(Set set) throws IllegalAccessException {
		if(set.getBishops().size() == 2 &&
				set.getKnights().size() == 2 &&
				set.getRooks().size() == 2 &&
				set.getPawns().size() == 8 &&
				set.getKing() != null &&
				set.getQueen() != null) {
			sendSet(set);
			return true;
		}
		else if(set.getBishops().size() > 2 ||
				set.getKnights().size() > 2 ||
				set.getRooks().size() > 2 ||
				set.getPawns().size() > 8) {
			throw new IllegalAccessException("Фигур в наборе больше чем надо!");
		}
		return false;
	}


	private void sendSet(Set set) {
		System.out.println(set);
		sets.remove(set);
	}

	@Override
	public void run() {
		
	}
	
}
