package entity.creature;

import GFX.Animation;
import GFX.Assets;
import States.State;
import entity.Entity;
import inventory.Inventory;
import main.Handler;
import tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    //Animation
    private Animation aniDown, aniUp, aniRight, aniLeft,
                    aniStop,
                    aniInteractUp, aniInteractDown, aniInteractRight, aniInteractLeft,
                    aniCrawlUp, aniCrawlDown, aniCrawlRight, aniCrawlLeft,
                    aniStopUp, aniStopDown, aniStopRight, aniStopLeft;

    //Attack Timer
    private long lastAttackTimer, attackCooldown = 400, attackTimer  = attackCooldown;

    //Inventory
    private Inventory inventory;

    //Set starting position of player
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        //customize to the character's image
        bounds.x = 0;
        //bounds.x = 11;
        //bounds.y = 38;
        bounds.y = 5;
        bounds.width = 47;
        bounds.height = 70;

        //Animations 1000 = 1sec
        aniDown = new Animation(400, Assets.player_Down);
        aniUp = new Animation(400, Assets.player_Up);
        aniRight = new Animation(400, Assets.player_Right);
        aniLeft = new Animation(400, Assets.player_Left);

        aniCrawlUp = new Animation(450, Assets.player_crawlUp);
        aniCrawlDown = new Animation(450, Assets.player_crawlDown);
        aniCrawlRight = new Animation(450, Assets.player_crawlRight);
        aniCrawlLeft = new Animation(450, Assets.player_crawlLeft);

        aniInteractDown = new Animation(500, Assets.playerInteractDown);
        aniInteractUp = new Animation(500, Assets.playerInteractUp);
        aniInteractRight = new Animation(500, Assets.playerInteractRight);
        aniInteractLeft = new Animation(500, Assets.playerInteractLeft);

        aniStop = new Animation(10000, Assets.playerStop);
        aniStopUp = new Animation(10000, Assets.playerStopUp);
        aniStopDown = new Animation(10000, Assets.playerStopRight);
        aniStopRight = new Animation(10000, Assets.playerStopDown);
        aniStopLeft = new Animation(10000, Assets.playerStopLeft);

        // Inventory
        inventory = new Inventory(handler);
    }

    @Override
    public void tick() {

        //Animations
        aniDown.tick();
        aniUp.tick();
        aniLeft.tick();
        aniRight.tick();

        aniCrawlDown.tick();
        aniCrawlUp.tick();
        aniCrawlLeft.tick();
        aniCrawlRight.tick();

        aniInteractUp.tick();
        aniInteractDown.tick();
        aniInteractRight.tick();
        aniInteractLeft.tick();

        //Movement
        if(checkOut()){
            State.setState(handler.getGame().endingState);
        }
        getInput() ;
        move();
        handler.getGameCamera().centerOnEntity(this);

        //상호작용인지 공격인지 확인 후 실행
        checkAct();

        //Inventory
        inventory.tick();
    }


    // Check weather the Player go out or not AND set the stage
//    public int checkOut(){
//        // when x position of player over the map, set clear[0] to true
//        //화면 왼쪽으로 나갔을 때
//        if(x < - 80 && x < handler.getWorld().getWidth() * Tile.TILEWIDTH)
//            return 1;
//        //화면 오른쪽으로 나갔을 때
//        if(x > 0 && x > handler.getWorld().getWidth() * Tile.TILEWIDTH){
//            //handler.getWorld().setClear(0);
//            return 2;
//        }
//        //y축으로 나갔을 때
//        return 0;
//    }

    //1층 정문으로 나가는지 확인
    public boolean checkOut(){
        if(x >= 3700 && y >=2800)
            return true;
        else
            return false;

    }

    public boolean checkInVent(){

        //환풍구 안에 있는지 확인
        if(((1180<= x && x <=2400) &&(0<=y && y<=780)) ||((400<= x && x<= 1500)&&(1770<= y && y<= 3000))){
            return true;
        }
        else{
            return false;
        }
    }


    // 상호작용 할지 아니면 때려서 없앨지 확인하고 실행시킴
    // Collision box를 만듬
    public void checkAct(){
        attackTimer +=System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown){
            return;
        }

        //when showing the inventory, don't attack
        if(inventory.isActive())
            return;

        //캐릭터 전체를 감싸는 직사각형을 만들어서 그 범위 안에 들어오면 상호작용을 할 수 있게
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ir = new Rectangle();

        // Collision 박스의 크기를 설정
        int irSize = 5;
        ir.width = 87;
        ir.height = 119;

        // 이 박스는 CollisionBox 를 설정
        if(handler.getKeyManager().interact){
        //if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Z)){
            ir.x = cb.x - 11 - irSize;
            ir.y = cb.y - 38;
        }
        else{
            return;
        }

        attackTimer = 0;

        // Collision Box와 쾅하면 일어나는 현상들
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            //만약 자기 자신이라면 넘긴다
            if(e.equals(this))
                continue;

            //만약 Collision box 와 겹쳤을 때
            if(e.getCollisionBounds(0,0).intersects(ir)){

                //temp code to check Interaction
                // 모든 엔티티를 검사하면서

                //만약 해당 엔티티가 대화창이 나오는 엔티티라면
                if(e.isInteract()){

                    //interact();

                    //MessageManager에서 id에 해당하는 resultLine을 받아서 넣음
                    handler.getWorld().getMessageManager().setResultLine(e.getId());

                    //만약 해당 엔티티가 없어지는 엔티티라면
                }if(e.isHurts()){
                    e.hurts(10);
                }
                return;
            }

        }

    }

    @Override
    public void die() {
        System.out.println("Died");
    }

    @Override
    public void interact() {

    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(inventory.isActive())
            return;

        // 캐릭터 조종
        if(!checkInVent()){
            if(handler.getKeyManager().up){
                if(handler.getKeyManager().ctrl) yMove = -speed+2;
                else
                    yMove = -speed;
            }
            if(handler.getKeyManager().down){
                if(handler.getKeyManager().ctrl) yMove = speed-2;
                else
                    yMove = speed;
            }
            if(handler.getKeyManager().right){
                if(handler.getKeyManager().ctrl) xMove = speed-2;
                else
                    xMove = speed;
            }
            if(handler.getKeyManager().left){
                if(handler.getKeyManager().ctrl) xMove = -speed+2;
                else
                    xMove = -speed;
            }
        }else{
            if(handler.getKeyManager().up){
                yMove = (float) (-speed + 1.5);
            }
            if(handler.getKeyManager().down){
                yMove = (float) (speed - 1.5);
            }
            if(handler.getKeyManager().right){
                xMove = (float) (speed - 1.5);
            }
            if(handler.getKeyManager().left){
                xMove = (float) (-speed + 1.5);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()), width, height, null);

        //to see Collision box
//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }

    public void postRender(Graphics g){
        inventory.render(g);
    }


    //return BufferedImage
    private BufferedImage getCurrentAnimationFrame() {

        // 환풍구가 아닐 때에
        if(!checkInVent()){
            //기어가는 키를 누르면
            if(handler.getKeyManager().ctrl){
                if(xMove < 0){
                    return aniInteractLeft.getCurrentFrame();
                }else if(xMove > 0){
                    return aniInteractRight.getCurrentFrame();
                }

                if(yMove < 0){
                    return aniInteractUp.getCurrentFrame();
                }else{
                    return aniInteractDown.getCurrentFrame();
                }

            }

            else{
                if(xMove < 0){
                    return aniLeft.getCurrentFrame();
                }else if(xMove > 0){
                    return aniRight.getCurrentFrame();
                }
                if(yMove < 0){
                    return aniUp.getCurrentFrame();
                }else{
                    return aniDown.getCurrentFrame();
                }
            }

        }

        //환풍구 안에 있을 때에
        else{
            if(xMove < 0){
                return aniCrawlLeft.getCurrentFrame();
            }else if(xMove > 0){
                return aniCrawlRight.getCurrentFrame();
            }
            if(yMove < 0){
                return aniCrawlUp.getCurrentFrame();
            }else{
                return aniCrawlDown.getCurrentFrame();
            }
        }

    }

    //GETTERS AND SETTERS
    @Override
    public boolean isInteract() {
        return false;
    }
    @Override
    public boolean isHurts() {
        return false;
    }
    @Override
    public int getId() {
        return 0;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
