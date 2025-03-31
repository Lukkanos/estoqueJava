package Tela;

import estoque.Produto; // Importando a classe Produto do pacote estoque
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CentroCadastro extends JPanel {

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JButton btnSalvar;
    private JButton btnCancelar;
    CentroCadastro() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margens
        setBackground(Color.WHITE);

        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridLayout(5, 2, 10, 10));
        painelCampos.setBackground(Color.WHITE);

        txtId = new JTextField();
        txtNome = new JTextField();
        txtDescricao = new JTextField();
        txtPreco = new JTextField();
        txtQuantidade = new JTextField();
    

        painelCampos.add(new JLabel("ID:"));
        painelCampos.add(txtId);
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(txtNome);
        painelCampos.add(new JLabel("Descrição:"));
        painelCampos.add(txtDescricao);
        painelCampos.add(new JLabel("Preço:"));
        painelCampos.add(txtPreco);
        painelCampos.add(new JLabel("Quantidade:"));
        painelCampos.add(txtQuantidade);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(Color.WHITE);
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
       
        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Produto produto = new Produto(
                        Integer.parseInt(txtId.getText()),
                        txtNome.getText(),
                        txtDescricao.getText(),
                        Double.parseDouble(txtPreco.getText()),
                        Integer.parseInt(txtQuantidade.getText())
                    );
                    Produto.adicionarProduto(produto);
                    
                    JOptionPane.showMessageDialog(CentroCadastro.this, 
                        "Produto cadastrado com sucesso:\n" + produto.toString());

                        limparCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CentroCadastro.this, 
                        "Erro: Insira valores numéricos válidos para ID, Preço e Quantidade");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(CentroCadastro.this, 
                        "Erro ao cadastrar produto: " + ex.getMessage());
                }
            }
        });
       
        
    }
    //Criei um metodo para limpar os campos
    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
    }

}
