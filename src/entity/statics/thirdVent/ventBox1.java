package entity.statics.thirdVent;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class ventBox1 extends StaticEntity {

    private int id;

    public ventBox1(Handler handler, float x, float y, int id) {
        super(handler, x, y, 100, 100, id);
        this.id = id;

        bounds.x = 5;
        bounds.y = 0;
        bounds.width = 100;
        bounds.height = 73;

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
        handler.getWorld().getItemManager().addItem(Item.shotItem.createNew((int)x+20, (int)y - bounds.height+20));
        handler.getWorld().getItemManager().addItem(Item.note2Item.createNew((int)x+30, (int)y - bounds.height+10));
        Item.isShot = true;
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
        return 13;
    }
}
