package br.com.andrefilipe.calculadora.model;

import java.util.ArrayList;
import java.util.List;

public class Memory
{
	
	private String text = "";
	private String textBuffer = "";
	private boolean replace = false;
	private CommandType lastOperation = null;
	
	private final static Memory instance = new Memory();
	
	private final List<IMemoryObserver> observer = new ArrayList<>();
	
	private enum CommandType
	{
		RESET,
		NUMBER,
		DIV,
		MULT,
		LESS,
		PLUS,
		EQUALS,
		COMMA, 
		PLUSMINUS
	};
	
	public String getText() {
		return text.isEmpty() ? "0" : text;
	}

	public static Memory getInstance() {
		return instance;
	}
	
	public void addObserver(IMemoryObserver observer)
	{
		this.observer.add(observer);
	}
	
	public void processingCommand(String command)
	{
		CommandType commandType = detectCommandType(command);
		
		if(commandType == null)
		{
			return;
		}
		else if(commandType == CommandType.RESET)
		{
			text = "";
			textBuffer = "";
			replace = false;
			lastOperation = null;
		}
		else if(commandType == CommandType.NUMBER || commandType == CommandType.COMMA) 
		{
			text = replace ? command : text + command;
			replace = false;
		}
		else if(commandType == CommandType.PLUSMINUS && text.contains("-")) 
		{
			text = text.substring(1);
		}
		else if(commandType == CommandType.PLUSMINUS && !text.contains("-")) 
		{
			text = "-" + text;
		}
		else
		{
			replace = true;
			text = getOperationResult();
			textBuffer = text;
			lastOperation = commandType;
		}
		
		this.observer.forEach(observer -> observer.valueChanged(getText()));
	}
	
	private Memory()
	{
		//TODO
	}

	private String getOperationResult()
	{
		if(lastOperation == null || lastOperation == CommandType.EQUALS)
		{
			return text;
		}
		
		double numberBuffer = Double.parseDouble(textBuffer);
		double number = Double.parseDouble(text);
		double result = 0;
		
		if(lastOperation == CommandType.PLUS)
		{
			result = numberBuffer + number;
		}
		else if(lastOperation == CommandType.LESS)
		{
			result = numberBuffer - number;
		}
		else if(lastOperation == CommandType.MULT)
		{
			result = numberBuffer * number;
		}
		else if(lastOperation == CommandType.DIV)
		{
			result = numberBuffer / number;
		}
		else if(lastOperation == CommandType.PLUSMINUS)
		{
			text = "-" + text;
		}
		else
		{
			return null;
		}
		
		String convertedResult = Double.toString(result);
		
		boolean integer = convertedResult.endsWith(".0");
		
		return integer ? convertedResult.replace(".0", "") : convertedResult;
	}

	private CommandType detectCommandType(String command)
	{
		if(text.isEmpty() && command == "0")
		{
			return null;
		}
		
		try
		{
			Integer.parseInt(command);
			
			return CommandType.NUMBER;
		} 
		catch (NumberFormatException e)
		{
			if("AC".equals(command))
			{
				return CommandType.RESET;
			}
			else if("/".equals(command))
			{
				return CommandType.DIV;
			}
			else if("±".equals(command))
			{
				return CommandType.PLUSMINUS;
			}
			else if("*".equals(command))
			{
				return CommandType.MULT;
			}
			else if("+".equals(command))
			{
				return CommandType.PLUS;
			}
			else if("-".equals(command))
			{
				return CommandType.LESS;
			}
			else if("=".equals(command))
			{
				return CommandType.EQUALS;
			}
			else if(".".equals(command) && !text.contains("."))
			{
				return CommandType.COMMA;
			}
			else
			{
				return null;
			}
		}
	}
}
