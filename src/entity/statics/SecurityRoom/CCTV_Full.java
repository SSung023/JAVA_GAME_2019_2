package entity.statics.SecurityRoom;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class CCTV_Full extends StaticEntity {
    public CCTV_Full(Handler handler, float x, float y, int id) {
        super(handler, x, y, 248, 109, id);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 248;
        bounds.height = 93;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.cctvFull, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 248, 109, null);
    }

    @Override
    public void die() {
        Item.isCCTVon = false;
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
        return 20;
    }
}
