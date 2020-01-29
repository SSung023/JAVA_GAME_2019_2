package tiles.Tile_2ndFloor;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i35Tile extends Tile {
    public i35Tile( int id) {
        super(Assets.i35, id);
    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
