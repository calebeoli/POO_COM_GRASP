package Controller;

import java.util.List;

import Model.CarrinhoDeCompras;
import Model.Itnes;
import Model.Produto;
import View.View;

public class LojaController {
    private CarrinhoDeCompras carrinho;
    private View view;
    private Itnes catalogo;

    public LojaController(View view, CarrinhoDeCompras carrinho) {
        this.view = view;
        this.carrinho = carrinho;
        this.catalogo = new Itnes();
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
                case 0:
                    if (confirmarSaida()) {
                        view.exibirMensagem("fechando a loja");
                        return;
                    }
                    break;
                default:
                    view.exibirMensagem("Opção inválida");
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
            carrinho.AdicionaCarrionho(p); 
            view.exibirMensagem("'" + p.getNome() + "'adicionado ao carrinho");
        } else if (escolha != 0) {
            view.exibirMensagem("produto inválido");
        }
    }

    private void verCarrinho() {
        view.exibirCarrinho(carrinho.getItens(), carrinho.CalculaTotal());
    }

    private void finalizarCompra() {
        view.eibirNotaFiscal(carrinho.getItens(), carrinho.CalculaTotal());
    }
}