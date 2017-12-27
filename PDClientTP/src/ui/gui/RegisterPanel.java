/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import ThreeinRowCom.MainM;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author afrl1
 */
public class RegisterPanel extends JPanel implements Observer{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    MainM model;

    JLabel nameLabel;
    JTextField nameField;
    JLabel usernameLabel;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;

    JButton registerButton;

    public RegisterPanel(MainM model) {
        this.model = model;
        
        createComponents();
        setupComponents();
        addComponents();
        listeners();

    }

    private void createComponents() {
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        registerButton = new JButton("Register");
    }

    private void setupComponents() {
        nameLabel.setLocation(40, 20);
        nameLabel.setSize(200, 40);

        nameField.setLocation(40, 60);
        nameField.setSize(200, 40);

        usernameLabel.setLocation(40, 100);
        usernameLabel.setSize(200, 40);

        usernameField.setLocation(40, 140);
        usernameField.setSize(200, 40);

        passwordLabel.setLocation(40, 180);
        passwordLabel.setSize(200, 40);

        passwordField.setLocation(40, 220);
        passwordField.setSize(200, 40);
        
        registerButton.setLocation(40, 280);
        registerButton.setSize(200, 40);
    }

    private void addComponents() {
        add(nameLabel);
        add(nameField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);        
    }

    private void listeners() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passText = new String(passwordField.getPassword());
                if (!model.getManager().signUp(nameField.getText(),
                        usernameField.getText(), passText)) {
                    JOptionPane.showMessageDialog(
                            null, "Account already registered", "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(
                            null, "Successful Registration", "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                }

            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
