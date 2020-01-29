package main;

import GFX.GameCamera;
import entity.EntityManager;
import input.KeyManager;
import input.MouseManager;
import message.MessageManager;
import worlds.World;

//get everything though this handler
public class Handler {

    private Game game;
    private World world;


    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }

    public World getWorld() {
        return world;
    }
    public void setWorld(World world) {
        this.world = world;
    }

    public Handler(Game game){
        this.game = game;
    }

}
