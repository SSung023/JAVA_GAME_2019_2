package entity.statics.Second_Floor;

import GFX.Assets;
import States.GameState;
import States.State;
import entity.creature.Player;
import entity.statics.StaticEntity;
import item.Item;
import main.Handler;
import worlds.World;

import java.awt.*;

public class Final_elevator extends StaticEntity {

    private int id;

    public Final_elevator(Handler handler, float x, float y,int id) {
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
        g.drawImage(Assets.final_elevator, (int)(x- handler.getGameCamera().getxOffset()),
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
        if(Item.isDriver == true && Item.isHeadset == true &&
                (Item.isSSD == true) && Item.isSSD){
            Item.isOpen = true;
            System.out.println("축하해요 한번에 통과했네요 해피 엔딩이겠어요");
            return true;
        }
        else{
            System.out.println("count가 올라갑니다 해피엔딩은 글러먹었네요.");
            World.countEnding++;
            return false;
        }

    }

    @Override
    public int getId() {
        if(Item.isDriver == true && Item.isHeadset == true &&
                (Item.isSSD == true) && Item.isSSD){
            return 33;
        }
        else
            return 34;
    }
}
