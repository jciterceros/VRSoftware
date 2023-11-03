package calculadora.view;

public class CalculateView {

    public void displayMenu() {
        System.out.println();
        System.out.println("Calculadora");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("0 - Sair");
    }

    public void showResult(int option, double a, double b, double result) {
        String[] options = { "Soma", "Subtração", "Multiplicação", "Divisão" };
        String[] operations = { "+", "-", "*", "/" };
        System.out.printf("O resultado da %s de %.2f %s %.2f é: %.2f", options[option - 1], a, operations[option - 1],
                b, result);
        System.out.println();
    }

    public void displayError(String message) {
        System.out.println("Erro: " + message);
    }

    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
    }
}
