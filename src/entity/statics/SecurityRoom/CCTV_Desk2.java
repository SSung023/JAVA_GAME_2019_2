package entity.statics.SecurityRoom;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

public class CCTV_Desk2 extends StaticEntity {
    public CCTV_Desk2(Handler handler, float x, float y, int id) {
        super(handler, x, y, 164, 35, id);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 164;
        bounds.height = 12;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.cctvDesk2, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 164, 35, null);
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
