package funcoes;

import java.util.Arrays;

public class ArraysMatriz {

    public static void exibirMatriz() {
        Integer[][] matriz = {
                { 1, 2, 3 },

                { 40, 50, 60 },

                { 700, 800, 900 }
        };

        for (Integer[] array : matriz) {
            for (Integer valor : array) {
                System.out.println(String.format("Valor = %d", valor));
            }
        }

        Arrays.asList(matriz).forEach(
                array -> {
                    Arrays.asList(array).forEach(
                            valor -> {
                                System.out.println(String.format("valor: = %d", valor));
                            });
                });
    }
}
