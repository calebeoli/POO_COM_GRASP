public class LojaController {
  private CarinhoDeCompras Model;
  private View view;

  public iniciar() {
    int opcao;
    opcao = view.exibirMnuPrincipal();
    switch (opcao) {
      case 1 adicionarProduto();
      case 2 verCarrinho();
      case 3 finalizarCompra();
      case 0 {
        if (confirmarSaida()) {
          view.exibirMensagem("fechando a loja");
          return;
        }
      }
        default view.exibirMensagem("Opção inválida");
    }
  }
}
private boolean confirmarSaida() {
  String resposta = view.lerEntrada("Tem certeza que deseja sair? (sim/não): ");
  return resposta.equals("sim");
}

private void adicionarProduto (){
  int escolha = view.exibirMenuProdtos(produtos);
  if (escolha > 0 && escola <= produtos.size()) {
    Produto p = produtos.get(eescolha - 1);
    carrinho.adicionarProduto(p);
    view.exibirMensagem("'" + p.getNome() + "'adicionado ao carrinho");
  } else if (escolha != 0) {
    view.exibirMensagem("produto inválido");
  }
}

private void verCarrinho() {
  view.exibirCarrinho(carrinho.getItens(), carrinho.calcularTotal());
}

private void finalizarCompra() {
  view.eibirNotaFiscal(carrinho.getItens(), carrinho.calcularTotal());
  }
}
