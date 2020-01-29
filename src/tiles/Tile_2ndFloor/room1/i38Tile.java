package tiles.Tile_2ndFloor.room1;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i38Tile extends Tile {
    public i38Tile( int id) {
        super(Assets.i38, id);
    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
