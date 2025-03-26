package Tela;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CentroCadastro extends JPanel{

    CentroCadastro(){
        setLayout(new BorderLayout(10,10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margens
        setBackground(Color.WHITE);

        JLabel jLabel = new JLabel("Teste");
        add(jLabel);


    }



    }

