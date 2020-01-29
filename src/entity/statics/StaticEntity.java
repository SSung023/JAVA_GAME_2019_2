package entity.statics;

import entity.Entity;
import main.Handler;


//the class for the object that don't move
public abstract class StaticEntity extends Entity {

    private int id;

    //handler x좌표 y좌표, 너비, 높이, Static Entity의 고유 번호, 상호작용을 했는지 안했는지
    public StaticEntity(Handler handler, float x, float y, int width, int height, int id){
        super(handler, x, y, width, height);
        this.id = id;
        //to check this Entity show message or not
    }

}
