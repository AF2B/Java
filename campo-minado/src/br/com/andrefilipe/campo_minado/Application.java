package br.com.andrefilipe.campo_minado;

import br.com.andrefilipe.campo_minado.model.Board;

public class Application
{
	public static void main(String[] args)
	{
		Board board = new Board(6, 6, 6);
		
		board.open(3, 3);
		board.switchMarking(4, 4);
		board.switchMarking(4, 5);
		
		System.out.println(board);
	}
}
