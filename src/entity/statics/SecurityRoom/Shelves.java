package entity.statics.SecurityRoom;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class Shelves extends StaticEntity {

    private int id;

    public Shelves(Handler handler, float x, float y, int id) {
        super(handler, x, y, 85, 75, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 85;
        bounds.height = 15;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.shelves, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 85, 75, null);
    }

    @Override
    public void die() {

    }

    @Override
    public void interact() {
        handler.getWorld().getItemManager().addItem(Item.headsetItem.createNew((int)x, (int)y + bounds.height/2));
        Item.isHeadset = true;
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
        return 21;
    }
}
