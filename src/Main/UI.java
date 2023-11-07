package Main;

import javax.swing.*;
import java.awt.*;

public class UI {

    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    public UI(GameManager gm){

        this.gm = gm;

        createMainField();
        generateScreen();

        window.setVisible(true);
    }

    public void createMainField() {

        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        messageText = new JTextArea("THIS IS A SAMPLE TEXT");
        messageText.setBounds(50,410, 700, 150);
        messageText.setBackground(Color.BLACK);
        messageText.setForeground(Color.WHITE);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        window.add(messageText);
    }
    public void createBackground(int bgNum, String bgFileName) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50,70,700,350);
        bgPanel[bgNum].setBackground(Color.BLACK);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[1]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,700,350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
        bgLabel[bgNum].setIcon(bgIcon);

    }
    public void createObject(int bgNum, int objx, int oby, int objWidth, int objHeight, String objFileName){

        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx,oby,objWidth,objHeight);

        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
        objectLabel.setIcon(objectIcon);

        bgPanel[bgNum].add(objectLabel);

        bgPanel[bgNum].add(bgLabel[1]);
    }

    public void generateScreen(){

        // SCREEN1
        createBackground(1,"forest.png");
        createObject(1,420,250,120,85, "woodenChest.png");
        createObject(1,140,250,60,60, "skull2.png");
    }
}
