package entity.statics.thirdHallway;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class Hammer extends StaticEntity {

    private int id;

    public Hammer(Handler handler, float x, float y, int id) {
        super(handler, x, y, 100, 100, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 72;
        bounds.height = 20;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.hammer, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 80, 80, null);
    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.hammerItem.createNew((int)x-10, (int)y+10));
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
        return 25;
    }
}
