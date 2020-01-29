package entity;

import entity.creature.Player;
import entity.statics.thirdHallway.GuardSleep;
import main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {

    private Handler handler;
    private Player player;
    //player also should be one of the entities List
    // ArrayList allows to add things what ever we want to
    private ArrayList<Entity> entities;
    private int id;

    public static boolean isSleep = false;

    //compare two entity and compare
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {

            //return -1 A should be rendered before B
            //by adding getHeight it would be rendered right
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };



    //아예 생성자에 아이디를 받아놓고, getID로 받는것 어때
    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    public void tick(){
        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()){
            Entity e = it.next();
            e.tick();
            if(!e.isActive()){
                it.remove();
            }
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics g){

        player.render(g);
        ///////////////////

        for(Entity e: entities){
            e.render(g);
        }

        player.postRender(g);
    }

    //add things to Entity
    public void addEntity(Entity e) {
        entities.add(e);

    }


    //GETTERS and SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }


}
