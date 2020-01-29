package tiles.Tile_3rd_1.secure;

import GFX.Assets;
import tiles.Tile;

import java.awt.image.BufferedImage;

public class i5Tile extends Tile {
    public i5Tile(int id) {
        super(Assets.i5, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
