package entity.statics.thirdOffice;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

import static tiles.Tile.TILEHEIGHT;
import static tiles.Tile.TILEWIDTH;

public class ThirdDesk_1 extends StaticEntity {

    private int id;

    public ThirdDesk_1(Handler handler, float x, float y, int id) {

        super(handler, x, y, 100, 138, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 100;
        bounds.height = 138;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.thirdDesk_1, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 100, 138, null);
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
