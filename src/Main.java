import Controller.LojaController;
import Model.CarrinhoDeCompras;
import View.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        LojaController controller = new LojaController(view, carrinho);
        controller.iniciar();
    }
}