
/*3. Criar um programa que calcule a média de salários de uma empresa, pedindo ao usuário a grade de
 funcionários e os salários, e devolvendo a média salarial.*/
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double médiaGeralDaEmpresa;
        double almoxarifado;
        System.out.println("Média salárial do setor almoxarifado: ");
        almoxarifado = entrada.nextDouble();
        double administração;
        System.out.println("Média salárial do setor administração: ");
        administração = entrada.nextDouble();
        double recursosHumanos;
        System.out.println("Média salárial do setor recursosHumanos: ");
        recursosHumanos = entrada.nextDouble();
        double coordenador;
        System.out.println("Média salárial do setor coordenador: ");
        coordenador = entrada.nextDouble();
        double diretor;
        System.out.println("Média salárial do setor diretor: ");
        diretor = entrada.nextDouble();

        médiaGeralDaEmpresa = (almoxarifado + administração + recursosHumanos + coordenador + diretor) / 5;

        System.out.println("A média geral de salários da empresa é de: " + médiaGeralDaEmpresa);

        entrada.close();
    }
}
