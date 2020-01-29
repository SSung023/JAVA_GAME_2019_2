package States;

import GFX.ImageLoader;
import main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class HowToState extends State {

    private BufferedImage[] howto;
    private int count;

    public HowToState(Handler handler) {
        super(handler);

        count = 0;
        howto = new BufferedImage[2];
        howto[0] = ImageLoader.loadImage("/menu/HOWTO_1.png");
        howto[1] = ImageLoader.loadImage("/menu/HOWTO_2.png");

    }

    @Override
    public void tick() {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)){
            if(count - 1 <= 0){
                count = 0;
            }
            else if(count < 1)
                count--;
        }
        else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)){
            if(count < 2)
                count++;
            if(count == 2){
                count = 0;
                State.setState(handler.getGame().introState);

            }
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(howto[count], 0,0, null);
    }
}
