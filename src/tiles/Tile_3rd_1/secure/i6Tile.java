package tiles.Tile_3rd_1.secure;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i6Tile extends Tile {
    public i6Tile( int id) {
        super(Assets.i6, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
