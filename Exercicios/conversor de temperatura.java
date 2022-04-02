
public class Exercicio1 {
    
    public static void main (String [] args){
        double C, K, F, Re, Ra;
        C = 37.0;
    
        F = C * 1.8 + 32;
        K = C +273.15;
        Re = C * 0.8;
        Ra = C * 1.8 + 32 + 459.67;

        System.out.println("O valor de celsius para F é " + F);
        System.out.println("O valor de celsius para K é " + K);
        System.out.println("O valor de celsius para Re é " + Re);
        System.out.println("O valor de celsius para Ra é " + Ra);
        
        if (C >= 38) 
        {
         System.out.println("Procure um médico!");   
        }
        

        return;
    }


    
}
