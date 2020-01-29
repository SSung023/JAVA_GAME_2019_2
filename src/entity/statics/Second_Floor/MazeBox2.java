package entity.statics.Second_Floor;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class MazeBox2 extends StaticEntity {

    private int id;

    public MazeBox2(Handler handler, float x, float y, int id) {
        super(handler, x, y, 100, 100, id);
        this.id = id;

        bounds.x = 10;
        bounds.y = 10;
        bounds.width = 63;
        bounds.height = 63;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.ventBox1, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 75, 75, null);
    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.nutellarItem.createNew((int)x-25, (int)y-55));
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
        return 29;
    }
}
