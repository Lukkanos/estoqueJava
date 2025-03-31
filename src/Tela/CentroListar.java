package Tela;
import estoque.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class CentroListar extends JPanel{

    CentroListar(){
    	
        setLayout(new BorderLayout(10,10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margens
        setBackground(Color.WHITE);

        String[] colunas = {"ID","Nome","Descrição","Quantidade","Preço"};
        List<Produto> lista = Produto.listarProdutos();
        Object[][] dados = new Object[lista.size()][5];
        for (int i = 0; i < lista.size(); i++) {
            Produto p = lista.get(i);
            dados[i][0] = p.getId();
            dados[i][1] = p.getNome();
            dados[i][2] = p.getDescricao();
            dados[i][3] = p.getQuantidade();
            dados[i][4] = p.getPreco();
        }

        JTable tabela = new JTable(dados,colunas);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

}

