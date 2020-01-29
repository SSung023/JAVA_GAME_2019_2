package States;

import GFX.ImageLoader;
import main.Handler;
import worlds.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class EndingState extends State {

    private BufferedImage[] ending;
    private int count;

    public EndingState(Handler handler) {
        super(handler);

        count = 0;
        ending = new BufferedImage[3];

        ending[0] = ImageLoader.loadImage("/menu/ending1.png");
        ending[1] = ImageLoader.loadImage("/menu/ending_happy.png");
        ending[2] = ImageLoader.loadImage("/menu/ending_bad.png");
    }

    @Override
    public void tick() {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)){
            if(World.countEnding == 0){
                count++;
                if(count >= 2){
                    count = 0;
                    State.setState(handler.getGame().menuState);
                }
            }
            else if(World.countEnding > 0){
                count += 2;
                if(count >= 3){
                    count = 0;
                    State.setState(handler.getGame().menuState);
                }
            }
        }
        else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)){
                count = 0;
                if(count == 0){
                    count = 0;

                }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ending[count], 0,0,null);
    }
}
