package View;

import java.util.Scanner;
import java.util.List;

public class View{

    private Scanner scanner = new Scanner(System.in);

    public int ExibeMenu(){
        System.out.println("--- Bem Vindo à Loja ---");
        System.out.println("1) Ver produtos disponiveis para compra");
        System.out.println("2) Ver carrinho atual");
        System.out.println("3) Finalizar compra");
        System.out.println("4) Sair");
        System.out.println("Escolha uma opção:");

        return scanner.nextInt();
    }
    public int exibirMenuProdutos(List<Produto> produtosDisponiveis) {
        System.out.println("\n--- Produtos Disponíveis ---");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), produtosDisponiveis.get(i).toString());
        }
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Digite o número do produto para adicionar (ou 0 para voltar): ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}