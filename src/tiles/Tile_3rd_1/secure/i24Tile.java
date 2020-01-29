package tiles.Tile_3rd_1.secure;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i24Tile extends Tile {
    public i24Tile( int id) {
        super(Assets.i24, id);
    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
