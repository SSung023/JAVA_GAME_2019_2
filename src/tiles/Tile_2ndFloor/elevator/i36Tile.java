package tiles.Tile_2ndFloor.elevator;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i36Tile extends Tile {
    public i36Tile( int id) {
        super(Assets.i36, id);
    }

    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
