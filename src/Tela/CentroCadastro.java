package Tela;

import estoque.Produto; // Importando a classe Produto do pacote estoque
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CentroCadastro extends JPanel {

    
    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JButton btnSalvar;
    private JButton btnCancelar;

    private static int idAtual = 1;

    public static int gerarId() {
        return idAtual++;
    }
    CentroCadastro() {
        
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(100, 20, 150, 20)); // Margens
        

        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridLayout(5, 2, 10, 10));
        

        txtNome = new JTextField();
        txtDescricao = new JTextField();
        txtPreco = new JTextField();
        txtQuantidade = new JTextField();

        

        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(txtNome);
        painelCampos.add(new JLabel("Descrição:"));
        painelCampos.add(txtDescricao);
        painelCampos.add(new JLabel("Preço:"));
        painelCampos.add(txtPreco);
        painelCampos.add(new JLabel("Quantidade:"));
        painelCampos.add(txtQuantidade);

        JPanel painelBotoes = new JPanel();
        
        
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(new Color(76, 175, 80));
        btnSalvar.setForeground(Color.WHITE);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.RED);
        btnCancelar.setForeground(Color.WHITE);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
       
       
        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                        int id = gerarId();
                        
                        Produto produto = new Produto(
                            id,  
                            txtNome.getText(),
                            txtDescricao.getText(),
                            Double.parseDouble(txtPreco.getText()),
                            Integer.parseInt(txtQuantidade.getText())
                        );
                    Produto.adicionarProduto(produto);
                    Client client = new Client();
                    client.sendProduto("adicionar", produto);
                    
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
        txtNome.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
    }

}
