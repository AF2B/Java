package br.com.andrefilipe.calculadora.model;

@FunctionalInterface
public interface IMemoryObserver
{
	public void valueChanged(String newValue);
}
