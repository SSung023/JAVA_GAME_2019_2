package tiles;

import GFX.Assets;

import java.awt.image.BufferedImage;

public class i0Tile extends Tile {
    public i0Tile(int id) {
        super(Assets.i0, id);
    }

    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
