package tiles.Tile_3rd_1.office;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i87Tile extends Tile {
    public i87Tile( int id) {
        super(Assets.i87, id);
    }

    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
