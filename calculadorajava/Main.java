package calculadorajava;

import java.util.Scanner;
import calculadorajava.Met�dos;

public class Main {

	public static void main(String[] args) {
		Met�dos resultado = new Met�dos();

		Scanner sc = new Scanner(System.in);
		double num1, num2, result = 0;
		int selecao;

		System.out.println("Digite o primeiro n�mero: ");
		num1 = sc.nextDouble();

		System.out.println("Digite o segundo n�mero: ");
		num2 = sc.nextDouble();

		System.out.println("#####Selecione uma opera��o#####");
		System.out.println("[1] - SOMA");
		System.out.println("[2] - SUBTRA��O");
		System.out.println("[3] - MULTIPLICA��O");
		System.out.println("[4] - DIVIS�O");
		System.out.print(">>>>>>>>>Digite sua op��o: ");
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
			System.out.println("Escolha apenas uma das op��es.");

		}

		System.out.println("O resultado da opera��o �: " + result);

		main(args);
	}
}
