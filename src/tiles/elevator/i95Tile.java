package tiles.elevator;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i95Tile extends Tile {
    public i95Tile( int id) {
        super(Assets.i95, id);

    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
