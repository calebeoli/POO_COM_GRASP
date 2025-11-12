package View;

import Model.Produto;

import java.util.Scanner;
import java.util.List;

public class View{

    private Scanner scanner = new Scanner(System.in);

    public int ExibeMenu(){
        System.out.println("=========================");
        System.out.println("--- Bem Vindo à Loja ---");
        System.out.println("=========================");
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

    public void exibirCarrinho(List<Produto> itens, double total){
        System.out.println("--- Produtos no seu carrinho ---");
        if(itens.isEmpty()){
            System.out.println("O carrinho esta vazio");
        }else {
            for (Produto item: itens){
                System.out.println("- " +  item.toString());
            }
        }
        System.out.printf("Total : R$%.2f\n", total);
    }
    public void exibirNotaFiscal(List<Produto> itens, double total) {
        System.out.println("\n--- NOTA FISCAL ---");
        System.out.println("\nProdutos Adquiridos:");
        for (Produto item : itens) {
            System.out.println("- " + item.toString());
        }
        System.out.printf("----------------------------\n");
        System.out.printf("VALOR TOTAL PAGO: R$%.2f\n", total);
        System.out.println("\nObrigado, volte sempre!");
    }


    public void mostrarMensagem(String msg){
        System.out.println(msg);
    }


    public String lerEntrada(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
}


