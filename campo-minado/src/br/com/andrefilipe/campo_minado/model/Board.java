package br.com.andrefilipe.campo_minado.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.andrefilipe.campo_minado.exception.ExplosionException;

public class Board
{
		private int lines;
		private int columns;
		private int mines;
		
		private final List<Field> fields = new ArrayList<>();

		public Board(int lines, int columns, int mines)
		{
			this.lines = lines;
			this.columns = columns;
			this.mines = mines;
			
			generateFields();
			associateNeighbors();
			sortTheMines();
		}
		
		public void open(int lines, int columns)
		{
			try
			{
				fields.parallelStream()
					.filter(column -> column.getLine() == lines && column.getColumn() == columns)
					.findFirst()
					.ifPresent(column -> column.openNeighbors());	
			}
			catch(ExplosionException e)
			{
				fields.forEach(column -> column.setOpen(true));
				throw e;
			}
		}
		
		public void switchMarking(int lines, int columns) {
			fields.parallelStream()
				.filter(column -> column.getLine() == lines && column.getColumn() == columns)
				.findFirst()
				.ifPresent(column -> column.switchMarking());
		}
		
		public boolean objectiveAchived()
		{
			return fields.stream().allMatch(fields -> fields.objectiveAchieved());
		}
		
		public void restartGame()
		{
			fields.stream().forEach(field -> field.restart());
			
			sortTheMines();
		}
		
		public String toString()
		{
			StringBuilder stringBuilder = new StringBuilder();
			
			int indice = 0;
			
			for(int l = 0; l < lines; l++ )
			{
				for(int c = 0; c < columns; c++)
				{
					stringBuilder.append(" ");
					stringBuilder.append(fields.get(indice));
					stringBuilder.append(" ");
					indice++;
				}
				stringBuilder.append("\n");
			}
			
			return stringBuilder.toString();
		}

		private void generateFields()
		{
			for(int l = 0; l < lines; l++)
			{
				for(int c = 0; c < columns; c++)
				{
					fields.add(new Field(l, c));
				}
			}
		}
		
		private void associateNeighbors()
		{
			for(Field c1: fields)
			{
				for(Field c2: fields)
				{
					c1.addNeighbors(c2);
				}
			}
		}
		
		private void sortTheMines()
		{
			long armedMines = 0;
			int random = (int) (Math.random() * fields.size());
			
			Predicate<Field> mined = field -> field.isMined();
			
			do
			{
				armedMines = fields.stream().filter(mined).count();
				fields.get(random).mining();
			}while(armedMines < mines);
		}
}
