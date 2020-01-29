package States;

import GFX.ImageLoader;
import main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

//intro 만화를 그리기 위해 임시로 적은 클래스
public class IntroState extends State{

    private BufferedImage[] intro;
    private int count;

    public IntroState(Handler handler) {
        super(handler);

        count = 0;
        intro = new BufferedImage[4];

        intro[0] = ImageLoader.loadImage("/menu/intro1.png");
        intro[1] = ImageLoader.loadImage("/menu/intro2.png");
        intro[2] = ImageLoader.loadImage("/menu/intro3.png");
        intro[3] = ImageLoader.loadImage("/menu/intro4.png");
    }

    @Override
    public void tick() {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)){
            if(count - 1 <= 0){
                count = 0;
            }
            else if(count < 4)
                count--;
        }
        else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)){
            if(count < 4)
                count++;
            if(count >= 4){
                count = 0;
                //State.setState(handler.getGame().menuState);
                State.setState(handler.getGame().gameState);

            }

        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(intro[count], 0,0,null);


    }
}
