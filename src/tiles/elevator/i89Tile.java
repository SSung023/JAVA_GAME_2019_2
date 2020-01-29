package tiles.elevator;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i89Tile extends Tile {

    public i89Tile(int id) {
        super(Assets.i89, id);
    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
