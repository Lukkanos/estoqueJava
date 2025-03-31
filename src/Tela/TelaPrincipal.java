package Tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import estoque.Produto;

public class TelaPrincipal extends JFrame {

    private JPanel painelCentral;

    public TelaPrincipal() {
        setTitle("Menu de Escolha");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel painelLateral = new JPanel();
        painelLateral.setLayout(new BoxLayout(painelLateral, BoxLayout.Y_AXIS));
        painelLateral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painelLateral.setPreferredSize(new Dimension(200, getHeight()));
        painelLateral.setBackground(new Color(200, 210, 200));

        painelCentral = new JPanel();
        painelCentral.setBackground(Color.WHITE);
        painelCentral.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Opções");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setForeground(Color.BLACK);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        cadastrar.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrar.setForeground(Color.WHITE);
        cadastrar.setBackground(new Color(76, 175, 80));
        cadastrar.setMaximumSize(new Dimension(160, 40));

        JButton listar = new JButton("Listar");
        listar.setAlignmentX(Component.CENTER_ALIGNMENT);
        listar.setFont(new Font("Arial", Font.BOLD, 16));
        listar.setForeground(Color.WHITE);
        listar.setBackground(new Color(33, 150, 243));
        listar.setMaximumSize(new Dimension(160, 40));

        JButton editar = new JButton("Editar");
        editar.setAlignmentX(Component.CENTER_ALIGNMENT);
        editar.setFont(new Font("Arial", Font.BOLD, 16));
        editar.setForeground(Color.WHITE);
        editar.setBackground(new Color(255, 152, 0));
        editar.setMaximumSize(new Dimension(160, 40));

        painelLateral.add(titulo);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 15)));
        painelLateral.add(cadastrar);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 15)));
        painelLateral.add(listar);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 15)));
        painelLateral.add(editar);

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                CentroCadastro centroCadastro = new CentroCadastro();
                painelCentral.removeAll();
                painelCentral.add(centroCadastro);
                painelCentral.revalidate();
                painelCentral.repaint();
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelCentral.removeAll();
                painelCentral.add(new JLabel("Tela de Editar", JLabel.CENTER), BorderLayout.CENTER);
                painelCentral.revalidate();
                painelCentral.repaint();
            }
        });
        
        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CentroListar centerListar = new CentroListar();
                painelCentral.removeAll();
                painelCentral.add(centerListar);
                painelCentral.revalidate();
                painelCentral.repaint();
            }
        });
        add(painelCentral, BorderLayout.CENTER);
        add(painelLateral, BorderLayout.WEST);
        setVisible(true);
    }

<<<<<<< HEAD
    public static void main(String[] args) {
        Produto.adicionarProduto(new Produto(1, "Mouse", "Mouse com fio", 59.90, 10));
        Produto.adicionarProduto(new Produto(2, "Teclado", "Teclado mecânico", 199.90, 5));
        new TelaPrincipal();
    }
=======
>>>>>>> c9e0b657f422c10eed5db5ef2faac40d427bc149
}
