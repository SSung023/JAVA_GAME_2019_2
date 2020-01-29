package States;

import GFX.Assets;
import main.Game;
import main.Handler;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;

import java.awt.*;

public class MenuState extends State{

    private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);

        //when we switch states to the game state this UI, it still there
        handler.getMouseManager().setUIManager(uiManager);

        //CREATE MENU BUTTON ******
        // start button
        uiManager.addObject(new UIImageButton(765, 62, 92, 104, Assets.btn_Start, new ClickListener() {
            @Override
            //write code here that call when mouse clicked
            public void onClick() {
                // UNSET the UIManager
                //handler.getMouseManager().setUIManager(null);
                //add new start button
                State.setState(handler.getGame().introState);
            }
        }));
        //how to button
        uiManager.addObject(new UIImageButton(765, 206, 92, 104, Assets.btn_How, new ClickListener() {
            @Override
            public void onClick() {
                // UNSET the UIManager
                handler.getMouseManager().setUIManager(null);
                //add new HOW TO Button
                State.setState(handler.getGame().howToState);
            }
        }));
        //exit button
        uiManager.addObject(new UIImageButton(765, 346, 92, 104, Assets.btn_exit, new ClickListener() {
            @Override
            public void onClick() {
                // UNSET the UIManager
                //handler.getMouseManager().setUIManager(null);
                //add new start button
                System.exit(1);
            }
        }));
    }

    @Override
    public void tick() {

        //switching the screen?
        uiManager.tick();

        // Temporary just go directly to the GameState, skip the menu state!
        //handler.getMouseManager().setUIManager(null);
        //State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
