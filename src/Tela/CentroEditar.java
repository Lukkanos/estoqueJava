package Tela;

import estoque.Produto;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class CentroEditar {

    public CentroEditar(int linhaSelecionada, TableModel tm, List<Produto> produtos) {
        JFrame janela = new JFrame("Editar");
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Pega os dados dos campos da tabela
        String nome = tm.getValueAt(linhaSelecionada, 1).toString();
        String descricao = tm.getValueAt(linhaSelecionada, 2).toString();
        double preco = Double.parseDouble(tm.getValueAt(linhaSelecionada, 3).toString());
        int quantidade = Integer.parseInt(tm.getValueAt(linhaSelecionada, 4).toString());


        JPanel painelsul = new JPanel();
        painelsul.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField(nome);
        JLabel labelDescricao = new JLabel("Descrição:");
        JTextField campoDescricao = new JTextField(descricao);
        JLabel labelPreco = new JLabel("Preço:");
        JTextField campoPreco = new JTextField(String.valueOf(preco));
        JLabel labelQuantidade = new JLabel("Quantidade:");
        JTextField campoQuantidade = new JTextField(String.valueOf(quantidade));

        janela.setLayout(new GridLayout(6, 2));  
        janela.add(labelNome);
        janela.add(campoNome);
        janela.add(labelDescricao);
        janela.add(campoDescricao);
        janela.add(labelPreco);
        janela.add(campoPreco);
        janela.add(labelQuantidade);
        janela.add(campoQuantidade);

        JButton botaoSalvar = new JButton("Salvar");
        janela.add(painelsul,BorderLayout.SOUTH);
        painelsul.add(botaoSalvar);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String novoNome = campoNome.getText();
                    String novaDescricao = campoDescricao.getText();
                    double novoPreco = Double.parseDouble(campoPreco.getText());
                    int novaQuantidade = Integer.parseInt(campoQuantidade.getText());

                    if (novoPreco < 0 || novaQuantidade < 0) {
                        JOptionPane.showMessageDialog(null, "Preço e quantidade não podem ser negativos!");
                        return; // Interrompe o processo de cadastro
                    }
                    

                    Produto produtoSelecionado = produtos.get(linhaSelecionada);
                    produtoSelecionado.setNome(novoNome);
                    produtoSelecionado.setDescricao(novaDescricao);
                    produtoSelecionado.setPreco(novoPreco);
                    produtoSelecionado.setQuantidade(novaQuantidade);

                    tm.fireTableRowsUpdated(linhaSelecionada, linhaSelecionada);
                   // Client client =new Client();
                   // client.sendProduto("editar", produtoSelecionado);

                    janela.dispose(); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(janela, "Erro ao converter valores. Verifique os campos.", "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        janela.setSize(500, 300);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
}