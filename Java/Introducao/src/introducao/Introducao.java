package introducao;

import funcoes.Calculadora;
import java.util.Scanner;

/**
 *
 * @author Rafael Vieira
 * @version 1.0
 * @implSpec Este programa é um exemplo de uso da classe Calculadora.
 * 
 * @author Fernando Terceros
 * @version 2.0
 * @implSpec Classe Calculadora foi refatorada e implementado testes Unitarios.
 * 
 */
public class Introducao {
    private static final String[] LISTA_OPERACOES = { "+", "-", "x", "/" };

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Integer operacao = null;
        while (true) {
            System.out.println("\n"
                    + "[1] SOMA\n"
                    + "[2] SUBTRAÇÃO\n"
                    + "[3] MULTIPLICAÇÃO\n"
                    + "[4] DIVISÃO\n"
                    + "[5] Mostrar Operacoes Realizadas\n"
                    + "[6] Limpar Operacoes Realizadas\n"
                    + "[0] Para Sair\n"
                    + "Digite a operação desejada:");
            try {
                operacao = teclado.nextInt();
                if (operacao.equals(Calculadora.SAIR)) {
                    System.out.println("Saindo...");
                    break;
                } else if (operacao >= Calculadora.SOMA && operacao <= Calculadora.DIV) {
                    System.out.println("Digite o primeiro numero: ");
                    Double numeroX = teclado.nextDouble();
                    System.out.println("Digite o segundo numero: ");
                    Double numeroY = teclado.nextDouble();
                    if (operacao.equals(Calculadora.DIV) && numeroY.equals(0.0)) {
                        throw new RuntimeException("Não é possível dividir por zero!");
                    }

                    Double resultado = Calculadora.calcular(numeroX, numeroY, operacao);
                    System.out.println("O resultado e: " + resultado);
                    Calculadora.adicionarRegistroOperacao(
                            numeroX + " " + LISTA_OPERACOES[operacao - 1] + " " + numeroY + " = " + resultado);

                } else if (operacao.equals(Calculadora.MOSTRAR)) {
                    Calculadora.exibirRegistros();
                } else if (operacao.equals(Calculadora.LIMPAR)) {
                    Calculadora.limparRegistros();
                } else {
                    throw new RuntimeException("Operação inválida!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Digite um valor válido");
            }
        }
        teclado.close();
    }
    /*
     * // Repeticao.funcaoFor(5);
     * // ArraysMatriz.exibirMatriz();
     * NetBeans
     * ctrl / => comentar linha
     * ctrl e => apaga linha
     * ctrl shift seta acima abaixo => duplicar linha
     * Shift alt seta acima abaixo => move a linha
     */
}
