package br.com.andrefilipe.calculadora.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.andrefilipe.calculadora.model.Memory;

@SuppressWarnings("serial")
public class Keyboard extends JPanel implements ActionListener
{
	private final Color COLOR_DARK_GRAY = new Color(68, 68, 68);
	private final Color COLOR_LIGHT_GRAY = new Color(99, 99, 99);
	private final Color COLOR_ORANGE = new Color(242, 163, 60);
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() instanceof JButton)
		{
			JButton button = (JButton) e.getSource();
			Memory.getInstance().processingCommand(button.getText());
		}
	}
	
	public Keyboard()
	{
		GridBagLayout layoutGridBag = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
		setLayout(layoutGridBag);
		
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		
		gridBagConstraints.gridwidth = 2;
		addButton("AC", COLOR_DARK_GRAY, gridBagConstraints, 0, 0);
		gridBagConstraints.gridwidth = 1;
		addButton("±", COLOR_DARK_GRAY, gridBagConstraints, 2, 0);
		//addButton("%", COLOR_DARK_GRAY, gridBagConstraints, 3, 0); TODO
		addButton("/", COLOR_DARK_GRAY, gridBagConstraints, 3, 0);
		
		addButton("7", COLOR_LIGHT_GRAY, gridBagConstraints, 0, 1);
		addButton("8", COLOR_LIGHT_GRAY, gridBagConstraints, 1, 1);
		addButton("9", COLOR_LIGHT_GRAY, gridBagConstraints, 2, 1);
		addButton("*", COLOR_ORANGE, gridBagConstraints, 3, 1);
		
		addButton("4", COLOR_LIGHT_GRAY, gridBagConstraints, 0, 2);
		addButton("5", COLOR_LIGHT_GRAY, gridBagConstraints, 1, 2);
		addButton("6", COLOR_LIGHT_GRAY, gridBagConstraints, 2, 2);
		addButton("-", COLOR_ORANGE, gridBagConstraints, 3, 2);
		
		addButton("1", COLOR_LIGHT_GRAY, gridBagConstraints, 0, 3);
		addButton("2", COLOR_LIGHT_GRAY, gridBagConstraints, 1, 3);
		addButton("3", COLOR_LIGHT_GRAY, gridBagConstraints, 2, 3);
		addButton("+", COLOR_ORANGE, gridBagConstraints, 3, 3);
		
		gridBagConstraints.gridwidth = 2;
		addButton("0", COLOR_LIGHT_GRAY, gridBagConstraints, 0, 4);
		gridBagConstraints.gridwidth = 1;
		addButton(".", COLOR_LIGHT_GRAY, gridBagConstraints, 2, 4);
		addButton("=", COLOR_ORANGE, gridBagConstraints, 3, 4);
		
	}
	
	private void addButton(String text, Color color, GridBagConstraints gridBagConstraints, int x, int y)
	{
		Button button = new Button(text, color);
		
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		
		button.addActionListener(this);
		
		add(button, gridBagConstraints);
	}
}
