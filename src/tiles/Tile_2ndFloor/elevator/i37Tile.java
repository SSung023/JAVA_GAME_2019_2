package tiles.Tile_2ndFloor.elevator;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i37Tile extends Tile {
    public i37Tile( int id) {
        super(Assets.i37, id);
    }

    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
