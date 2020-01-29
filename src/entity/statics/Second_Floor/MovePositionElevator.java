package entity.statics.Second_Floor;

import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class MovePositionElevator extends StaticEntity {
    public MovePositionElevator(Handler handler, float x, float y,int id) {
        super(handler, x, y, 145, 172, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void die() {
        try {
            Thread.sleep(200);
            handler.getWorld().getEntityManager().getPlayer().setX(3800);
            handler.getWorld().getEntityManager().getPlayer().setY(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        if(Item.isOpen == true){
            return true;
        }else
            return false;

    }

    @Override
    public int getId() {
        return 39;
    }
}
