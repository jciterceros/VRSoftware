package cadastrousuario;

import java.util.Scanner;

public class Funcoes {

    public static void menu() {
        System.out.println("1 - Cadastrar pessoa"); // CREATE
        System.out.println("2 - Listar pessoas"); // READ
        System.out.println("3 - Atualizar dados da pessoa"); // UPDATE
        System.out.println("4 - Excluir pessoa"); // DELETE

        System.out.println("5 - Cadastrar endereco"); // CREATE
        System.out.println("6 - Listar enderecos"); // READ
        System.out.println("7 - Atualizar dados do endereco"); // UPDATE
        System.out.println("8 - Excluir endereco"); // DELETE
        System.out.println("0 - Sair");
    }

    public static void menuAtualizarPessoa() {
        System.out.println("1 - Nome");
        System.out.println("2 - Idade");
        System.out.println("3 - Sexo");
        System.out.println("4 - Cidade");
        System.out.println("5 - Altura");
    }

    public static Pessoa cadastrarPessoa(Pessoa pessoa, Scanner teclado) {
        teclado.nextLine();

        System.out.println("Digite o nome da pessoa: ");
        pessoa.setNome(teclado.nextLine());

        System.out.println("Digite a idade da pessoa: ");
        pessoa.setIdade(Integer.parseInt(teclado.nextLine()));

        System.out.println("Digite o sexo da pessoa: ");
        pessoa.setSexo(teclado.nextLine().charAt(0));

        System.out.println("Digite a cidade da pessoa: ");
        pessoa.setCidade(teclado.nextLine());

        System.out.println("Digite a altura da pessoa: ");
        pessoa.setAltura(Double.parseDouble(teclado.nextLine()));

        return pessoa;
    }

    public static Endereco cadastrarEndereco(Endereco endereco, Scanner teclado) {
        teclado.nextLine();

        System.out.println("Digite a rua: ");
        endereco.setRua(teclado.nextLine());

        System.out.println("Digite o numero: ");
        endereco.setNumero(Integer.parseInt(teclado.nextLine()));

        System.out.println("Digite o bairro: ");
        endereco.setBairro(teclado.nextLine());

        System.out.println("Digite o CEP: ");
        endereco.setCep(teclado.nextLine());

        System.out.println("Digite a cidade: ");
        endereco.setCidade(teclado.nextLine());

        System.out.println("Digite o estado: ");
        endereco.setEstado(teclado.nextLine());

        System.out.println("Digite o pais: ");
        endereco.setPais(teclado.nextLine());

        return endereco;
    }
}
