package tiles.Tile_3rd_1.inVent;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i2Tile extends Tile {
    public i2Tile(int id) {
        super(Assets.i2, id);
    }

    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
