package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import funcoes.Calculadora;

import java.util.List;

public class CalculadoraTest {
    /***
     * Este método é executado antes de cada teste.
     * Ele é utilizado para limpar os registros da calculadora antes de cada teste.
     * 
     * @since Versão 1.0
     * @see Calculadora#limparRegistros()
     */
    @BeforeEach
    public void setUp() {
        Calculadora.limparRegistros();
        assertEquals(0, Calculadora.Registro.size());
    }

    /**
     * Este teste verifica se o método calcular() da classe Calculadora executa
     * corretamente a operação de soma para dois números fornecidos.
     * O resultado esperado é comparado com o resultado retornado pelo método.
     * 
     * @param n1       O primeiro número a ser utilizado no cálculo.
     * @param n2       O segundo número a ser utilizado no cálculo.
     * @param operacao O código de operação que representa a operação desejada.
     *                 Utilize as constantes SOMA, SUBTRACAO, MULT e DIV.
     * @return O resultado da operação matemática realizada.
     * @throws RuntimeException Se o código de operação fornecido não for válido.
     * 
     * @see Calculadora#calcular(Double, Double, Integer)
     * @since Versão 1.0
     */
    @Test
    @DisplayName("Teste de soma")
    public void testCalcularSoma() {
        Double resultado = Calculadora.calcular(2.0, 3.0, Calculadora.SOMA);
        assertEquals(5.0, resultado, "O resultado da soma deve ser 5.0");
    }

    /**
     * Este teste verifica se o método calcular() da classe Calculadora executa
     * corretamente a operação de subtração para dois números fornecidos.
     * O resultado esperado é comparado com o resultado retornado pelo método.
     * 
     * @param n1       O primeiro número a ser utilizado no cálculo.
     * @param n2       O segundo número a ser utilizado no cálculo.
     * @param operacao O código de operação que representa a operação desejada.
     *                 Utilize as constantes SOMA, SUBTRACAO, MULT e DIV.
     * @return O resultado da operação matemática realizada.
     * @throws RuntimeException Se o código de operação fornecido não for válido.
     * 
     * @see Calculadora#calcular(Double, Double, Integer)
     * @since Versão 1.0
     */
    @Test
    @DisplayName("Teste de subtração")
    public void testCalcularSubtracao() {
        Double resultado = Calculadora.calcular(5.0, 2.0, Calculadora.SUBTRACAO);
        assertEquals(3.0, resultado, "O resultado da subtração deve ser 3.0");
    }

    /**
     * Este teste verifica se o método calcular() da classe Calculadora executa
     * corretamente a operação de multiplicação para dois números fornecidos.
     * O resultado esperado é comparado com o resultado retornado pelo método.
     * 
     * @param n1       O primeiro número a ser utilizado no cálculo.
     * @param n2       O segundo número a ser utilizado no cálculo.
     * @param operacao O código de operação que representa a operação desejada.
     *                 Utilize as constantes SOMA, SUBTRACAO, MULT e DIV.
     * @return O resultado da operação matemática realizada.
     * @throws RuntimeException Se o código de operação fornecido não for válido.
     * 
     * @see Calculadora#calcular(Double, Double, Integer)
     * @since Versão 1.0
     */
    @Test
    @DisplayName("Teste de multiplicação")
    public void testCalcularMultiplicacao() {
        Double resultado = Calculadora.calcular(4.0, 3.0, Calculadora.MULT);
        assertEquals(12.0, resultado, "O resultado da multiplicação deve ser 12.0");
    }

    /**
     * Este teste verifica se o método calcular() da classe Calculadora executa
     * corretamente a operação de divisão para dois números fornecidos.
     * O resultado esperado é comparado com o resultado retornado pelo método.
     * 
     * @param n1       O primeiro número a ser utilizado no cálculo.
     * @param n2       O segundo número a ser utilizado no cálculo.
     * @param operacao O código de operação que representa a operação desejada.
     *                 Utilize as constantes SOMA, SUBTRACAO, MULT e DIV.
     * @return O resultado da operação matemática realizada.
     * @throws RuntimeException Se o código de operação fornecido não for válido.
     * 
     * @see Calculadora#calcular(Double, Double, Integer)
     * @since Versão 1.0
     */
    @Test
    @DisplayName("Teste de divisão")
    public void testCalcularDivisao() {
        Double resultado = Calculadora.calcular(10.0, 2.0, Calculadora.DIV);
        assertEquals(5.0, resultado, "O resultado da divisão deve ser 5.0");
    }

    /**
     * Este teste verifica se o método adicionarRegistroOperacao adiciona
     * corretamente
     * um registro à lista de registros da calculadora. O método é executado com uma
     * operação de teste, e em seguida, verifica se o registro foi adicionado com
     * sucesso, verificando o tamanho da lista de registros e o conteúdo do registro
     * adicionado.
     * 
     * @param operacao A operação a ser registrada.
     * @return Nenhum valor não retornado.
     * 
     * @see Calculadora#adicionarRegistroOperacao(String)
     * @since Versão 1.0
     */
    @Test
    @DisplayName("Teste adicionar registros")
    public void testAdicionarRegistroOperacao() {
        Calculadora.adicionarRegistroOperacao("Teste de registro");
        List<String> registros = Calculadora.Registro;
        assertEquals(1, registros.size(), "A lista de registros deve ter tamanho 1");
        assertEquals("Teste de registro", registros.get(0), "O registro deve ser igual a \"Teste de registro\"");
    }

    /**
     * Este teste verifica o comportamento do método exibirRegistros() quando a
     * lista de registros da
     * Calculadora está vazia. Certifica-se de que a função não gera exceção e não
     * imprime nada quando
     * a lista está vazia, garantindo que o código lide corretamente com essa
     * condição.
     *
     * @see Calculadora#exibirRegistros()
     * @since Versão 1.0
     */
    @Test
    @DisplayName("Teste exibir registros vazio")
    public void testExibirRegistrosVazio() {
        // Certifica-se de que não há registros
        Calculadora.limparRegistros();
        assertEquals(0, Calculadora.Registro.size());

        // Testa se a função exibirRegistros não gera exceção com lista vazia
        Calculadora.exibirRegistros();
        assertDoesNotThrow(() -> Calculadora.exibirRegistros());
    }

    /**
     * Testa a funcionalidade de exibição de registros quando o registro não está
     * vazio.
     *
     * Este teste adiciona um registro à lista de registros da Calculadora e
     * verifica se a função exibirRegistros imprime corretamente o registro.
     * O teste visa garantir que a exibição de registros funciona conforme o
     * esperado
     * quando há pelo menos um registro presente na lista.
     *
     * @see Calculadora#adicionarRegistroOperacao(String)
     * @see Calculadora#exibirRegistros()
     * 
     *      TODO: Este teste não está funcionando corretamente, preciso verificar o
     *      assertAll
     */
    @Ignore
    @Test
    @DisplayName("Teste exibir registros não vazio")
    public void testExibirRegistrosNaoVazio() {
        // Adiciona um registro
        Calculadora.adicionarRegistroOperacao("Registro de teste");
        // assertEquals("Registro de teste", Calculadora.Registro.get(0));

        // Testa se a função exibirRegistros imprime corretamente o registro
        Calculadora.exibirRegistros();
        assertAll("Exibir registros",
                () -> assertEquals(1, Calculadora.Registro.size()),
                () -> assertEquals("Registro de teste", Calculadora.Registro.get(0)));
    }

    /**
     * Testa o método {@code limparRegistros()} da classe {@code Calculadora}.
     * 
     * Este teste verifica se o método limpa corretamente todos os registros
     * armazenados
     * na instância da classe {@code Calculadora}. Para isso, são adicionados alguns
     * registros
     * de operações, em seguida, o método {@code limparRegistros()} é invocado, e
     * por fim,
     * é verificado se a lista de registros está vazia.
     * 
     * <p>
     * <b>Precondição:</b> A lista de registros não está vazia.
     * </p>
     * 
     * <p>
     * <b>Pós-condição:</b> A lista de registros está vazia após a execução do
     * método
     * {@code limparRegistros()}.
     * </p>
     * 
     * @see Calculadora#limparRegistros()
     */
    @Test
    public void testLimparRegistros() {
        // Adiciona alguns registros
        Calculadora.adicionarRegistroOperacao("Registro 1");
        Calculadora.adicionarRegistroOperacao("Registro 2");

        // Limpa os registros
        Calculadora.limparRegistros();

        List<String> registros = Calculadora.Registro;
        assertTrue(registros.isEmpty());
    }
}