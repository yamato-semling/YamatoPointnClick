package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    GameManager gm;

    public ActionHandler(GameManager gm){

        this.gm = gm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String yourChoice = e.getActionCommand();

        switch(yourChoice) {
            case "inspectWChest":
                gm.ev1.inspectWChest();
                break;
            case "talkWChest":
                gm.ev1.talkWChest();
                break;
            case "openWChest":
                gm.ev1.openWChest();
                break;
            case "inspectSkull":
                gm.ev1.inspectSkull();
                break;
            case "talkSkull":
                gm.ev1.talkSkull();
                break;
            case "crushSkull":
                gm.ev1.crushSkull();
                break;
            case "inspectCave":
                gm.ev1.inspectCave();
                break;
            case "talkCave":
                gm.ev1.talkCave();
                break;
            case "enterCave":
                gm.ev1.enterCave();
                break;
            case "goScene1":
                gm.sChanger.showScene1();
                break;
            case "goScene2":
                gm.sChanger.showScene2();
                break;
            case "inspectSStone":
                gm.ev1.inspectSStone();
                break;
            case "talkSStone":
                gm.ev1.talkSStone();
                break;
            case "pullSStone":
                gm.ev1.pullSStone();
                break;
            default:
                break;
        }

    }
}
