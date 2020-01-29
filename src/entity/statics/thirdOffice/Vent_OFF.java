package entity.statics.thirdOffice;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

//없어지는 환풍구
public class Vent_OFF extends StaticEntity {

    private int id;

    public Vent_OFF(Handler handler, float x, float y, int id) {
        super(handler, x, y,   100, 100, id);
        this.id = id;

        bounds.x  = 0;
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
        return true;
    }

    @Override
    public int getId() {
        return id;
    }
}
