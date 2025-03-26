package Tela;

import java.awt.*;
import javax.swing.*;

public class CentroEditar extends JPanel{

    CentroEditar(){
        
        setLayout(new BorderLayout(10,10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margens
        setBackground(Color.WHITE);

        JLabel jLabelEditar = new JLabel("Aqui");
        jLabelEditar.setBackground(Color.RED);
        add(jLabelEditar);   
    }
}
