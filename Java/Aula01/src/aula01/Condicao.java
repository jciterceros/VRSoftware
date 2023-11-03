package aula01;

/**
 *
 * @author Fernando
 */
public class Condicao {

    public static void funcaoIf(boolean resultadoCondicao) {
        int valorA = 10;
        int valorB = 20;
        int valorC = 15;
        if ((valorA < valorB) && (valorB < valorC) || (valorA > valorC)) {
            System.out.println("Codicao 1!");
        } else if (valorA > valorB) {
            System.out.println("Condicao 2!");
        } else {
            System.out.println("Condicao 3!");
        }
    }

    public static void fucaoSwitch(Integer numeroCondicional) {
        switch (numeroCondicional) {
            case Integer.MIN_VALUE:
                System.out.println(String.format("Minimo de um numero %d!", numeroCondicional));
                break;
            case Integer.MAX_VALUE:
                System.out.println(String.format("Maximo de um numero %d!", numeroCondicional));
                break;
            default:
                System.out.println(String.format("Valor do parametro %d!", numeroCondicional));
                break;
        }
    }

    public static void imprimeTela(String message) {
        System.out.println(message);
    }
}
