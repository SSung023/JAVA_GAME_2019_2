package entity.statics.thirdOffice;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

public class ThirdDesk_6 extends StaticEntity {
    private int id;

    public ThirdDesk_6(Handler handler, float x, float y, int id) {
        super(handler, x, y, 129, 66, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 129;
        bounds.height = 66;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.thirdDesk_6, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 129, 66, null);
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
