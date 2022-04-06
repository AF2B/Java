package br.com.andrefilipe.calculadora.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculator extends JFrame
{
	
	public static void main(String[] args)
	{
		new Calculator();
	}
	
	public Calculator()
	{
		organizeLayout();
		
		setSize(232, 322);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	private void organizeLayout()
	{
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		Display display = new Display();
		Keyboard keyboard = new Keyboard();
		
		add(display, BorderLayout.NORTH);
		add(keyboard, BorderLayout.CENTER);
		
		display.setPreferredSize(new Dimension(233, 60));
	}
}
