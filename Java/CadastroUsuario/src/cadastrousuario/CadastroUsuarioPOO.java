package cadastrousuario;

import java.util.Scanner;

public class CadastroUsuarioPOO {

    private static final Integer Limite = 5;
    /*
     * 
     * 1 - Cadastrar pessoa
     * 2 - Listar pessoas
     * 3 - Atualizar dados da pessoa
     * 4 - Excluir pessoa
     * 5 - Cadastrar endereco
     * 6 - Listar enderecos
     * 7 - Atualizar dados do endereco
     * 8 - Excluir endereco
     * 0 - Sair
     */
    private static final int CADASTRAR_PESSOA = 1;
    private static final int LISTAR_PESSOA = 2;
    private static final int ATUALIZAR_PESSOA = 3;
    private static final int EXCLUIR_PESSOA = 4;
    private static final int CADASTRAR_ENDERECO = 5;
    private static final int LISTAR_ENDERECO = 6;
    private static final int ATUALIZAR_ENDERECO = 7;
    private static final int EXCLUIR_ENDERECO = 8;
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
                            // System.out.println(cadastroPessoas[i].mostrarDados());
                            System.out.println(cadastroPessoas[i].toString());
                        }
                    }
                    break;

                case ATUALIZAR_PESSOA:
                    for (int i = 0; i < cadastroPessoas.length; i++) {
                        if (cadastroPessoas[i] != null) {
                            System.out.println(cadastroPessoas[i].toString());
                        }
                    }
                    System.out.println("Digite o id da pessoa que deseja atualizar: ");
                    Integer idPessoa = entrada.nextInt();

                    for (int i = 0; i < cadastroPessoas.length; i++) {
                        if (cadastroPessoas[i] != null && cadastroPessoas[i].getId() == idPessoa) {

                            System.out.println("Qual dado deseja atualizar?");
                            Funcoes.menuAtualizarPessoa();

                            Integer opcaoAtualizar = entrada.nextInt();
                            switch (opcaoAtualizar) {
                                case 1:
                                    System.out.println("Digite o nome da pessoa: ");
                                    cadastroPessoas[idPessoa].setNome(entrada.next());
                                    break;
                                case 2:
                                    System.out.println("Digite a idade da pessoa: ");
                                    cadastroPessoas[idPessoa].setIdade(entrada.nextInt());
                                    break;
                                case 3:
                                    System.out.println("Digite o sexo da pessoa: ");
                                    cadastroPessoas[idPessoa].setSexo(entrada.next().charAt(0));
                                    break;
                                case 4:
                                    System.out.println("Digite a cidade da pessoa: ");
                                    cadastroPessoas[idPessoa].setCidade(entrada.next());
                                    break;
                                case 5:
                                    System.out.println("Digite a altura da pessoa: ");
                                    cadastroPessoas[idPessoa].setAltura(entrada.nextDouble());
                                    break;
                                default:
                                    System.out.println("Opcao invalida");
                                    break;
                            }
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
