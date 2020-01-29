package tiles;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i31Tile extends Tile {
    public i31Tile(int id) {
        super(Assets.i31, id);
    }

    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
