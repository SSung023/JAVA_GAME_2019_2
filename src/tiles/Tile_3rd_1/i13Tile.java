package tiles.Tile_3rd_1;

import GFX.Assets;
import tiles.Tile;

public class i13Tile extends Tile {
    public i13Tile(int id) {
        super(Assets.i13, id);
    }

    @Override
    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return true;
    }
}
