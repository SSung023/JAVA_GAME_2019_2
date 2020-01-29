package entity.statics.thirdOffice;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class deskMine extends StaticEntity {
    private  int id;

    //안없어지고 아이템 뱉는 구조 만들어야됨
    public deskMine(Handler handler, float x, float y, int id) {
        super(handler, x, y, 120, 66, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 120;
        bounds.height = 70;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.deskMine, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 120, 66, null);
    }

    @Override
    public void die() {

    }

    @Override
    public void interact() {
        handler.getWorld().getItemManager().addItem(Item.driverItem.createNew((int)x, (int)y + bounds.height/2));
        handler.getWorld().getItemManager().addItem(Item.note1Item.createNew((int)x, (int)y + bounds.height/2));
        Item.isDriver = true;
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
