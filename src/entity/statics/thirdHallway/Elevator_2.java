package entity.statics.thirdHallway;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

public class Elevator_2 extends StaticEntity {

    private int id;

    public Elevator_2(Handler handler, float x, float y, int id) {
        super(handler, x, y, 145, 172, id);
        this.id = id;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 145;
        bounds.height = 172;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.elevator_2, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 145, 172, null);
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
        return false;
    }

    @Override
    public int getId() {
        return id;
    }
}
