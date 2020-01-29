package GFX;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x*47, y*79, width, height);
        //return sheet.getSubimage(x, y, width, height);
    }

    public BufferedImage cropBackground(int x, int y, int width, int height){
        return sheet.getSubimage(x*100, y*100, width, height);
    }


}
