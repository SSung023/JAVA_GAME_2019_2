package entity.statics.SecurityRoom;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

public class Letter extends StaticEntity {

    private int id;

    public Letter(Handler handler, float x, float y,int id) {
        super(handler, x, y, 34, 53, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 34;
        bounds.height = 53;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.diary, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 34, 53, null);
    }

    @Override
    public void die() {

    }

    @Override
    public void interact() {

    }

    @Override
    public boolean isInteract() {
        return false;
    }

    @Override
    public boolean isHurts() {
        return false;
    }

    @Override
    public int getId() {
        return 0;
    }
}
