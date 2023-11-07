package Main;

public class SceneChanger {

    GameManager gm;

    public SceneChanger(GameManager gm){

        this.gm = gm;
    }

    public void showScene1(){

        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.messageText.setText("Prepare yourself!");
    }

    public void showScene2(){

        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.messageText.setText("Explore the cave!");
    }
}
