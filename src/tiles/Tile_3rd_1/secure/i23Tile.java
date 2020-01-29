package tiles.Tile_3rd_1.secure;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i23Tile extends Tile {
    public i23Tile( int id) {
        super(Assets.i23, id);
    }

    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
