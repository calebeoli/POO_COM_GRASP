package View;

import Model.Produto;

import java.util.Scanner;
import java.util.List;

/**
 *
 * 1. PADRÃO (GUIA): High Cohesion (Alta Coesão)
 * - ONDE FOI APLICADO:
 * Nesta classe, `View`.
 *
 * - POR QUE USAMOS:
 * A gente usou esse princípio para que cada classe tivesse uma
 * responsabilidade única (como os funcionários do hotel nos slides).
 *
 * Esta classe `View` é totalmente focada em uma só coisa: interagir
 * com o usuário. Ela só sabe "mostrar coisas na tela" e "ler o teclado".
 *
 * Ela não tem ideia de como um carrinho funciona ou como um total é
 * calculado. Isso deixa ela "coesa" e fácil de mexer no futuro
 * sem quebrar o resto do sistema.
 */

public class View{

    private Scanner scanner = new Scanner(System.in);

    public int ExibeMenu(){
        System.out.println("\n\n=========================");
        System.out.println("--- Bem Vindo à Loja ---");
        System.out.println("=========================\n");
        System.out.println("1) Ver produtos disponiveis para compra");
        System.out.println("2) Ver carrinho atual");
        System.out.println("3) Finalizar compra");
        System.out.println("4) Sair");
        System.out.println("Escolha uma opção:");

        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public String lerEntrada(String msg) {
        System.out.print(msg);
        return scanner.nextLine().trim();
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
}