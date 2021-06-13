/*Escreva um programa para determinar a quantidade de cavalos necessários para se levantar uma massa de m quilogramas a 
uma altura de h metros em t segundos. Considere cavalos = (m * h / t) / 745,6999*/

O que esse algoritmo produzirá na etapa 6 se começarmos com a = 2437, b = 875*/
public class Exercicio7 {

    public static void main(String[] args) {
        double m = 21;
        double h = 2.2;
        double t = 1.4;
        double cavalos = (m * h / t) / 745.6999;

        System.out.println("A Quantidade de cavalos necessário é de: " + cavalos);

        return;
    }
}
