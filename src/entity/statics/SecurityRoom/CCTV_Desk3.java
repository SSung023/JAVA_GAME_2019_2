package entity.statics.SecurityRoom;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

public class CCTV_Desk3 extends StaticEntity {
    public CCTV_Desk3(Handler handler, float x, float y, int id) {
        super(handler, x, y, 50, 169, id);

        bounds.x = 5;
        bounds.y = 0;
        bounds.width = 45;
        bounds.height = 169;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.cctvDesk3, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 50, 169, null);
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
