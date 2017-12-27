/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import ThreeinRowCom.Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Nawie
 */
public class Login extends JPanel implements Observer {
    Main model;
    ThreeInRowView frame;
    
    JLabel ipLabel;
    MaskFormatter ipFormatter;
    JFormattedTextField ipField;
    
    JLabel usernameLabel;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    
    JButton loginButton;
    JButton registerButton;
    
    ImageIcon imageIcon;
    JLabel imageLabel;
    
    //RegisterDialog registerDialog;
    //ServerIPDialog ipDialog;
    
    public Login(Main model, ThreeInRowView frame) {
        this.model = model;
        this.frame = frame;
        
        createComponents();
        setupComponents();
        addComponents();
        listeners(this);
        
        setLayout(null);
        setLocation(0, 0);
        setSize(1430, 865);
        setBackground(Color.DARK_GRAY);
        
        //ipDialog = new ServerIPDialog(model, frame);
        //registerDialog = new RegisterDialog(model);
        //registerDialog.setLocationRelativeTo(frame);
        //ipDialog.setAlwaysOnTop(true);
        //ipDialog.setLocationRelativeTo(frame);        
        //ipDialog.setVisible(true);
        
        //model.mng().addObserver(this);
    }
    
    private void createComponents() {
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
           
       // try {
            imageIcon = new ImageIcon(ImageIO.read(Resources.getResourceFile("images/logo.png")).getScaledInstance(300, 300, Image.SCALE_SMOOTH));
            imageLabel = new JLabel(imageIcon);
//        } catch (IOException ex) {
//            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    private void setupComponents() {
        usernameLabel.setForeground(new Color(240, 240, 240));
        usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        usernameLabel.setLocation(50, 40);
        usernameLabel.setSize(200, 40);
        
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(239, 239, 239), 1));
        usernameField.setFont(new Font("Calibri", Font.PLAIN, 18));
        usernameField.setLocation(50, 80);
        usernameField.setSize(200, 40);
        
        passwordLabel.setForeground(new Color(240, 240, 240));
        passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        passwordLabel.setLocation(50, 140);
        passwordLabel.setSize(200, 40);
        
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(239, 239, 239), 1));
        passwordField.setFont(new Font("Calibri", Font.PLAIN, 18));
        passwordField.setLocation(50, 180);
        passwordField.setSize(200, 40);
        
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 16));
        loginButton.setBackground(new Color(50, 50, 50));
        loginButton.setForeground(new Color(240, 240, 240));
        loginButton.setLocation(50, 250);
        loginButton.setSize(200, 40);
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(239, 239, 239)));
        loginButton.setBorderPainted(true);
        
        registerButton.setFont(new Font("Calibri", Font.PLAIN, 16));
        registerButton.setBackground(new Color(50, 50, 50));
        registerButton.setForeground(new Color(240, 240, 240));
        registerButton.setLocation(50, 300);
        registerButton.setSize(200, 40);
        registerButton.setBorder(BorderFactory.createLineBorder(new Color(239, 239, 239)));
        registerButton.setBorderPainted(true);
        
        imageLabel.setSize(300, 300);
        imageLabel.setLocation(320, 58);
    }
    
    private void addComponents() {
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);
        add(imageLabel);
    }
    
    private void listeners(Login lp) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passText = new String(passwordField.getPassword());
                //model.mng().login(usernameField.getText(), passText);
                System.out.println("Login: " + usernameField.getText() + ":" + passText);
            }
        });
        
//        registerButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!registerDialog.isVisible()) {
//                    registerDialog.setLocationRelativeTo(lp);
//                    registerDialog.setVisible(true);
//                }
//            }
//            
//        });
    }
    
    @Override
    public void update(Observable o, Object arg) {
//        if (model.mng().isLoggedIn()) {
//            setVisible(false);
//            System.out.println("Connected");
//        }
//        else {
//            frame.setSize(700, 450);
//            setVisible(true);
//            System.out.println("Not Connected");
//        }
    }
    
}
