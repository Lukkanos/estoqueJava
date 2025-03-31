package estoque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciadorDoEstoque {
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    public void criarLinhaNoArquivo(String arquivo, String linha) {
        try {
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter escritor = new BufferedWriter(fw);
            escritor.write(linha);
            escritor.newLine();
            escritor.close();
            fw.close();
            System.out.println("Linha criada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar a linha: " + e.getMessage());
        }
    }

    public void lerArquivo(){
        try {
            
            FileReader arquivo = new FileReader("Produto.txt");
            BufferedReader leitor = new BufferedReader(arquivo);

            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(";");
                Produto produto = new Produto(Integer.parseInt(dados[0]), (dados[1]),
                (dados[2]),Double.parseDouble(dados[3]),Integer.parseInt(dados[4]),
                (dados[5]));
                
                listaDeProdutos.add(produto);
            }

            leitor.close();
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }


    public void imprimirListaNaTela() {
        try {
            FileReader arquivo = new FileReader("Produto.txt");
            BufferedReader leitor = new BufferedReader(arquivo);
            
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(";");
                System.out.println("Código: " + dados[0]);
                System.out.println("Descrição: " + dados[1]);
                System.out.println("Preço: " + dados[3]);
                System.out.println("Categoria: " + dados[4]);
                System.out.println();
            }
            
            leitor.close();
            arquivo.close();
            System.out.println("Lista impressa com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao imprimir a lista: " + e.getMessage());
        }
    }
}


