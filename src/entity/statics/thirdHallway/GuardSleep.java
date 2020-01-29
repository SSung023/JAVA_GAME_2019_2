package entity.statics.thirdHallway;

import GFX.Assets;
import entity.statics.StaticEntity;
import main.Handler;

import java.awt.*;

public class GuardSleep extends StaticEntity {

    public GuardSleep(Handler handler, float x, float y, int id) {
        super(handler, x, y, 86, 57, id);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 0;
        bounds.height = 0;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.guardSleep, (int)(315- handler.getGameCamera().getxOffset()),
                    (int)(880- handler.getGameCamera().getyOffset()),null);
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
        return 37;
    }
}
