package tiles.elevator;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i90Tile extends Tile {
    public i90Tile(int id) {
        super(Assets.i90, id);
    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
