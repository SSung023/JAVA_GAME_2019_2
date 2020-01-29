package tiles.elevator;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i91Tile extends Tile {
    public i91Tile(int id) {
        super(Assets.i91, id);
    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
