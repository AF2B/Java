package CalculadoraJavaSimples;

import java.util.Scanner;
import CalculadoraJavaSimples.Metódos;

public class Main {

	public static void main(String[] args) {
		Metódos resultado = new Metódos();

		Scanner sc = new Scanner(System.in);
		double num1, num2, result = 0;
		int selecao;

		System.out.println("Digite o primeiro número: ");
		num1 = sc.nextDouble();

		System.out.println("Digite o segundo número: ");
		num2 = sc.nextDouble();

		System.out.println("#####Selecione uma operação#####");
		System.out.println("[1] - SOMA");
		System.out.println("[2] - SUBTRAÇÃO");
		System.out.println("[3] - MULTIPLICAÇÃO");
		System.out.println("[4] - DIVISÃO");
		System.out.print(">>>>>>>>>Digite sua opção: ");
		selecao = sc.nextInt();

		switch (selecao) {
		case (1):
			result = resultado.soma(num1, num2);
			break;

		case (2):
			result = resultado.subtracao(num1, num2);
			break;

		case (3):
			result = resultado.multiplicacao(num1, num2);
			break;

		case (4):
			result = resultado.divisao(num1, num2);
			break;

		default:
			System.out.println("Escolha apenas uma das opções.");

		}

		System.out.println("O resultado da operação é: " + result);

		main(args);
		
		sc.close();
	}
}
