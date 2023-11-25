package funcoes;

import java.util.ArrayList;

public class Calculadora {

    public static final int SAIR = 0;
    public static final int SOMA = 1;
    public static final int SUBTRACAO = 2;
    public static final int MULT = 3;
    public static final int DIV = 4;
    public static final int MOSTRAR = 5;
    public static final int LIMPAR = 6;

    public static ArrayList<String> Registro = new ArrayList<String>();

    /**
     * Realiza o cálculo matemático com base nos parâmetros fornecidos.
     *
     * Este método aceita dois números (n1 e n2) e efetua a operação
     * operação matemática correspondente. Os códigos de operação são definidos
     * como constantes da classe. As operações suportadas são: soma, subtração,
     * multiplicação e divisão.
     *
     * @param n1       O primeiro número a ser utilizado no cálculo.
     * @param n2       O segundo número a ser utilizado no cálculo.
     * @param operacao O código de operação que representa a operação desejada.
     *                 Utilize as constantes SOMA, SUBTRACAO, MULT e DIV.
     * @return O resultado da operação matemática realizada.
     * @throws RuntimeException Se o código de operação fornecido não for válido.
     */
    public static Double calcular(Double n1, Double n2, Integer operacao) {
        Double resultado = null;

        // Switch responsavel pela escolha de operação.
        switch (operacao) {
            case SOMA:
                resultado = n1 + n2;
                break;
            case SUBTRACAO:
                resultado = n1 - n2;
                break;
            case MULT:
                resultado = n1 * n2;
                break;
            case DIV:
                resultado = n1 / n2;
                break;
            default:
                throw new RuntimeException("Operacão invalida!");
        }
        return resultado;
    }

    /**
     * Registra uma operação realizada.
     *
     * Este método recebe uma String representando uma operação e a adiciona a uma
     * lista
     * de registros para manter um histórico das operações efetuadas.
     *
     * @param operacao A operação a ser registrada.
     * @return Nenhum valor não retornado.
     */
    public static void adicionarRegistroOperacao(String operacao) {
        Registro.add(operacao);
    }

    /**
     * Exibe os registros armazenados.
     *
     * Este método verifica se o registro não está vazio antes de exibir seus
     * elementos.
     * Se o registro estiver vazio, a função não realiza nenhuma ação.
     * 
     * @param Nenhum parametro recebido.
     * @return Nenhum valor não retornado.
     */
    public static void exibirRegistros() {
        if (!Registro.isEmpty()) {
            for (int i = 0; i < Registro.size(); i++) {
                System.out.println(Registro.get(i).toString());
            }
        }
    }

    /**
     * Limpa todos os registros armazenados.
     *
     * Este método remove todas as operações presentes no registro, deixando-o
     * vazio.
     * Não há retorno de valor.
     * 
     * @param Nenhum parametro recebido.
     * @return Nenhum valor não retornado.
     */
    public static void limparRegistros() {
        Registro.clear();
    }
}
