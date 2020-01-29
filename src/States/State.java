package States;

import main.Game;
import main.Handler;

import java.awt.*;

public abstract class State {
    // is going to hold what state we currently want to tick and render in our game
    private static State currentState = null;

    // is going to change what state the game currently ticks and renders and basically shows to the screen
    public static void setState(State state){
        currentState = state;
    }

    //return what state we are
    public static State getState(){
        return currentState;
    }

    //CLASS

    protected Handler handler;

    public State(Handler handler){
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
