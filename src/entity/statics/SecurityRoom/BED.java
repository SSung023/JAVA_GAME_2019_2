package entity.statics.SecurityRoom;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class BED extends StaticEntity {

    private int id;

    public BED(Handler handler, float x, float y, int id) {
        super(handler, x, y, 100, 58, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 100;
        bounds.height = 58;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bed, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 100, 58, null);
    }

    @Override
    public void die() {

    }

    @Override
    public void interact() {
        handler.getWorld().getItemManager().addItem(Item.note3Item.createNew((int)x, (int)(y-100)));
    }

    @Override
    public boolean isInteract() {
        interact();
        return true;
    }

    @Override
    public boolean isHurts() {
        return false;
    }

    @Override
    public int getId() {
        return 24;
    }
}
