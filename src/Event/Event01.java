package Event;

import Main.GameManager;

public class Event01 {

    GameManager gm;

    public Event01(GameManager gm){
        this.gm = gm;
    }

    public void inspectWChest() {
        gm.ui.messageText.setText("This is a wooden chest.");
    }
    public void talkWChest() {
        gm.ui.messageText.setText("The chest doesn't answer.");
    }
    public void openWChest() {
        gm.ui.messageText.setText("The chest is empty.");
    }

    public void inspectSkull() {
        gm.ui.messageText.setText("It's a human skull.");
    }
    public void talkSkull() {
        gm.ui.messageText.setText("Dead men tell no tales.");
    }
    public void crushSkull() {
        gm.ui.messageText.setText("You are too weak.");
    }

    public void inspectCave() {
        gm.ui.messageText.setText("It's dark inside the cave...");
    }
    public void talkCave() {
        gm.ui.messageText.setText("You hear your echo from the cave.");
    }
    public void enterCave() {
        gm.ui.messageText.setText("You are not ready yet...");
    }

    public void inspectSStone() {
        gm.ui.messageText.setText("A Sword in a stone?");
    }
    public void talkSStone() {
        gm.ui.messageText.setText("You feel something strange...");
    }
    public void pullSStone() {
        gm.ui.messageText.setText("The sword is stuck, you are too weak...");
    }
}
