package Model;

import java.util.ArrayList;
import java.util.List;

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
