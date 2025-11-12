package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalogo { 
    private List<Produto> produtos;

    public Catalogo () { 
        this.produtos = new ArrayList<>();
        this.produtos.add(new Produto("Notebook Core i5", 3500.00));
        this.produtos.add(new Produto("Smartphone Última Geração", 2100.00));
        this.produtos.add(new Produto("Mouse Pad Grande", 50.00));
        this.produtos.add(new Produto("Fone de ouvido", 80.00));
        this.produtos.add(new Produto("HD Externo 1TB", 300.00));
        this.produtos.add(new Produto("Teclado gamer", 120.00));
        this.produtos.add(new Produto("Filtro de Linha 8 Tomadas", 85.00));
        this.produtos.add(new Produto("Memória RAM DDR5 16GB", 380.00));
    }

    public List<Produto> getProdutosDisponiveis() {
        return Collections.unmodifiableList(produtos);
    }
}