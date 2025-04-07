package Tela;

import estoque.Produto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class CentroListar extends JPanel {
    private TableModel tmProduto;
    private JTable tabelaProdutos;
    private List<Produto> produtos; 

    CentroListar() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margens
        setBackground(Color.WHITE);

      
        produtos = Produto.listarProdutos(); 
        tmProduto = new TableModel();
        tmProduto.setLista(produtos);

        tabelaProdutos = new JTable(tmProduto);

        // Painel de botões
        JPanel painelBotao = new JPanel();
        painelBotao.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Botão Excluir
        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.setPreferredSize(new Dimension(100, 30));
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaProdutos.getSelectedRow();
                if (linhaSelecionada != -1) {
                    int opcao = JOptionPane.showConfirmDialog(CentroListar.this, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (opcao == JOptionPane.YES_OPTION) {
                        produtos.remove(linhaSelecionada);
                        tmProduto.setLista(produtos);
                        
                    }
                }
               
            }
        });

        // Botão Editar
        JButton botaoEditar = new JButton("Editar");
        botaoEditar.setPreferredSize(new Dimension(100, 30));
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaProdutos.getSelectedRow();
                if (linhaSelecionada != -1) {
        
                    new CentroEditar(linhaSelecionada, tmProduto, produtos);
                }
            }
        });

        painelBotao.add(botaoExcluir);
        painelBotao.add(botaoEditar);

    
        add(new JScrollPane(tabelaProdutos), BorderLayout.CENTER);
        add(painelBotao, BorderLayout.SOUTH);
    }
}