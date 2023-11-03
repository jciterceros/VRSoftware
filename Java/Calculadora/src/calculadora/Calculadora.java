package calculadora;

import calculadora.controller.CalculateController;
import calculadora.model.CalculateModel;
import calculadora.view.CalculateView;

/**
 *
 * @author Fernando Terceros
 * @version 1.0
 * @since 2023-11-02
 * @implNote MVC Calculator
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalculateModel model = new CalculateModel();
        CalculateView view = new CalculateView();
        CalculateController controller = new CalculateController(model, view);
        try {
            controller.run();
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }
}
