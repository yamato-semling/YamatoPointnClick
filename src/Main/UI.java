package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI {

    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    // PLAYER UI
    JPanel lifePanel;
    JLabel lifeLabel[] = new JLabel[6];

    JPanel inventoryPanel;
    public JLabel swordLabel, shieldLabel, lanternLabel;

    public UI(GameManager gm){

        this.gm = gm;

        createMainField();
        generateScene();

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
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,700,350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
        bgLabel[bgNum].setIcon(bgIcon);

    }
    public void createObject(int bgNum, int objx, int oby, int objWidth, int objHeight, String objFileName, String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command){

        // CREATE POP MENU
        JPopupMenu popupMenu = new JPopupMenu();

        // CREATE POP MENU ITEMS
        JMenuItem menuItem[] = new JMenuItem[4];
        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(choice1Command);
        popupMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(choice2Command);
        popupMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(choice3Name);
        menuItem[3].addActionListener(gm.aHandler);
        menuItem[3].setActionCommand(choice3Command);
        popupMenu.add(menuItem[3]);

        // CREATE OBJECTS
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx,oby,objWidth,objHeight);
        //objectLabel.setOpaque(true);
        //objectLabel.setBackground(Color.red);

        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)){
                    popupMenu.show(objectLabel, e.getX(), e.getY());
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        bgPanel[bgNum].add(objectLabel);

    }

    public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {

        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));

        JButton arrowButton = new JButton();
        arrowButton.setBounds(x,y,width,height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.setBorderPainted(false);
        arrowButton.addActionListener(gm.aHandler);
        arrowButton.setActionCommand(command);

        bgPanel[bgNum].add(arrowButton);
    }

    public void generateScene(){

        // SCENE 1
        createBackground(1,"forest.png");
        createObject(1,420,250,120,85, "woodenChest.png", "Inspect", "Talk", "Open", "inspectWChest", "talkWChest", "openWChest");
        createObject(1,140,250,60,60, "skull2.png", "Inspect", "Talk", "Crush", "inspectSkull", "talkSkull", "crushSkull");

        createArrowButton(1,0,150,64,64,"larrow.png","goScene2");

        bgPanel[1].add(bgLabel[1]);

        // SCENE 2
        createBackground(2,"caveEntrance.png");
        createObject(2,420,250,120,85, "woodenChest.png", "Inspect", "Talk", "Open", "inspectWChest", "talkWChest", "openWChest");
        createObject(2,0,80,140,630, "woodenChest.png", "Inspect", "Talk", "Enter", "inspectCave", "talkCave", "enterCave");
        createObject(2,300,200,100,200,"sword-stone2.png","Inspect","Talk","Pull","inspectSStone","talkSStone","pullSStone");

        createArrowButton(2,640,150,64,64,"rarrow.png","goScene1");

        bgPanel[2].add(bgLabel[2]);
    }
}
