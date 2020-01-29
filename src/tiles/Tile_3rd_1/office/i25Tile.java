package tiles.Tile_3rd_1.office;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i25Tile extends Tile {
    public i25Tile(  int id) {
        super(Assets.i25, id);
    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
