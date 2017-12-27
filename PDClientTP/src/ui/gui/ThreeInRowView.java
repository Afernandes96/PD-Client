package three_in_row.ui.gui;

import ThreeinRowCom.MainM;
import three_in_row.logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ThreeInRowView extends JFrame implements Observer
{
    MainM model;
    ObservableGame game;
    ThreeInRowGamePanel panel;
    Login login;
    
    JMenuBar menu;
    JMenu jogo;
    JMenu jogador;
    JMenuItem historico;
    JMenuItem disconnect;
    JMenuItem exit;
    

    public ThreeInRowView(MainM model)
    {
        super("Three in a row");
        
        this.model=model;
         
        game.addObserver(this);
        panel=new ThreeInRowGamePanel(game);

        addComponents();
        initComponents();
        listeners();
        
        setVisible(true);
                
        this.setSize(700, 500);
        setLocation(130, 90);
        this.setMinimumSize(new Dimension(650, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        model.getManager().addObserver(this);
    }
  
    void initComponents(){
        menu = new JMenuBar();
        jogo = new JMenu("Jogo");
        jogador= new JMenu("Perfil");
        
        historico=new JMenuItem("Histórico");
        disconnect = new JMenuItem("Desconectar");
        exit = new JMenuItem("Sair");
        
        jogo.add(disconnect);
        jogo.add(exit);
        
        jogador.add(historico);
        
        menu.add(jogo);
        menu.add(jogador);
        
        setJMenuBar(menu);
   
    }
    
    private void addComponents()
    {
        Container cp=getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(panel,BorderLayout.CENTER);
    }
    
     protected void listeners() {
         exit.addItemListener(new ActionListner(){
             @Override
             public void actionPerformed(ActionEvent e){
                 System.exit(0);
             }
         }
     }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
    
   
}
