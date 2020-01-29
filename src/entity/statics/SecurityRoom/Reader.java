package entity.statics.SecurityRoom;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class Reader extends StaticEntity {

    private int id;

    public Reader(Handler handler, float x, float y,  int id) {
        super(handler, x, y, 29, 22, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 29;
        bounds.height = 50;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.cardReader, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 29, 22, null);
    }

    @Override
    public void die() {

    }

    @Override
    public void interact() {

    }

    @Override
    public boolean isInteract() {
        return true;
    }

    @Override
    public boolean isHurts() {
        return false;
    }

    @Override
    public int getId() {
        if(Item.isIDcard == false){
            return 16;
        }
        else
            return 17;

    }
}
