package tiles.Tile_3rd_1.secure;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i22Tile extends Tile {
    public i22Tile( int id) {
        super(Assets.i22, id);
    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
