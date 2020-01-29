package entity.statics.Second_Floor;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

public class Door extends StaticEntity {

    private int id;

    public Door(Handler handler, float x, float y, int id) {
        super(handler, x, y, 65, 100, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 65;
        bounds.height = 100;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.door2, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 65, 100, null);
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
        return id;
    }
}
