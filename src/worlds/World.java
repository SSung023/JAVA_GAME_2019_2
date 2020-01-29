package worlds;

import GFX.Assets;
import entity.Entity;
import entity.EntityManager;
import entity.creature.Player;
import entity.statics.*;
import entity.statics.Second_Floor.*;
import entity.statics.SecurityRoom.*;
import entity.statics.thirdHallway.*;
import entity.statics.thirdOffice.*;
import entity.statics.thirdVent.ventBox1;
import item.ItemManager;
import main.Handler;
import message.MessageManager;
import tiles.Tile;
import utils.Utils;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class World {

    private Handler handler;
    //size of the map
    private int width, height;
    private int spawnX, spawnY;

    public static int countEnding = 0;

    // store all of the tiles in every single position & using tile's id
    private int[][] tiles;

    //ENTITY
    private EntityManager entityManager;

    //Item
    private ItemManager itemManager;

    // 대화창
    private MessageManager messageManager;



    public EntityManager getEntityManager() {
        return entityManager;
    }

    //CREATE ENTITY TO SHOW TO THE WORLD
    public World(Handler handler, String path){
        this.handler = handler;

        // create handler, set the location
        entityManager = new EntityManager(handler, new Player(handler,200,200));
        itemManager = new ItemManager(handler);
        messageManager = new MessageManager(handler);

        // temporary entity code HERE
        setEntity();

        loadWorld(path);

        // set player to the position(reading from world.txt file)
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void tick(){
        itemManager.tick();
        entityManager.tick();

    }

    // 각 층마다 고유의 Entity를 배치
    public void setEntity(){

        //3층 사무실
        //
        //entityManager.addEntity(new VentBox(handler,1800,900, 19));
        //
        entityManager.addEntity(new deskMine(handler,1866, 1092, 7));
        entityManager.addEntity(new Vent(handler, 2000, 700, 11));
        //entityManager.addEntity(new Vent(handler, 2000, 700, 11));
        entityManager.addEntity(new ThirdDesk_1(handler, 1986, 1020,1));
        entityManager.addEntity(new ThirdDesk_2(handler, 1607, 1002,4));
        entityManager.addEntity(new ThirdDesk_3(handler, 1737, 1004,3));
        entityManager.addEntity(new ThirdDesk_4(handler, 1866, 1008,2));
        entityManager.addEntity(new ThirdDesk_5(handler, 1607, 1092,5));
        entityManager.addEntity(new ThirdDesk_6(handler, 1737, 1092,6));

        entityManager.addEntity(new Refrigerator(handler, 1916, 809, 9));

        // 3층 환풍구
        entityManager.addEntity(new ventBox1(handler,2000,120,13));

        //3층 복도
        entityManager.addEntity(new Elevator_2(handler,1009, 528, 15));
            // 경비원은 마취침을 맞고 쓰러진다
        //entityManager.addEntity(new SecurityGuard(handler,332,880, 19));
        entityManager.addEntity(new SecurityGuard(handler,332,827, 19));
        entityManager.addEntity(new SecurityDoor(handler, 700, 700, 17));

        //3층 경비실
            // ID card 가 없으면 16, 있으면 17
        entityManager.addEntity(new CCTV_Full(handler, 705, 433,20));
        entityManager.addEntity(new CCTV_Desk1(handler, 861, 549, 0));
        entityManager.addEntity(new CCTV_Desk2(handler, 769, 514, 0));
        entityManager.addEntity(new CCTV_Desk3(handler, 933, 514, 0));
        entityManager.addEntity(new Reader(handler, 637, 843, 17));
        entityManager.addEntity(new BED(handler,600,625,24));
        entityManager.addEntity(new Shelves(handler,609, 500, 21));
        entityManager.addEntity(new Letter(handler,939, 552,22));


        entityManager.addEntity(new Hammer(handler, 310, 2100, 25));
        entityManager.addEntity(new StairCCTV(handler, 200, 1300,0));
        entityManager.addEntity(new CCTV_Blocked(handler, 300, 1300, 28));

        //2층 복도
        entityManager.addEntity(new Breakable_wall(handler,700,2900,26));
        entityManager.addEntity(new Door_talk(handler,1635, 3000, 27));
        entityManager.addEntity(new Door(handler,2135,3000,27));
        entityManager.addEntity(new Final_elevator(handler,700, 1428, 32));
        entityManager.addEntity(new MazeExit(handler,1000,1800, 31));

        entityManager.addEntity(new MazeBox1(handler, 715,2120, 0));
        entityManager.addEntity(new MazeBox2(handler, 1215, 2620,0));

        entityManager.addEntity(new DontGo(handler,2500, 1600, 28));
        entityManager.addEntity(new DontGo(handler,2500, 3100, 28));

        entityManager.addEntity(new MovePositionElevator(handler, 700,1428,0));



    }



    public void render(Graphics g){

        //limit the area that draw images
        //return larger num & smaller num
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH); //the tile that user can currently see on the far left of the screen
        int xEnd = (int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int)Math.min(width, (handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.TILEHEIGHT + 1);

        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart; x< xEnd; x++){
                getTile(x, y).render(g, (int)(x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int)(y*Tile.TILEHEIGHT- handler.getGameCamera().getyOffset()));
            }
        }
        //Items
        itemManager.render(g);

        //Entities
        entityManager.render(g);

//        if(EntityManager.isSleep == true){
////            g.drawImage(Assets.guardSleep, (int)(315- handler.getGameCamera().getxOffset()),
////                    (int)(880- handler.getGameCamera().getyOffset()),null);
//            entityManager.addEntity(new GuardSleep(handler,315,880, 37));
//        }

    }

    public Tile getTile(int x, int y){

        //To prevent error
        if(x < 0 || y < 0 ||x >= width || y >= height)
            return Tile.i0Tiles;


        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null){
            return Tile.i0Tiles;
        }
        return t;
    }

    //get world data from file
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        //split the map
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        // save the map into tiles array
        tiles = new int[width][height];
        for(int y = 0; y<height; y++){
            for(int x = 0; x<width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }

    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }
    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }
    public void setMessageManager(MessageManager messageManager) {
        this.messageManager = messageManager;
    }


}
