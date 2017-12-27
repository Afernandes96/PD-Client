
package ui.gui;

import ThreeinRowCom.MainM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class ServerConnect extends JPanel implements Observer {
    
    MainM model;
    ThreeInRowView frame;
    JLabel label;
    
    JFormattedTextField ipText;
    
    JButton confirm;
    
    public ServerConnect(MainM m,ThreeInRowView frame){
        this.model=m;
        this.frame=frame;
        initComponents();
        
    }
    private void initComponents(){
        label = new JLabel("IP do Servidor:");
        ipText = new JFormattedTextField();
        ipText.setText("Ip no formato 0.0.0.0");
        confirm= new JButton("Confirmar");
  
        label.setLocation(40, 20);
        label.setSize(200, 40);

        ipText.setLocation(40, 60);
        ipText.setSize(200, 40);

        confirm.setLocation(40, 120);
        confirm.setSize(200, 40);  
        
        add(label);
        add(ipText);
        add(confirm);
    }
    
    
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected void listeners() {
         confirm.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {                 
             if (!model.connectManager(ipText.getText())) {
                    JOptionPane.showMessageDialog(frame, "Erro ao conectar ao servidor", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }

             }
         });
    }  
            
}
