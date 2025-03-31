package Tela;

import estoque.GerenciadorDoEstoque;
import estoque.Produto;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GerenciadorDoEstoque gde = new GerenciadorDoEstoque();
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        gde.lerArquivo();

        new TelaPrincipal();

        String linha = "1;Notebook; Notebook Intel Core i5;25000;3;Informatica";
        gde.criarLinhaNoArquivo("Produto.txt",linha);

        gde.imprimirListaNaTela();
        
    }
}
