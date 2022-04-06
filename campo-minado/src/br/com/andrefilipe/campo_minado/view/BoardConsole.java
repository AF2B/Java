package br.com.andrefilipe.campo_minado.view;

	import java.util.Arrays;
	import java.util.Iterator;
	import java.util.Scanner;

import br.com.andrefilipe.campo_minado.exception.ExitException;
import br.com.andrefilipe.campo_minado.exception.ExplosionException;
import br.com.andrefilipe.campo_minado.model.Board;

	public class BoardConsole
	{

		private Board board;
		private Scanner input = new Scanner(System.in);
		
		public BoardConsole(Board board) {
			this.board = board;
			
			run();
		}

		private void run()
		{
			try
			{
				boolean continuous = true;
				
				while(continuous)
				{
					gameCycle();
					
					System.out.println("One more game? (Y/n) ");
					String aswer = input.nextLine();
					
					if("n".equalsIgnoreCase(aswer))
					{
						continuous = false;
					}
					else
					{
						board.restartGame();
					}
				}
			}
			catch(ExitException e)
			{
				System.out.println("Bye!!!");
				
			}
			finally
			{
				input.close();
			}
		}

		private void gameCycle() {
			try {
				
				while(!board.objectiveAchived())
				{
					System.out.println(board);
					
					String typed = valueTyped("Type (x, y): ");
					
					Iterator<Integer> xy = Arrays.stream(typed.split(","))
						.map(e -> Integer.parseInt(e.trim())).iterator();
					
					typed = valueTyped("1 - Open or 2 - Unmarked: ");
					
					if("1".equals(typed))
					{
						board.open(xy.next(), xy.next());
					}
					else if("2".equals(typed))
					{
						board.switchMarking(xy.next(), xy.next());
					}
				}
				
				System.out.println(board);
				System.out.println("You win!!!");
			} catch(ExplosionException e) {
				System.out.println(board);
				System.out.println("You lose!!!");
			}
		}
		
		private String valueTyped(String text) {
			System.out.print(text);
			String typed = input.nextLine();
			
			if("exit".equalsIgnoreCase(typed)) {
				throw new ExitException();
			}
			
			return typed;
		}
	}
