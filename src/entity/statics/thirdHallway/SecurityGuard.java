package entity.statics.thirdHallway;

import GFX.Assets;
import entity.Entity;
import entity.EntityManager;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;
import java.awt.*;

public class SecurityGuard extends StaticEntity {

    private int id;
    private boolean isIdCard;

    public SecurityGuard(Handler handler, float x, float y, int id) {
        super(handler, x, y, 47, 79, id);
        this.id = id;
        isIdCard = false;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 47;
        bounds.height = 79;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.securityGuard, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 47, 79, null);



    }


    @Override
    public void die() {
        //item.getCount()
        handler.getWorld().getItemManager().addItem(Item.IDcardItem.createNew((int)x+80, (int)y+50));
        Item.isIDcard = true;
        System.out.println("ID카드를 얻음");
        EntityManager.isSleep = true;
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
        if(Item.isShot == true){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public int getId() {
        if(Item.isShot == true){
            return 19;
        }
        else{
            return 36;
        }
    }
}
