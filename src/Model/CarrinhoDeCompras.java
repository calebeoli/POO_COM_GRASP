package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * PADRÃO High Cohesion (Alta Coesão)
 * - ONDE FOI APLICADO:
 * Nesta classe (e em todas as outras).
 *
 * - POR QUE USAMOS:
 * A gente quis que cada classe tivesse uma responsabilidade única.
 * Esta classe só se preocupa em "gerenciar os itens do carrinho".
 * Ela não se mete em mostrar coisas na tela (isso é da `View`).
 * Isso deixa o código mais fácil de entender.
 */

public class CarrinhoDeCompras {
    private List<Produto> Itens = new ArrayList<>();

    public void AdicionaCarrinho(Produto produto){
        Itens.add(produto);
    }

    public void RetiraCarrinho(Produto produto){
        Itens.remove(produto);
    }

    public List<Produto> getItens() {
        return new ArrayList<>(Itens);
    }

    public double CalculaTotal(){
        double total = 0;
        for(Produto item: Itens){
            total += item.getPreco();
        }
        return total;
    }

}
