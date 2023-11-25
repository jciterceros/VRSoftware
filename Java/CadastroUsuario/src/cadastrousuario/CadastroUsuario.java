package cadastrousuario;

import java.util.Scanner;

/**
 * @implNote Sistema de Cadastro de Usuarios, aceita as operações CRUD:
 *           Inserção, alteração, exclução e listagem de usuarios.
 * @author Fernando
 * @since 2023-11-12
 */
public class CadastroUsuario {

    public static Integer Limite = 5;
    public static Integer Contador = 0;
    public static Integer Indice = -1;
    public static String[][] usuarios = new String[Limite][5];
    public static final int NOME = 0;
    public static final int IDADE = 1;
    public static final int SEXO = 2;
    public static final int CIDADE = 3;
    public static final int ALTURA = 4;

    // Rua, Numero, Bairro, CEP, Cidade, Estado, Pais
    public static String[][] endereco = new String[Limite][6];
    public static final int RUA = 0;
    public static final int NUMERO = 1;
    public static final int BAIRRO = 2;
    public static final int CEP = 3;
    public static final int CIDADE_ENDERECO = 4;
    public static final int ESTADO = 5;
    public static final int PAIS = 6;

    public static final int CADASTRAR = 1;
    public static final int ALTERAR = 2;
    public static final int EXCLUIR = 3;
    public static final int LISTAR = 4;
    public static final int SAIR = 5;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Boolean op = true;
        while (op) {
            menu();
            Integer opcao = entrada.nextInt();
            switch (opcao) {
                case CADASTRAR:
                    cadastrarUsuario(entrada);
                    break;

                case ALTERAR:
                    alterarUsuario(entrada);
                    break;

                case EXCLUIR:
                    excluirUsuario(entrada);
                    break;

                case LISTAR:
                    listarUsuario();
                    break;

                case SAIR:
                    entrada.close();
                    op = false;
                    break;

                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }
    }

    /**
     * Menu de opções do sistema
     * 
     * @param Sem parametros de entrada
     * @return Sem retorno
     * 
     *         Exemplo de uso:
     * 
     *         <pre>
     * {@code
     * menu();
     * }
     * </pre>
     * 
     */
    public static void menu() {
        System.out.println("Cadastro de Usuarios");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Listar");
        System.out.println("5 - Sair");
    }

    /**
     * Coleta dados de um usuário a partir do Scanner e os armazena na matriz de
     * usuários.
     *
     * @param entrada Scanner utilizado para coletar dados do usuário.
     * @param Posicao Índice na matriz de usuários onde os dados serão armazenados.
     * @return Sem retorno.
     * 
     *         Exemplo de uso:
     * 
     *         <pre>
     * {@code
     * coletarDados(entrada, 0);
     * }
     * </pre>
     * 
     */
    public static void coletarDados(Scanner entrada, Integer Posicao) {
        entrada.nextLine();

        System.out.println("Nome: ");
        usuarios[Posicao][NOME] = entrada.nextLine();

        System.out.println("Idade: ");
        usuarios[Posicao][IDADE] = entrada.nextLine();

        System.out.println("Sexo: ");
        usuarios[Posicao][SEXO] = entrada.nextLine();

        System.err.println("Altura: ");
        usuarios[Posicao][ALTURA] = entrada.nextLine();

        System.out.println("Cidade: ");
        usuarios[Posicao][CIDADE] = entrada.nextLine();
    }

    public static int coletarEndereco(Scanner entrada, Integer Posicao) {
        entrada.nextLine();

        System.out.println("Rua: ");
        endereco[Posicao][RUA] = entrada.nextLine();

        System.out.println("Numero: ");
        endereco[Posicao][NUMERO] = entrada.nextLine();

        System.out.println("Bairro: ");
        endereco[Posicao][BAIRRO] = entrada.nextLine();

        System.out.println("CEP: ");
        endereco[Posicao][CEP] = entrada.nextLine();

        System.out.println("Cidade: ");
        endereco[Posicao][CIDADE_ENDERECO] = entrada.nextLine();

        System.out.println("Estado: ");
        endereco[Posicao][ESTADO] = entrada.nextLine();

        System.out.println("Pais: ");
        endereco[Posicao][PAIS] = entrada.nextLine();

        return Posicao;
    }

    /**
     * Cadastra um novo usuário.
     *
     * Verifica se o limite de usuários foi atingido.
     * Se atingido, exibe uma mensagem informando que o limite foi alcançado.
     * Realiza a coleta de dados do usuário utilizando o método coletarDados.
     *
     * @param entrada Scanner utilizado para receber entrada do usuário.
     * @return Sem retorno.
     * 
     *         Exemplo de uso:
     * 
     *         <pre>
     * {@code
     * cadastrarUsuario();
     * }
     * </pre>
     * 
     */
    public static void cadastrarUsuario(Scanner entrada) {
        /**
         * Verifica se o número de usuários cadastrados atingiu o limite predefinido.
         * Se atingido, exibe uma mensagem e reinicia o contador de usuários.
         */
        if (Contador >= Limite) {
            System.out.println("Limite de usuarios atingido");
            Contador = 0;
        }
        System.out.println("Cadastrando Usuario");

        // Realiza a coleta de dados do usuário utilizando o método coletarDados.
        coletarDados(entrada, Contador);

        // Incrementa o contador de usuários.
        Contador++;
    }

    /**
     * Exibe a lista de usuários cadastrados, mostrando informações como nome,
     * idade, sexo, cidade e altura.
     * Se um usuário não tiver sido preenchido completamente, a linha correspondente
     * será pulada na listagem.
     * 
     * A listagem é limitada pelo valor da constante Limite.
     * 
     * @param Sem parametros de entrada
     * @return Sem retorno
     * 
     * 
     *         Exemplo de uso:
     * 
     *         <pre>
     * {@code
     * listarUsuario();
     * }
     * </pre>
     */
    public static void listarUsuario() {
        System.out.println("Listando Usuarios");

        System.out.println("Nome    Idade   Sexo    Cidade  Altura");
        for (int i = 0; i < Limite; i++) {
            if (usuarios[i][NOME] == null) {
                continue;
            } else {
                System.out.println(
                        usuarios[i][NOME] + "\t" +
                                usuarios[i][IDADE] + "\t " +
                                usuarios[i][SEXO] + "\t " +
                                usuarios[i][CIDADE] + "\t " +
                                usuarios[i][ALTURA]);
            }
        }
    }

    /**
     * Busca um usuário pelo nome no array de usuários.
     *
     * @param nome O nome do usuário a ser buscado.
     * @return true se o usuário for encontrado; false caso contrário.
     * 
     *         Exemplo de uso:
     * 
     *         <pre>
     * {@code
     * buscarUsuario("Fernando");
     * }
     * </pre>
     * 
     */
    public static Boolean buscarUsuario(String nome) {
        /**
         * Itera sobre o array de usuários para encontrar o usuário com o nome
         * especificado.
         * Se encontrado, define o índice do usuário encontrado (Indice) e retorna true.
         * Se não encontrado, define o índice como -1 e retorna false.
         */
        for (int i = 0; i < Limite; i++) {
            if (usuarios[i][NOME] == null)
                continue;
            if (usuarios[i][NOME].equals(nome)) {
                Indice = i;
                return true;
            }
        }

        // Caso o usuário não seja encontrado, define o índice como -1 e retorna false.
        Indice = -1;
        return false;
    }

    /**
     * Este método permite alterar os registros de um usuário.
     * Ele exibe a lista de usuários, solicita o nome do usuário a ser alterado
     * e, se encontrado, permite a entrada de novos dados para o usuário.
     *
     * @param entrada O Scanner utilizado para a entrada de dados.
     * @return Sem retorno.
     * 
     *         Exemplo de uso:
     * 
     *         <pre>
     * {@code
     * alterarUsuario();
     * }
     * </pre>
     * 
     */
    public static void alterarUsuario(Scanner entrada) {
        System.out.println("Alterando Registros");
        listarUsuario();
        entrada.nextLine();
        System.out.println("Informe o Nome do usuario a ser alterado: ");
        String nome = entrada.nextLine();

        // Verifica se o usuário existe antes de tentar alterá-lo
        if (buscarUsuario(nome)) {
            // Se o usuário existe, coleta novos dados
            coletarDados(entrada, Indice);
        } else {
            // Se o usuário não existe, exibe mensagem de não encontrado
            System.out.println("Usuario não encontrado");
        }
    }

    /**
     * Este método permite excluir um usuário com base no nome fornecido.
     * O usuário é excluído definindo os campos correspondentes como nulos.
     *
     * @param entrada Scanner para entrada de dados.
     * @return Sem retorno.
     * 
     *         Exemplo de uso:
     * 
     *         <pre>
     * {@code
     * excluirUsuario();
     * }
     * </pre>
     * 
     */
    public static void excluirUsuario(Scanner entrada) {
        System.out.println("Excluindo Usuario");
        listarUsuario();
        entrada.nextLine();
        System.out.println("Informe o Nome do usuario a ser excluido: ");
        String nome = entrada.nextLine();

        // Verifica se o usuário existe antes de excluí-lo
        if (buscarUsuario(nome)) {
            // Exclui o usuário definindo os campos como nulos
            usuarios[Indice][NOME] = null;
            usuarios[Indice][IDADE] = null;
            usuarios[Indice][SEXO] = null;
            usuarios[Indice][CIDADE] = null;
            usuarios[Indice][ALTURA] = null;
        } else {
            System.out.println("Usuario não encontrado");
        }
    }
}
