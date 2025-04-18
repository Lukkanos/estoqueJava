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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



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

        JLabel labelTexto = new JLabel("Bem Vindo! ;)");
        labelTexto.setHorizontalAlignment(SwingConstants.CENTER); 
        labelTexto.setFont(new Font("Arial", Font.PLAIN, 24)); 

        painelCentral.add(labelTexto);
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

        JButton sair = new JButton("Sair");
        sair.setAlignmentX(Component.CENTER_ALIGNMENT);
        sair.setFont(new Font("Arial", Font.BOLD, 16));
        sair.setForeground(Color.WHITE);
        sair.setBackground(new Color(255, 152, 0));
        sair.setMaximumSize(new Dimension(160, 40));

        painelLateral.add(titulo);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 15)));
        painelLateral.add(cadastrar);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 15)));
        painelLateral.add(listar);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 15)));
        painelLateral.add(sair);

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

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (opcao == JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
               
    
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


    public static void main(String[] args) {
        new TelaPrincipal();
    }

}
