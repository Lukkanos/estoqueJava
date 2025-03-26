package Tela;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CentroListar extends JPanel{

    CentroListar(){
    	
        setLayout(new BorderLayout(10,10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margens
        setBackground(Color.WHITE);

        String[] colunas = {"ID","Nome","Descrição","Quantidade","Preço"};
        Object[][] dados = {
            {"", "", "", "", ""}
        };

        JTable tabela = new JTable(dados,colunas);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

}

