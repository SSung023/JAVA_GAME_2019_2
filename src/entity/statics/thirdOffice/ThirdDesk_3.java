package entity.statics.thirdOffice;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

public class ThirdDesk_3 extends StaticEntity {

    private int id;

    public ThirdDesk_3(Handler handler, float x, float y, int id) {
        super(handler, x, y, 129, 88, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 129;
        bounds.height = 88;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.thirdDesk_3, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 129, 88, null);
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
        return id;
    }
}
