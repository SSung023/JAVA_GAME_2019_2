package entity.statics.thirdOffice;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class Vent extends StaticEntity {

    private int id;

    public Vent(Handler handler, float x, float y, int id) {
        super(handler, x, y, 100, 100, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 100;
        bounds.height = 100;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.vent, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 100, 100, null);
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
        if(Item.isDriver == false)
            return false;
        else
            return true;
    }

    @Override
    public int getId() {
        if(Item.isDriver == false)
            return 11;
        else
            return 12;
    }
}
