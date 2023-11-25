package cadastrousuario;

import java.util.Scanner;

public class CadastroUsuarioPOO {

    private static final Integer Limite = 5;

    private static final int CADASTRAR_PESSOA = 1;
    private static final int LISTAR_PESSOA = 2;
    private static final int CADASTRAR_ENDERECO = 3;
    private static final int LISTAR_ENDERECO = 4;
    private static final int SAIR = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int contador_pessoas = -1;
        int contador_enderecos = -1;

        Pessoa[] cadastroPessoas = new Pessoa[Limite];
        Endereco[] cadastroEnderecos = new Endereco[Limite];

        while (true) {
            Funcoes.menu();
            Integer opcao = entrada.nextInt();
            switch (opcao) {
                case CADASTRAR_PESSOA:
                    contador_pessoas = (contador_pessoas < Limite - 1) ? contador_pessoas + 1 : 0;
                    Pessoa pessoa = new Pessoa();
                    Pessoa pessoaCadastrada = Funcoes.cadastrarPessoa(pessoa, entrada);
                    cadastroPessoas[contador_pessoas] = pessoaCadastrada;
                    break;

                case LISTAR_PESSOA:
                    for (int i = 0; i < cadastroPessoas.length; i++) {
                        if (cadastroPessoas[i] != null) {
                            System.out.println(cadastroPessoas[i].mostrarDados());
                        }
                    }
                    break;

                case CADASTRAR_ENDERECO:
                    contador_enderecos = (contador_enderecos < Limite - 1) ? contador_enderecos + 1 : 0;
                    Endereco endereco = new Endereco();
                    Endereco enderecoCadastrado = Funcoes.cadastrarEndereco(endereco, entrada);
                    cadastroEnderecos[contador_enderecos] = enderecoCadastrado;
                    break;

                case LISTAR_ENDERECO:
                    for (int i = 0; i < cadastroEnderecos.length; i++) {
                        if (cadastroEnderecos[i] != null) {
                            System.out.println(cadastroEnderecos[i].mostrarDados());
                        }
                    }
                    break;

                case SAIR:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }
}
