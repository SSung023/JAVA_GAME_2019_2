package entity.statics.thirdOffice;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class Refrigerator extends StaticEntity {

    private int id;

    public Refrigerator(Handler handler, float x, float y, int id) {
        super(handler, x, y, 68, 89, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 68;
        bounds.height = 89;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.refigerator, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 68, 89, null);
    }


    @Override
    public void die() {

    }

    @Override
    public void interact() {
        handler.getWorld().getItemManager().addItem(Item.togetherItem.createNew((int)x+30, (int)y + bounds.height/2));
        Item.isTogether = true;
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
        return id;
    }
}
