package entity.statics.SecurityRoom;

import GFX.Assets;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class SecurityDoor extends StaticEntity {

    private int id;

    public SecurityDoor(Handler handler, float x, float y, int id) {
        super(handler, x, y, 100, 200, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 100;
        bounds.height = 200;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.securityDoor, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 100, 200, null);
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
        if(Item.isIDcard == true){
            return true;
        }else
            return false;
    }

    @Override
    public int getId() {
        if(Item.isIDcard == false){
            return 16;
        }
        else
            return 17;
    }
}
