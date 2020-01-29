package entity.statics;

import GFX.Assets;
import item.Item;
import main.Handler;
import message.Message;
import message.MessageManager;
import tiles.Tile;

import java.awt.*;

import static tiles.Tile.TILEWIDTH;

public class VentBox extends StaticEntity {

    private int id;


    public VentBox(Handler handler, float x, float y, int id) {
        super(handler, x, y, TILEWIDTH, Tile.TILEHEIGHT, id);
        this.id = id;
        //set rectangle of collision box
        bounds.x = 22;
        bounds.y = 22;
        bounds.width = 63;
        bounds.height = 63;
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        //to set the camera,   rendering it to a proper position
        g.drawImage(Assets.ventBox1, (int)(x- handler.getGameCamera().getxOffset()),
                (int)(y- handler.getGameCamera().getyOffset()), 75, 75, null);
    }

    @Override
    public boolean isInteract() {
        return false;
    }

    @Override
    public boolean isHurts() {
        return true;
    }

    @Override
    public int getId(){
        return id;
    }


    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.driverItem.createNew((int)x, (int)y));
    }

    @Override
    public void interact() {

    }
}
