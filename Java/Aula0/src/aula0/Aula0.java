/*
*
 */
package aula0;

/**
 *
 * @author Fernando
 * alt + shift + f (formatar codigo)
 */
public class Aula0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double primeiro = 10;
        double segundo = 9;
        double terceiro = 20;
        calcular(primeiro, segundo, terceiro);
    }

    public static void calcular(double numero1, double numero2, Double resultadoEsperado) {
        double resultado = numero1 + numero2;
        if(!resultadoEsperado.equals(resultado)){
            System.out.println("Deu Ruim");
        }
        else{
            System.out.println("Deu Certo");
        }
    }
}
