package entity.statics.thirdHallway;

import entity.statics.StaticEntity;
import item.Item;
import main.Handler;

import java.awt.*;

public class CCTV_Blocked extends StaticEntity {
    public CCTV_Blocked(Handler handler, float x, float y, int id) {
        super(handler, x, y, 100, 100, id);



    }

    @Override
    public void tick() {
        if(Item.isCCTVon == true){
            bounds.x = 0;
            bounds.y = 0;
            bounds.width = 100;
            bounds.height = 100;
        }
        if(Item.isCCTVon == false){
            bounds.x = 0;
            bounds.y = 0;
            bounds.width = 0;
            bounds.height = 0;
        }
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void die() {

    }

    @Override
    public void interact() {

    }

    @Override
    public boolean isInteract() {
        if(Item.isCCTVon == true){
            return true;
        }else
            return false;
    }

    @Override
    public boolean isHurts() {
        if(Item.isCCTVon == true){
            return false;
        }
        else
            return true;
    }

    @Override
    public int getId() {
        return 28;
    }
}
