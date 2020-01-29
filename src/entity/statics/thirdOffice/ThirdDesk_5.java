package entity.statics.thirdOffice;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

public class ThirdDesk_5 extends StaticEntity {
    private int id;
    public ThirdDesk_5(Handler handler, float x, float y, int id) {
        super(handler, x, y, 130, 107, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 130;
        bounds.height = 107;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.thirdDesk_5, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 130, 107, null);
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
