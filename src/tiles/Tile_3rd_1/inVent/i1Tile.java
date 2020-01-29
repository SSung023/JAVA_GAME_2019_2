package tiles.Tile_3rd_1.inVent;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i1Tile extends Tile {
    public i1Tile(int id) {
        super(Assets.i1, id);
    }
    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}

