package tiles.Tile_3rd_1.secure;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i17Tile extends Tile {
    public i17Tile( int id) {
        super(Assets.i17, id);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
