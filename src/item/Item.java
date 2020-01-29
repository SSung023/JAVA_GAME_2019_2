package item;

import GFX.Assets;
import GFX.ImageLoader;
import main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Item {

    // Handler
    public static Item[] items = new Item[256];
    public static Item driverItem = new Item(Assets.driver, "driver", 0);
    public static Item hammerItem = new Item(Assets.hammer, "Hammer", 1);
    public static Item headsetItem = new Item(Assets.headset, "Headset", 2);
    public static Item IDcardItem = new Item(Assets.IDcard, "ID card", 3);
    public static Item note1Item = new Item(Assets.note1, "note 1", 4);
    public static Item note2Item = new Item(Assets.note2, "note 2", 5);
    public static Item note3Item = new Item(Assets.note3, "note 3", 6);
    public static Item nutellarItem = new Item(Assets.nutellar, "Nutellar", 7);
    public static Item shotItem = new Item(Assets.shot, "Go SLEEP shot", 8);
    public static Item SSDItem = new Item(Assets.SSD, "SSD", 9);
    public static Item togetherItem = new Item(Assets.together, "togeder Icecream", 10);

    // 아이템의 유무, 있으면 true, 없으면 false
    public static boolean isDriver = false, isSSD = false, isIDcard = false, isHeadset = false,
                            isTogether = false, isShot = false, isOpen = false;

    // CCTV의 켜짐 유무
    public static boolean isCCTVon = true;



    //CLASS
    public static final int ITEMWIDTH = 50, ITEMHEIGHT = 50;

    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;

    protected Rectangle bounds;

    protected int x, y, count;
    protected boolean pickedUp = false;

    public Item(BufferedImage texture, String  name, int id){
        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;

        bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);


        items[id] = this;

    }



    public void tick(){
        //플레이어의 rectangle과 아이템의 rectangle이 겹치면 아이템을 먹을 수 있다.
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)){
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }
    }

    // to show item in the inventory
    public void render(Graphics g){
        //예외 처리
        if(handler == null){
            return;
        }

        //render on the ground
        render(g, (int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()));
    }

    //to render to the screen that we want to, on the ground
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, (x+ITEMWIDTH-(ITEMWIDTH/2)), (y+ITEMHEIGHT+20), ITEMWIDTH, ITEMHEIGHT, null);
    }

    //copy the same texture and set to this item
    // 바로 인벤토리 창에 넣음
    public Item createNew(int count){
        //test code
        Item i = new Item(texture, name, id);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }

    public Item createNew(int x, int y){
        Item i = new Item(texture, name, id);
        i.setPosition(x, y);
        return i;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;

        bounds.x = x;
        bounds.y = y;
    }


    //GETTER AND SETTER

    public boolean isPickedUp() {
        return pickedUp;
    }
    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }
    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
