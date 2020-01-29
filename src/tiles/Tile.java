package tiles;

import tiles.Tile_2ndFloor.elevator.*;
import tiles.Tile_2ndFloor.*;
import tiles.Tile_2ndFloor.room1.*;
import tiles.Tile_2ndFloor.room2.*;
import tiles.Tile_2ndFloor.room3.*;
import tiles.Tile_2ndFloor.room4.*;
import tiles.Tile_3rd_1.*;
import tiles.Tile_3rd_1.inVent.*;
import tiles.Tile_3rd_1.office.*;
import tiles.Tile_3rd_1.secure.*;
import tiles.elevator.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    // TILE MAP HERE

    //3층
    public static Tile[] tiles = new Tile[256];
    public static Tile i0Tiles = new i0Tile(0);
    public static Tile i1Tiles = new i1Tile(1);
    public static Tile i2Tiles = new i2Tile(2);
    public static Tile i3Tiles = new i3Tile(3);
    public static Tile i4Tiles = new i4Tile(4);
    public static Tile i5Tiles = new i5Tile(5);
    public static Tile i6Tiles = new i6Tile(6);
    public static Tile i7Tiles = new i7Tile(7);
    public static Tile i8Tiles = new i8Tile(8);
    public static Tile i9Tiles = new i9Tile(9);
    public static Tile i10Tiles = new i10Tile(10);
    public static Tile i11Tiles = new i11Tile(11);
    public static Tile i12Tiles = new i12Tile(12);
    public static Tile i13Tiles = new i13Tile(13);
    public static Tile i14Tiles = new i14Tile(14);
    public static Tile i15Tiles = new i15Tile(15);
    public static Tile i16Tiles = new i16Tile(16);
    public static Tile i17Tiles = new i17Tile(17);
    public static Tile i18Tiles = new i18Tile(18);
    public static Tile i19Tiles = new i19Tile(19);
    public static Tile i20Tiles = new i20Tile(20);
    public static Tile i21Tiles = new i21Tile(21);
    ////////
    public static Tile i22Tiles = new i22Tile(22);
    public static Tile i23Tiles = new i23Tile(23);
    public static Tile i24Tiles = new i24Tile(24);
    public static Tile i25Tiles = new i25Tile(25);
    public static Tile i26Tiles = new i26Tile(26);
    public static Tile i27Tiles = new i27Tile(27);
    public static Tile i28Tiles = new i28Tile(28);
    public static Tile i29Tiles = new i29Tile(29);
    public static Tile i30Tiles = new i30Tile(30);
    public static Tile i31Tiles = new i31Tile(31);
    public static Tile i32Tiles = new i32Tile(32);
    public static Tile i33Tiles = new i33Tile(33);
    public static Tile i34Tiles = new i34Tile(34);
    public static Tile i35Tiles = new i35Tile(35);
    public static Tile i36Tiles = new i36Tile(36);
    public static Tile i37Tiles = new i37Tile(37);
    public static Tile i38Tiles = new i38Tile(38);
    public static Tile i39Tiles = new i39Tile(39);
    public static Tile i40Tiles = new i40Tile(40);
    public static Tile i41Tiles = new i41Tile(41);
    public static Tile i42Tiles = new i42Tile(42);
    public static Tile i43Tiles = new i43Tile(43);
    public static Tile i44Tiles = new i44Tile(44);
    public static Tile i45Tiles = new i45Tile(45);
    ////////
    public static Tile i46Tiles = new i46Tile(46);
    public static Tile i47Tiles = new i47Tile(47);
    public static Tile i48Tiles = new i48Tile(48);
    public static Tile i49Tiles = new i49Tile(49);
    public static Tile i50Tiles = new i50Tile(50);
    public static Tile i51Tiles = new i51Tile(51);
    public static Tile i52Tiles = new i52Tile(52);
    public static Tile i53Tiles = new i53Tile(53);
    public static Tile i54Tiles = new i54Tile(54);
    public static Tile i55Tiles = new i55Tile(55);
    public static Tile i56Tiles = new i56Tile(56);
    public static Tile i57Tiles = new i57Tile(57);
    public static Tile i58Tiles = new i58Tile(58);
    public static Tile i59Tiles = new i59Tile(59);
    public static Tile i60Tiles = new i60Tile(60);
    public static Tile i61Tiles = new i61Tile(61);
    public static Tile i62Tiles = new i62Tile(62);
    public static Tile i63Tiles = new i63Tile(63);
    public static Tile i64Tiles = new i64Tile(64);
    public static Tile i65Tiles = new i65Tile(65);
    public static Tile i66Tiles = new i66Tile(66);
    public static Tile i67Tiles = new i67Tile(67);
    ///////
    public static Tile i68Tiles = new i68Tile(68);
    public static Tile i69Tiles = new i69Tile(69);
    public static Tile i70Tiles = new i70Tile(70);
    public static Tile i71Tiles = new i71Tile(71);
    public static Tile i72Tiles = new i72Tile(72);
    public static Tile i73Tiles = new i73Tile(73);
    public static Tile i74Tiles = new i74Tile(74);
    public static Tile i75Tiles = new i75Tile(75);
    public static Tile i76Tiles = new i76Tile(76);
    public static Tile i77Tiles = new i77Tile(77);
    public static Tile i78Tiles = new i78Tile(78);
    public static Tile i79Tiles = new i79Tile(79);
    public static Tile i80Tiles = new i80Tile(80);
    public static Tile i81Tiles = new i81Tile(81);
    public static Tile i82Tiles = new i82Tile(82);
    public static Tile i83Tiles = new i83Tile(83);
    public static Tile i84Tiles = new i84Tile(84);
    public static Tile i85Tiles = new i85Tile(85);
    public static Tile i86Tiles = new i86Tile(86);
    public static Tile i87Tiles = new i87Tile(87);
    //////////elevtor
    public static Tile i88Tiles = new i88Tile(88);
    public static Tile i89Tiles = new i89Tile(89);
    public static Tile i90Tiles = new i90Tile(90);
    public static Tile i91Tiles = new i91Tile(91);
    public static Tile i92Tiles = new i92Tile(92);
    public static Tile i93Tiles = new i93Tile(93);
    public static Tile i94Tiles = new i94Tile(94);
    public static Tile i95Tiles = new i95Tile(95);
    public static Tile i96Tiles = new i96Tile(96);

    // CLASS
    // width and height that tile have
    public static final int TILEWIDTH = 100, TILEHEIGHT = 100;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    // x, y are position on the screen
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    // Mean that you can't walk though this tile
    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
