package entity;

import main.Game;
import main.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    //to move smoother
    protected float x, y;
    //to draw images at different sizes
    protected int width, height;

    protected int health;
    public static final int DEFAULT_HEALTH = 10;
    // when return to false, that entity will be disappeared
    protected boolean active = true;

    protected Rectangle bounds;

    //상호작용할 때마다 숫자가 올라가게 설정할 예정
    public int activeNum = 0;


    //set starting position of entity
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFAULT_HEALTH;

        bounds = new Rectangle(0,0, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    //없어지면서 아이템을 떨굼
    public abstract void die();
    //아이템을 주는 상호작용이면 아이템을 줌
    public abstract void interact();
    public abstract boolean isInteract();
    public abstract boolean isHurts();
    public abstract int getId();

    // test code
    public void hurts(int amount){
        health -= amount;
        if(health <= 0){
            active = false;

            activeNum = 1;
            die();

        }
    }

    public void addInventoryItem(){

    }

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        //return ArrayList<Entity> entities
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            //to prevent error
            if(e.equals(this))
                continue;
            //intersects method is return weather it is covered or not
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset))){
                return true;
            }
        }
        return false;
    }

    //set collisionBounds to entity that SOLID
    //return bounding rectangle or area, bounds.width and bounds.height are set when structure called
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int)(x + bounds.x + xOffset),(int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    //GETTERS && SETTERS
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }


}
