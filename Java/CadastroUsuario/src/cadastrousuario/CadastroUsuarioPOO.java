package cadastrousuario;

import cadastrousuario.services.Funcoes;
import cadastrousuario.entities.Endereco;
import cadastrousuario.entities.Pessoa;
import java.util.Scanner;

public class CadastroUsuarioPOO {

    private static final Integer Limite = 5;
    private static int contador_pessoas = -1;
    private static int contador_enderecos = -1;

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
                    cadastroPessoas[contador_pessoas].setId(contador_pessoas);
                    break;

                case LISTAR_PESSOA:
                    listarPessoas(cadastroPessoas);
                    break;

                case ATUALIZAR_PESSOA:
                    atualizaPessoa(cadastroPessoas, cadastroEnderecos, entrada);
                    break;

                case EXCLUIR_PESSOA:
                    excluirPessoa(cadastroPessoas, entrada);
                    break;

                case CADASTRAR_ENDERECO:
                    contador_enderecos = (contador_enderecos < Limite - 1) ? contador_enderecos + 1 : 0;
                    Endereco endereco = new Endereco();
                    Endereco enderecoCadastrado = Funcoes.cadastrarEndereco(endereco, entrada);
                    cadastroEnderecos[contador_enderecos] = enderecoCadastrado;
                    cadastroEnderecos[contador_enderecos].setId(contador_enderecos);
                    break;

                case LISTAR_ENDERECO:
                    listarEnderecos(cadastroEnderecos);
                    break;

                case ATUALIZAR_ENDERECO:
                    atualizaEndereco(cadastroEnderecos, entrada);
                    break;

                case EXCLUIR_ENDERECO:
                    excluirEndereco(cadastroEnderecos, entrada);
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

    public static void listarPessoas(Pessoa[] cadastroPessoas) {
        for (int i = 0; i < cadastroPessoas.length; i++) {
            if (cadastroPessoas[i] != null) {
                System.out.println(cadastroPessoas[i].toString());
            }
        }
    }

    public static Boolean buscarPessoapeloId(Pessoa[] cadastroPessoas, Integer idPessoa) {
        for (int i = 0; i < cadastroPessoas.length; i++) {
            if (cadastroPessoas[i] != null && cadastroPessoas[i].getId() == idPessoa) {
                return true;
            }
        }
        return false;
    }

    public static void atualizaPessoa(Pessoa[] cadastroPessoas, Endereco[] cadastroEnderecos, Scanner entrada) {
        final int SAIR = 0;
        final int ATUALIZAR_NOME_PESSOA = 1;
        final int ATUALIZAR_IDADE_PESSOA = 2;
        final int ATUALIZAR_SEXO_PESSOA = 3;
        final int ATUALIZAR_CIDADE_PESSOA = 4;
        final int ATUALIZAR_ALTURA_PESSOA = 5;
        final int ATUALIZAR_ENDERECO_PESSOA = 6;

        listarPessoas(cadastroPessoas);
        System.out.println("Digite o id da pessoa que deseja atualizar: ");
        Integer idPessoa = entrada.nextInt();

        if (buscarPessoapeloId(cadastroPessoas, idPessoa)) {
            while (true) {
                System.out.printf("Registro encontrado: %s\n", cadastroPessoas[idPessoa].toString());
                Funcoes.menuAtualizarPessoa();

                Integer opcaoAtualizar = entrada.nextInt();
                entrada.nextLine();
                switch (opcaoAtualizar) {
                    case ATUALIZAR_NOME_PESSOA:
                        System.out.println("Digite o nome da pessoa: ");
                        cadastroPessoas[idPessoa].setNome(entrada.nextLine());
                        break;

                    case ATUALIZAR_IDADE_PESSOA:
                        System.out.println("Digite a idade da pessoa: ");
                        cadastroPessoas[idPessoa].setIdade(Integer.parseInt(entrada.nextLine()));
                        break;

                    case ATUALIZAR_SEXO_PESSOA:
                        System.out.println("Digite o sexo da pessoa: ");
                        cadastroPessoas[idPessoa].setSexo(entrada.nextLine().charAt(0));
                        break;

                    case ATUALIZAR_CIDADE_PESSOA:
                        System.out.println("Digite a cidade da pessoa: ");
                        cadastroPessoas[idPessoa].setCidade(entrada.nextLine());
                        break;

                    case ATUALIZAR_ALTURA_PESSOA:
                        System.out.println("Digite a altura da pessoa: ");
                        cadastroPessoas[idPessoa].setAltura(Double.parseDouble(entrada.nextLine()));
                        break;

                    case ATUALIZAR_ENDERECO_PESSOA:
                        listarEnderecos(cadastroEnderecos);
                        System.out.println("Digite o id do endereco que deseja anexar ao registro: ");
                        Integer idEndereco = entrada.nextInt();
                        entrada.nextLine();
                        if (buscarEnderecopeloId(cadastroEnderecos, idEndereco)) {
                            cadastroPessoas[idPessoa].setEndereco(cadastroEnderecos[idEndereco]);
                        } else {
                            System.out.println("Registro nao encontrado");
                        }
                        break;

                    default:
                        System.out.println("Opcao invalida");
                        break;
                }
                System.out.println("Deseja continuar atualizando? 1 - Sim 0 - Nao");
                Integer opcaoContinuar = entrada.nextInt();
                entrada.nextLine();
                if (opcaoContinuar == SAIR) {
                    break;
                }
            }
            System.out.printf("Registro atualizado: %s\n", cadastroPessoas[idPessoa].toString());
        }
    }

    public static void excluirPessoa(Pessoa[] cadastroPessoas, Scanner entrada) {
        listarPessoas(cadastroPessoas);

        System.out.println("Digite o id da pessoa que deseja excluir: ");
        Integer idPessoa = entrada.nextInt();
        entrada.nextLine();

        if (buscarPessoapeloId(cadastroPessoas, idPessoa)) {
            System.out.printf("Registro encontrado: %s\n", cadastroPessoas[idPessoa].toString());
            cadastroPessoas[idPessoa] = null;
            System.out.println("Pessoa excluida com sucesso");
            listarPessoas(cadastroPessoas);
        } else {
            System.out.println("Registro nao encontrado");
        }
    }

    public static void listarEnderecos(Endereco[] cadastroEnderecos) {
        for (int i = 0; i < cadastroEnderecos.length; i++) {
            if (cadastroEnderecos[i] != null) {
                System.out.println(cadastroEnderecos[i].toString());
            }
        }
    }

    public static Boolean buscarEnderecopeloId(Endereco[] cadastroEnderecos, Integer idEndereco) {
        for (int i = 0; i < cadastroEnderecos.length; i++) {
            if (cadastroEnderecos[i] != null && cadastroEnderecos[i].getId() == idEndereco) {
                return true;
            }
        }
        return false;
    }

    public static void atualizaEndereco(Endereco[] cadastroEnderecos, Scanner entrada) {
        final int SAIR = 0;
        final int ATUALIZAR_RUA_ENDERECO = 1;
        final int ATUALIZAR_NUMERO_ENDERECO = 2;
        final int ATUALIZAR_BAIRRO_ENDERECO = 3;
        final int ATUALIZAR_CEP_ENDERECO = 4;
        final int ATUALIZAR_CIDADE_ENDERECO = 5;
        final int ATUALIZAR_ESTADO_ENDERECO = 6;
        final int ATUALIZAR_PAIS_ENDERECO = 7;

        listarEnderecos(cadastroEnderecos);
        System.out.println("Digite o id do endereco que deseja atualizar: ");
        Integer idEndereco = entrada.nextInt();

        if (buscarEnderecopeloId(cadastroEnderecos, idEndereco)) {
            while (true) {
                System.out.printf("Registro encontrado: %s\n", cadastroEnderecos[idEndereco].toString());
                Funcoes.menuAtualizarEndereco();

                Integer opcaoAtualizar = entrada.nextInt();
                entrada.nextLine();
                switch (opcaoAtualizar) {
                    case ATUALIZAR_RUA_ENDERECO:
                        System.out.println("Digite a rua: ");
                        cadastroEnderecos[idEndereco].setRua(entrada.nextLine());
                        break;
                    case ATUALIZAR_NUMERO_ENDERECO:
                        System.out.println("Digite o numero: ");
                        cadastroEnderecos[idEndereco].setNumero(Integer.parseInt(entrada.nextLine()));
                        break;
                    case ATUALIZAR_BAIRRO_ENDERECO:
                        System.out.println("Digite o bairro: ");
                        cadastroEnderecos[idEndereco].setBairro(entrada.nextLine());
                        break;
                    case ATUALIZAR_CEP_ENDERECO:
                        System.out.println("Digite o CEP: ");
                        cadastroEnderecos[idEndereco].setCep(entrada.nextLine());
                        break;
                    case ATUALIZAR_CIDADE_ENDERECO:
                        System.out.println("Digite a cidade: ");
                        cadastroEnderecos[idEndereco].setCidade(entrada.nextLine());
                        break;
                    case ATUALIZAR_ESTADO_ENDERECO:
                        System.out.println("Digite o estado: ");
                        cadastroEnderecos[idEndereco].setEstado(entrada.nextLine());
                        break;
                    case ATUALIZAR_PAIS_ENDERECO:
                        System.out.println("Digite o pais: ");
                        cadastroEnderecos[idEndereco].setPais(entrada.nextLine());
                        break;
                    default:
                        System.out.println("Opcao invalida");
                        break;
                }
                System.out.println("Deseja continuar atualizando? 1 - Sim 0 - Nao");
                Integer opcaoContinuar = entrada.nextInt();
                entrada.nextLine();
                if (opcaoContinuar == SAIR) {
                    break;
                }
            }
            System.out.printf("Registro atualizado: %s\n", cadastroEnderecos[idEndereco].toString());
        }
    }

    public static void excluirEndereco(Endereco[] cadastroEnderecos, Scanner entrada) {
        listarEnderecos(cadastroEnderecos);

        System.out.println("Digite o id do endereco que deseja excluir: ");
        Integer idEndereco = entrada.nextInt();
        entrada.nextLine();

        if (buscarEnderecopeloId(cadastroEnderecos, idEndereco)) {
            System.out.printf("Registro encontrado: %s\n", cadastroEnderecos[idEndereco].toString());
            cadastroEnderecos[idEndereco] = null;
            System.out.println("Endereco excluido com sucesso");
            listarEnderecos(cadastroEnderecos);
        } else {
            System.out.println("Registro nao encontrado");
        }
    }
}
