package GFX;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.nio.Buffer;
import java.util.OptionalInt;

// crop out the images(tiles) that we need
public class Assets {

    private static final int width = 47, height = 79;
    private static final int widthBack = 100, heightBack = 100;

    public static Font font28, font18, fontNote;

    //main Screen
    public static BufferedImage mainScreen, howTo;


    // 모든 타일들을 세팅
    public static BufferedImage i0,i1, i2, i3, i4, i5, i6, i7, i8,i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20,
            i21, i22, i23,i24,i25,i26,i27,i28,i29,i30,i31,i32,i33,i34,i35,i36,i37,i38,i39,i40,
            i41,i42,i43,i44,i45,i46,i47,i48,i49,i50, i51,i52,i53,i54,i55,i56,i57,i58,i59,i60,
            i61,i62,i63,i64,i65,i66,i67,i68,i69,i70,i71,i72,i73,i74,i75,i76,i77,i78,i79,i80,
            i81,i82,i83,i84,i85,i86, i87,
            i88,i89, i90, i91, i92, i93,i94,i95, i96;

    // Entity in third floor
    public static BufferedImage thirdDesk_1, thirdDesk_2, thirdDesk_3, thirdDesk_4, thirdDesk_5, thirdDesk_6, deskMine,
                                thirdDoor, copier, vent, refigerator;

    // 3층 환풍구에서의 ENtity
    public static BufferedImage ventBox1;

    //3층 복도에서의 Entity
    public static BufferedImage securityGuard, elevator_2, guardSleep;

    //경비실에서의 Entity
    public static BufferedImage cctvButton, cctvOn, cctvOFF, bed, shelves, diary, securityDoor, cardReader,
                                cctvDesk1, cctvDesk2, cctvDesk3, cctvFull;

    //계단에서 망치
    public static BufferedImage hammer, stairCCTV;

    //2층 복도 Entity
    public static BufferedImage breakable_Wall, door1, door2, final_elevator, mazeExit,
                                mazeBox1, mazeBox2, dontGo, movePositionElevator;


    //ITEMS
    public static BufferedImage driver, headset, IDcard, note1, note2, note3, nutellar, shot, SSD, together;

    // Images that to show player Animation
    public static BufferedImage[] player_Down, player_Up, player_Right, player_Left, playerStop,
            player_crawlUp, player_crawlDown, player_crawlRight, player_crawlLeft,
            playerStopUp, playerStopDown, playerStopRight, playerStopLeft,
            playerSwing, playerInteractUp,playerInteractDown,playerInteractLeft,playerInteractRight,
            btn_Start, btn_How, btn_exit;

    //Inventory
    public static BufferedImage inventoryScreen;

    //load in everything in Game
    public static void init(){

        font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
        font18 = FontLoader.loadFont("res/fonts/PFStardust.ttf", 16);
        fontNote = FontLoader.loadFont("res/fonts/PFStardust.ttf", 15);

        // 캐릭터 sheet
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/character/characterCrawlAdd.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/character/playerAct.png"));
        //world map tile
        SpriteSheet backSheet = new SpriteSheet(ImageLoader.loadImage("/texture/worldSheet/FinalSheetConfig.png"));
        SpriteSheet elevatorSheet = new SpriteSheet(ImageLoader.loadImage("/texture/worldSheet/elevatorSheet.png"));


        //menu and inventory
        inventoryScreen = ImageLoader.loadImage("/texture/inventoryScreen.png");
        mainScreen = ImageLoader.loadImage("/menu/title.png");
        howTo = ImageLoader.loadImage("/menu/HOWTO_1.png");



        //MENU button
        btn_Start = new BufferedImage[2];
        btn_How = new BufferedImage[2];
        btn_exit = new BufferedImage[2];

        btn_Start[1] = ImageLoader.loadImage("/menu/start.png");
        btn_Start[0] = ImageLoader.loadImage("/menu/start_on.png");

        btn_How[1] = ImageLoader.loadImage("/menu/how.png");
        btn_How[0] = ImageLoader.loadImage("/menu/how_on.png");

        btn_exit[1] = ImageLoader.loadImage("/menu/end.png");
        btn_exit[0] = ImageLoader.loadImage("/menu/end_on.png");


        //for Animation
        playerSwing = new BufferedImage[2];

        playerInteractUp = new BufferedImage[4];
        playerInteractDown = new BufferedImage[4];
        playerInteractLeft = new BufferedImage[4];
        playerInteractRight = new BufferedImage[4];

        player_Down = new BufferedImage[4];
        player_Up = new BufferedImage[4];
        player_Right = new BufferedImage[4];
        player_Left = new BufferedImage[4];

        player_crawlDown = new BufferedImage[4];
        player_crawlUp = new BufferedImage[4];
        player_crawlRight = new BufferedImage[4];
        player_crawlLeft = new BufferedImage[4];

        //상호작용 시 효5
        playerInteractDown[0] = sheet1.crop(0,3, width, height);
        playerInteractDown[1] = sheet1.crop(2,3, width, height);
        playerInteractDown[2] = sheet1.crop(1,3, width,height);
        playerInteractDown[3] = sheet1.crop(2,3, width,height);

        playerInteractUp[0] = sheet1.crop(0,2, width, height);
        playerInteractUp[1] = sheet1.crop(1,2, width, height);
        playerInteractUp[2] = sheet1.crop(2,2, width,height);
        playerInteractUp[3] = sheet1.crop(1,2, width,height);

        playerInteractRight[0] = sheet1.crop(0,1, width, height);
        playerInteractRight[1] = sheet1.crop(1,1, width, height);
        playerInteractRight[2] = sheet1.crop(2, 1, width,height);
        playerInteractRight[3] = sheet1.crop(1, 1, width,height);

        playerInteractLeft[0] = sheet1.crop(0,0, width, height);
        playerInteractLeft[1] = sheet1.crop(1,0, width, height);
        playerInteractLeft[2] = sheet1.crop(2,0, width,height);
        playerInteractLeft[3] = sheet1.crop(1,0, width,height);


        // 일반적인 이동 효과
        player_Up[0] = sheet.crop(0,0, width, height);
        player_Up[1] = sheet.crop(1,0, width, height);
        player_Up[2] = sheet.crop(2,0, width, height);
        player_Up[3] = sheet.crop(1,0, width, height);

        player_Right[0] = sheet.crop(0, 1, width, height);
        player_Right[1] = sheet.crop(1, 1, width, height);
        player_Right[2] = sheet.crop(2, 1, width, height);
        player_Right[3] = sheet.crop(1,1, width, height);

        player_Down[0] = sheet.crop(0,2, width, height);
        player_Down[1] = sheet.crop(1,2, width, height);
        player_Down[2] = sheet.crop(2,2, width, height);
        player_Down[3] = sheet.crop(1,2, width, height);

        player_Left[0] = sheet.crop(0,3, width, height);
        player_Left[1] = sheet.crop(1,3, width, height);
        player_Left[2] = sheet.crop(2,3, width, height);
        player_Left[3] = sheet.crop(1,3, width, height);

        /*0: Up
         * 1: Right
         * 2: Down
         * 3: Left*/
        player_crawlUp[0] = sheet.crop(0,5, width, height);
        player_crawlUp[1] = sheet.crop(1,5, width, height);
        player_crawlUp[2] = sheet.crop(2,5, width, height);
        player_crawlUp[3] = sheet.crop(1,5, width, height);

        player_crawlDown[0] = sheet.crop(0,4, width, height);
        player_crawlDown[1] = sheet.crop(1,4, width, height);
        player_crawlDown[2] = sheet.crop(2,4, width, height);
        player_crawlDown[3] = sheet.crop(1,4, width, height);

        player_crawlLeft[0] = sheet.crop(0,6, width, height);
        player_crawlLeft[1] = sheet.crop(1,6, width, height);
        player_crawlLeft[2] = sheet.crop(2,6, width, height);
        player_crawlLeft[3] = sheet.crop(1,6, width, height);

        player_crawlRight[0] = sheet.crop(0,7, width, height);
        player_crawlRight[1] = sheet.crop(1,7, width, height);
        player_crawlRight[2] = sheet.crop(2,7, width, height);
        player_crawlRight[3] = sheet.crop(1,7, width, height);

        /////////////////////////////////////////////////////////////////////////
        ///////////TILE MAP
        /////////////////////////////////////////////////////////////////////////
        //third floor_1
        i0 = backSheet.cropBackground(0,0,widthBack,heightBack);
        i1= backSheet.cropBackground(1,0,widthBack,heightBack);
        i2 = backSheet.cropBackground(2,0,widthBack,heightBack);
        i3 = backSheet.cropBackground(3,0,widthBack,heightBack);
        i4 = backSheet.cropBackground(4,0,widthBack,heightBack);
        i5 = backSheet.cropBackground(5,0,widthBack,heightBack);
        i6 = backSheet.cropBackground(6,0,widthBack,heightBack);
        i7 = backSheet.cropBackground(7,0,widthBack,heightBack);
        i8 = backSheet.cropBackground(8,0,widthBack,heightBack);
        i9 = backSheet.cropBackground(9,0,widthBack,heightBack);
        i10 = backSheet.cropBackground(10,0,widthBack,heightBack);
        i11 = backSheet.cropBackground(11,0,widthBack,heightBack);
        i12 = backSheet.cropBackground(12,0,widthBack,heightBack);
        i13 = backSheet.cropBackground(13,0,widthBack,heightBack);
        i14 = backSheet.cropBackground(14,0,widthBack,heightBack);
        i15 = backSheet.cropBackground(15,0,widthBack,heightBack);
        i16 = backSheet.cropBackground(16,0,widthBack,heightBack);
        i17 = backSheet.cropBackground(17,0,widthBack,heightBack);
        i18 = backSheet.cropBackground(18,0,widthBack,heightBack);
        i19 = backSheet.cropBackground(19,0,widthBack,heightBack);
        i20 = backSheet.cropBackground(20,0,widthBack,heightBack);
        i21 = backSheet.cropBackground(21,0,widthBack,heightBack);
        ////////한줄
        i22 = backSheet.cropBackground(0,1,widthBack,heightBack);
        i23 = backSheet.cropBackground(1,1,widthBack,heightBack);
        i24 = backSheet.cropBackground(2,1,widthBack,heightBack);
        i25 = backSheet.cropBackground(3,1,widthBack,heightBack);
        i26 = backSheet.cropBackground(4,1,widthBack,heightBack);
        i27 = backSheet.cropBackground(5,1,widthBack,heightBack);
        i28 = backSheet.cropBackground(6,1,widthBack,heightBack);
        i29 = backSheet.cropBackground(7,1,widthBack,heightBack);
        i30 = backSheet.cropBackground(8,1,widthBack,heightBack);
        i31 = backSheet.cropBackground(9,1,widthBack,heightBack);
        i32 = backSheet.cropBackground(10,1,widthBack,heightBack);
        i33 = backSheet.cropBackground(11,1,widthBack,heightBack);
        i34 = backSheet.cropBackground(12,1,widthBack,heightBack);
        i35 = backSheet.cropBackground(13,1,widthBack,heightBack);
        i36 = backSheet.cropBackground(14,1,widthBack,heightBack);
        i37 = backSheet.cropBackground(15,1,widthBack,heightBack);
        i38 = backSheet.cropBackground(16,1,widthBack,heightBack);
        i39 = backSheet.cropBackground(17,1,widthBack,heightBack);
        i40 = backSheet.cropBackground(18,1,widthBack,heightBack);
        i41 = backSheet.cropBackground(19,1,widthBack,heightBack);
        i42 = backSheet.cropBackground(20,1,widthBack,heightBack);
        i43= backSheet.cropBackground(21,1,widthBack,heightBack);
        //한줄
        i44 = backSheet.cropBackground(0,2,widthBack,heightBack);
        i45= backSheet.cropBackground(1,2,widthBack,heightBack);
        i46 = backSheet.cropBackground(2,2,widthBack,heightBack);
        i47 = backSheet.cropBackground(3,2,widthBack,heightBack);
        i48 = backSheet.cropBackground(4,2,widthBack,heightBack);
        i49 = backSheet.cropBackground(5,2,widthBack,heightBack);
        i50 = backSheet.cropBackground(6,2,widthBack,heightBack);
        i51= backSheet.cropBackground(7,2,widthBack,heightBack);
        i52 = backSheet.cropBackground(8,2,widthBack,heightBack);
        i53 = backSheet.cropBackground(9,2,widthBack,heightBack);
        i54 = backSheet.cropBackground(10,2,widthBack,heightBack);
        i55 = backSheet.cropBackground(11,2,widthBack,heightBack);
        i56 = backSheet.cropBackground(12,2,widthBack,heightBack);
        i57 = backSheet.cropBackground(13,2,widthBack,heightBack);
        i58 = backSheet.cropBackground(14,2,widthBack,heightBack);
        i59 = backSheet.cropBackground(15,2,widthBack,heightBack);
        i60 = backSheet.cropBackground(16,2,widthBack,heightBack);
        i61 = backSheet.cropBackground(17,2,widthBack,heightBack);
        i62 = backSheet.cropBackground(18,2,widthBack,heightBack);
        i63 = backSheet.cropBackground(19,2,widthBack,heightBack);
        i64 = backSheet.cropBackground(20,2,widthBack,heightBack);
        //한줄
        i65 = backSheet.cropBackground(0,3,widthBack,heightBack);
        i66= backSheet.cropBackground(1,3,widthBack,heightBack);
        i67 = backSheet.cropBackground(2,3,widthBack,heightBack);
        i68 = backSheet.cropBackground(3,3,widthBack,heightBack);
        i69 = backSheet.cropBackground(4,3,widthBack,heightBack);
        i70 = backSheet.cropBackground(5,3,widthBack,heightBack);
        i71 = backSheet.cropBackground(6,3,widthBack,heightBack);
        i72 = backSheet.cropBackground(7,3,widthBack,heightBack);
        i73 = backSheet.cropBackground(8,3,widthBack,heightBack);
        i74 = backSheet.cropBackground(9,3,widthBack,heightBack);
        i75 = backSheet.cropBackground(10,3,widthBack,heightBack);
        i76 = backSheet.cropBackground(11,3,widthBack,heightBack);
        i77 = backSheet.cropBackground(12,3,widthBack,heightBack);
        i78 = backSheet.cropBackground(13,3,widthBack,heightBack);
        i79 = backSheet.cropBackground(14,3,widthBack,heightBack);
        i80 = backSheet.cropBackground(15,3,widthBack,heightBack);
        i81 = backSheet.cropBackground(16,3,widthBack,heightBack);
        i82 = backSheet.cropBackground(17,3,widthBack,heightBack);
        i83 = backSheet.cropBackground(18,3,widthBack,heightBack);
        i84 = backSheet.cropBackground(19,3,widthBack,heightBack);
        i85 = backSheet.cropBackground(20,3,widthBack,heightBack);
        i86 = backSheet.cropBackground(21,3,widthBack,heightBack);
        i87 = backSheet.cropBackground(21,2,widthBack,heightBack);
        //엘리베이터 시트
        i88 = elevatorSheet.cropBackground(0,0,widthBack,heightBack);
        i89 = elevatorSheet.cropBackground(1,0,widthBack,heightBack);
        i90 = elevatorSheet.cropBackground(2,0,widthBack,heightBack);
        i91 = elevatorSheet.cropBackground(3,0,widthBack,heightBack);
        i92 = elevatorSheet.cropBackground(4,0,widthBack,heightBack);
        i93 = elevatorSheet.cropBackground(5,0,widthBack,heightBack);
        i94 = elevatorSheet.cropBackground(6,0,widthBack,heightBack);
        i95 = elevatorSheet.cropBackground(7,0,widthBack,heightBack);
        i96 = elevatorSheet.cropBackground(8,0,widthBack,heightBack);
//        i97 = elevatorSheet.cropBackground(9,0,widthBack,heightBack);
//        i98 = elevatorSheet.cropBackground(10,0,widthBack,heightBack);
        //i99 = elevatorSheet.cropBackground(0,0,widthBack,heightBack);



        //Entity
        thirdDesk_1 = ImageLoader.loadImage("/objects/desk/desk1.png");
        thirdDesk_2 = ImageLoader.loadImage("/objects/desk/desk3.png");
        thirdDesk_3 = ImageLoader.loadImage("/objects/desk/desk4.png");
        thirdDesk_4 = ImageLoader.loadImage("/objects/desk/desk5.png");
        thirdDesk_5 = ImageLoader.loadImage("/objects/desk/desk2.png");
        thirdDesk_6 = ImageLoader.loadImage("/objects/desk/desk7.png");
        deskMine = ImageLoader.loadImage("/objects/desk/mine.png");
        thirdDoor = i31;
        copier = ImageLoader.loadImage("/objects/office/copier.png");
        vent = ImageLoader.loadImage("/objects/vent.png");
        refigerator = ImageLoader.loadImage("/objects/refriger.png");

        //3층 환풍구
        ventBox1 = ImageLoader.loadImage("/objects/ventBox.png");

        //3층 복도
        elevator_2 = ImageLoader.loadImage("/objects/3rdElevator.png");
        securityGuard = ImageLoader.loadImage("/objects/secutiry.png");
        guardSleep = ImageLoader.loadImage("/objects/sleep.png");

        //3층 경비실
        cctvFull = ImageLoader.loadImage("/objects/cctvWhole.png");
        cardReader = ImageLoader.loadImage("/objects/reader.png");
        securityDoor = ImageLoader.loadImage("/objects/securityDoor.png");
        cctvButton = ImageLoader.loadImage("/objects/cctvButton.png");
        cctvOn = ImageLoader.loadImage("/objects/cctvPanel.png");
        cctvOFF = ImageLoader.loadImage("/objects/cctvPanelOFF.png");
        bed = ImageLoader.loadImage("/objects/bed.png");
        shelves = ImageLoader.loadImage("/objects/securityShelves.png");
        diary = ImageLoader.loadImage("/objects/securityLEtter.png");
        cctvDesk1 = ImageLoader.loadImage("/objects/cctvDesk1.png");
        cctvDesk2 = ImageLoader.loadImage("/objects/cctvDesk2.png");
        cctvDesk3 = ImageLoader.loadImage("/objects/cctvDesk3.png");

        //2층 계단 망치
        hammer = ImageLoader.loadImage("/Item/hammer_ground.png");
        stairCCTV = ImageLoader.loadImage("/objects/cctvStair.png");

        //2층 복도
        breakable_Wall = ImageLoader.loadImage("/objects/2ndEnterMaze1.png");
        door1 = ImageLoader.loadImage("/objects/door_talk.png");
        door2 = ImageLoader.loadImage("/objects/door.png");
        final_elevator = ImageLoader.loadImage("/objects/2ndEle.png");

        dontGo = ImageLoader.loadImage("/objects/CctvFloorDontgo.png");



        //2층 미로 안
        mazeExit = ImageLoader.loadImage("/objects/mazeExit.png");
        mazeBox1 = ventBox1;
        mazeBox2 = ventBox1;

        //ITEMS
        driver = ImageLoader.loadImage("/Item/driver.png");
        headset = ImageLoader.loadImage("/Item/headset.png");
        IDcard = ImageLoader.loadImage("/Item/idCard.png");
        note1 = ImageLoader.loadImage("/Item/note1.png");
        note2 = ImageLoader.loadImage("/Item/note2.png");
        note3 = ImageLoader.loadImage("/Item/note3.png");
        nutellar = ImageLoader.loadImage("/Item/nutellar.png");
        shot = ImageLoader.loadImage("/Item/shot.png");
        SSD = ImageLoader.loadImage("/Item/SSD.png");
        together = ImageLoader.loadImage("/Item/togerther.png");



    }

}
