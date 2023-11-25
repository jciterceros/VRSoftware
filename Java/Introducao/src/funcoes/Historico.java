package funcoes;

import java.util.ArrayList;

public class Historico {

    public static ArrayList<String> Registro = new ArrayList<String>();
    public static final Double N1 = 0.0;
    public static final Double N2 = 0.0;
    public static final String Operacao = "";
    public static final Double Resultado = 0.0;

    public static void adicionarRegistroOperacao(String operacao) {
        Registro.add(operacao);
    }

}
