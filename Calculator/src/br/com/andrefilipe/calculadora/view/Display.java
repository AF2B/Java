package br.com.andrefilipe.calculadora.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.andrefilipe.calculadora.model.IMemoryObserver;
import br.com.andrefilipe.calculadora.model.Memory;

@SuppressWarnings("serial")
public class Display extends JPanel implements IMemoryObserver
{
	
	private final JLabel label = new JLabel(Memory.getInstance().getText());
	
	public Display()
	{
		Memory.getInstance().addObserver(this);
		
		add(label);
		
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		setBackground(new Color(46, 49, 50));
	}

	@Override
	public void valueChanged(String newValue)
	{
		label.setText(newValue);
	}
}
