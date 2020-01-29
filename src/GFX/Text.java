package GFX;

import java.awt.*;

public class Text {

    public static void drawString(Graphics g, String text, int xPos, int yPos, boolean center, Color c, Font font){
        g.setColor(c);
        g.setFont(font);

        //the coordinate to the left top corner &
        int x = xPos;
        int y = yPos;

        //if not centered draw will be point left bottom corner
        //if centered point will be middle
        if(center){
            FontMetrics fm = g.getFontMetrics(font);
            x = xPos - fm.stringWidth(text) / 2;
            y = (yPos - fm.getHeight() / 2) + fm.getAscent();
        }

        //temp
        for(String line : text.split("\n")){
            g.drawString(line, x, y += 20);
        }

        //g.drawString(text, x, y);
    }
}
