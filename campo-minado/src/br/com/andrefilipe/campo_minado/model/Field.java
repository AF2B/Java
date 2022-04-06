package br.com.andrefilipe.campo_minado.model;

import java.util.ArrayList;
import java.util.List;

import br.com.andrefilipe.campo_minado.exception.ExplosionException;

public class Field
{
	private final int line;
	private final int column;
	
	private boolean isOpen = false;
	private boolean isMined = false;
	private boolean isTagged = false;
	
	protected List<Field> neighbors = new ArrayList<Field>();
	
	public Field(int lines, int columns)
	{
		this.line = lines;
		this.column = columns;
	}
	
	public boolean addNeighbors(Field neighbors)
	{
		boolean lineDifferent = line != neighbors.line;
		boolean columnDifferent = line != neighbors.line;
		boolean diagonaly = lineDifferent && columnDifferent;
		
		int deltaLine = Math.abs(line - neighbors.line);
		int deltaColumn = Math.abs(column - neighbors.column);
		int deltaGeneral = deltaColumn + deltaLine;
		
		if(deltaGeneral == 1 && !diagonaly)
		{
			neighbors.addNeighbors(neighbors); //Review with more calm
			return true;
		}
		else if(deltaGeneral == 2 && diagonaly)
		{
			neighbors.addNeighbors(neighbors);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void switchMarking()
	{
		if(!isOpen)
		{
			isTagged = !isTagged;
		}
	}
	
	public boolean openNeighbors()
	{
		if(isOpen == false && isTagged == false)
		{
			isOpen = true;
			
			if(isMined == true)
			{
				throw new ExplosionException();
			}
			
			if(secureNeighbors())
			{
				neighbors.forEach(neighbor -> neighbor.openNeighbors());
			}
			
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public boolean secureNeighbors()
	{
		return neighbors.stream().noneMatch(neighbor -> neighbor.isMined); //Review and change that.
	}
	
	public boolean isMarked()
	{
		return isTagged;
	}
	
	public boolean mining()
	{
		if(isMined == false)
		{
			isMined = true;
		}
		
		return false;
	}
	
	public boolean isMined()
	{
		return isMined;
	}
	
	public boolean isOpen()
	{
		return isOpen;
	}
	
	public boolean isClose()
	{
		return !isOpen;
	}

	public int getLine()
	{
		return line;
	}

	public int getColumn()
	{
		return column;
	}
	
	public boolean objectiveAchieved()
	{
		boolean unveiled;
		boolean protect;
		
		unveiled = isMined == false && isOpen == true;
		protect = isMined == true && isOpen == false && isTagged == true;
		
		if(unveiled == true || protect == true)
		{
			return true;
		}
		else
		{
			return false;	
		}
	}
	
	public long minesInTheNeighborhood()
	{
		return neighbors.stream().filter(neighbor -> neighbor.isMined).count();//change all that.
	}
	
	public void restart()
	{
		isOpen = false;
		isTagged = false;
		isMined = false;
	}
	
	public String toString()
	{
		if(isTagged == true)
		{
			return "x";
		}
		else if(isOpen == true && isMined == true)
		{
			return "*";
		}
		else if(isOpen == true && minesInTheNeighborhood() > 0)
		{
			return Long.toString(minesInTheNeighborhood());
		}
		else if(isOpen == true)
		{
			return " ";
		}
		else
		{
			return "?";
		}
	}

	public Object setOpen(boolean b)
	{
		return null;
	}
}