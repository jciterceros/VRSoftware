package calculadora.controller;

import java.util.Scanner;

import calculadora.model.CalculateModel;
import calculadora.view.CalculateView;

public class CalculateController {
    private CalculateModel model;
    private CalculateView view;
    Scanner sc = new Scanner(System.in);

    public CalculateController(CalculateModel model, CalculateView view) {
        this.model = model;
        this.view = view;
    }

    public int readOption() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                view.displayError("Valor inválido! só numeros são validos, favor digite um numero");
                view.displayMenu();
                view.displayMessage("Digite a opção desejada:");
                sc.nextLine();
            }
        }
    }

    public double readData() {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (Exception e) {
                view.displayError("Valor inválido! só numeros são validos, favor digite um numero");
                sc.nextLine();
            }
        }
    }

    public double readData(int zero) {
        double b = 0;
        while (true) {
            try {
                view.displayMessage("Digite o número novamente:");
                b = sc.nextDouble();
                if (b != 0) {
                    return b;
                }
            } catch (Exception e) {
                view.displayError("Valor inválido! só numeros são validos, favor digite um numero");
                sc.nextLine();
            }
        }
    }

    public void run() throws Exception {
        boolean running = true;
        while (running) {
            view.displayMenu();
            view.displayMessage("Digite a opção desejada:");
            int option = readOption();
            if (option == 0) {
                view.displayMessage("Saindo...");
                sc.close();
                running = false;
            } else if (option >= 1 && option <= 4) {
                view.displayMessage("Digite o primeiro número:");
                double a = readData();
                view.displayMessage("Digite o segundo número:");
                double b = readData();

                switch (option) {
                    case 1:
                        model.add(a, b);
                        break;
                    case 2:
                        model.subtract(a, b);
                        break;
                    case 3:
                        model.multiply(a, b);
                        break;
                    case 4:
                        if (b == 0) {
                            view.displayError("Valor inválido! digite um numero diferente de zero");
                            b = readData(1);
                        }
                        model.divide(a, b);
                        break;
                }
                view.showResult(option, a, b, model.getResult());
            } else {
                view.displayError("Opção inválida!");
                continue;
            }
        }
    }
}
