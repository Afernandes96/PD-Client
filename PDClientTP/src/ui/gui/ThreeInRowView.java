package three_in_row.ui.gui;

import ThreeinRowCom.MainM;
import three_in_row.logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JMenuBar;


public class ThreeInRowView extends JFrame implements Observer
{
    MainM model;
    ObservableGame game;
    ThreeInRowGamePanel panel;
    Login login;
    
    JMenuBar

    public ThreeInRowView(ObservableGame j)
    {
        super("Three in a row");

        game = j;            
        game.addObserver(this);
        panel=new ThreeInRowGamePanel(game);

        addComponents();
 
        setVisible(true);
        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(650, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }
  
    
    private void addComponents()
    {
        Container cp=getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(panel,BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
    
   
}
