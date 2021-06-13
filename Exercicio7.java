/*Escreva um programa para determinar a quantidade de cavalos necessários para se levantar uma massa de m quilogramas a 
uma altura de h metros em t segundos. Considere cavalos = (m * h / t) / 745,6999*/

/*1. Insira dois inteiros: a, b.
2. Inicialize o valor de x para a e o valor de y para b.
3. Se x> y, defina x como x-y.
4. Se x <y, defina y como y-x.
5. Repita as etapas 3 e 4 até x = y.
6. Apresente a saída x (ou y) e pare.

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
