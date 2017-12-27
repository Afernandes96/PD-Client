/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import ThreeinRowCom.MainM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;


/**
 *
 * @author Nawie
 */
public class Login extends JPanel implements Observer {
    
    MainM model;
    ThreeInRowView frame;
    
    JLabel name;
    JLabel pass;
    JTextField userText;
    JTextField passText;
    JButton loginB;
    JButton registoB;
    Register registoDialog;
    
    
    public Login(MainM model,ThreeInRowView frame){
         this.model = model;
        this.frame = frame;
        
        initComponents();
        listeners(this);
        
        setLayout(null);
        setLocation(0, 0);
        setSize(1430, 865);
        
//                registerDialog = new RegisterDialog(model);
//        registerDialog.setLocationRelativeTo(frame);
           
        model.getManager().addObserver(this);
    }

    private void initComponents(){
        
        name = new JLabel("Username:");
        userText = new JTextField();
        pass = new JLabel("Password:");
        passText = new JTextField();
        loginB = new JButton("Login");
        registoB = new JButton("Registo");
        name.setLocation(50, 40);
        name.setSize(200, 40);
 
        userText.setLocation(50, 80);
        userText.setSize(200, 40);
        
        pass.setLocation(50, 140);
        pass.setSize(200, 40);

        passText.setLocation(50, 180);
        passText.setSize(200, 40);
        
        loginB.setLocation(50, 250);
        loginB.setSize(200, 40);
        
        registoB.setLocation(50, 300);
        registoB.setSize(200, 40);
        
        add(name);
        add(userText);
        add(pass);
        add(passText);
        add(loginB);
        add(registoB);
        
    }
    
        private void listeners(Login panel) {
        loginB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //model.getManager().login(userText.getText(), passText.getText());
                System.out.println("Login: " + userText.getText() + ":" + passText);
            }
        });
        
        registoB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!registoDialog.isVisible()) {
                    registoDialog.setLocationRelativeTo(panel);
                    registoDialog.setVisible(true);
                }
            }
            
        });
    }
     
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

