package States;

import GFX.Assets;
import GFX.Text;
import entity.Entity;
import main.Handler;
import message.MessageManager;
import worlds.World;

import java.awt.*;

// most used state of game, Actual game play
public class GameState extends State{

    private World world, world1;

   // public static boolean ending = false;

    public GameState(Handler handler){
        super(handler);

        //나중에 통합본
        world = new World(handler,"res/world/world_Final.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
            world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);


        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(new Color(240,232, 240));
        g2d.fillRoundRect(545,540,320,110,20,20);
        //g2d.clearRect(545,540,320,110);
        Text.drawString(g, MessageManager.getResultLine(), 560, 545, false, Color.BLACK, Assets.font18);
    }


}
