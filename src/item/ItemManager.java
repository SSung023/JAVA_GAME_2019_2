package item;

import main.Handler;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {

    private Handler handler;
    private ArrayList<Item> items;

    //temp code
    public static int have = 0;

    public ItemManager(Handler handler){
        this.handler = handler;
        items = new ArrayList<Item>();
    }

    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }

    // Iterator를 하면서 아이템이 있다면 가져와서 tick하고
    // 만일 집어졌다면 아이템 어레이 리스트에서 삭제
    public void tick(){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            i.tick();
            if(i.isPickedUp())
                //will fix when make inventory
                it.remove();
        }
    }

    public void render(Graphics g){
        for(Item i: items){
            //want to set x, y position
            i.render(g);
        }
    }



    // GETTERS AND SETTERS
    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
