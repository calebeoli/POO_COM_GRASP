package Controller;

import java.util.List;
import Model.CarrinhoDeCompras;
import Model.Catalogo;
import Model.Produto;
import View.View;

public class LojaController {
    private CarrinhoDeCompras carrinho;
    private View view;
    private Catalogo catalogo;

    public LojaController(View view, CarrinhoDeCompras carrinho) {
        this.view = view;
        this.carrinho = carrinho;
        this.catalogo = new Catalogo();
    }

    public void iniciar() {
        int opcao;

        while (true) {
            opcao = view.ExibeMenu();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    verCarrinho();
                    break;
                case 3:
                    finalizarCompra();
                    break;
                case 4:
                    if (confirmarSaida()) {
                        view.mostrarMensagem("Fechando a loja. Obrigado!");
                        return;
                    }
                    break;
                default:
                    view.mostrarMensagem("Opção inválida. Por favor, escolha de 1 a 4.");
            }
        }
    }

    private boolean confirmarSaida() {
        String resposta = view.lerEntrada("Tem certeza que deseja sair? (sim/não): ");
        return resposta.equals("sim");
    }

    private void adicionarProduto (){
        List<Produto> produtosDisponiveis = catalogo.getProdutosDisponiveis(); 
        int escolha = view.exibirMenuProdutos(produtosDisponiveis);
        
        if (escolha > 0 && escolha <= produtosDisponiveis.size()) {
            Produto p = produtosDisponiveis.get(escolha - 1);
            carrinho.AdicionaCarrinho(p);
            view.mostrarMensagem("'" + p.getNome() + "' adicionado ao carrinho.");
        } else if (escolha == 0) {
        } else {
            view.mostrarMensagem("Produto inválido.");
        }
    }

    private void verCarrinho() {
        view.exibirCarrinho(carrinho.getItens(), carrinho.CalculaTotal());
    }

    private void finalizarCompra() {
        view.exibirNotaFiscal(carrinho.getItens(), carrinho.CalculaTotal());
    }
}