package main;

import GFX.Assets;
import GFX.GameCamera;
import GFX.ImageLoader;
import GFX.SpriteSheet;
import States.*;
import display.Display;
import input.KeyManager;
import input.MouseManager;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    public State gameState;
    public State menuState;
    public State introState;
    public State endingState;
    public State howToState;

    //Level Design
    // 각 맵의 성공 여부를 boolean형으로 저장
    // 0 - 메인화면?
    // 1 - thirdFloor_1
    // 2 - inVent
    // 3 - thirdFloor_2
    // 4 - inSecurity;
    private boolean[] clear = {false, false, false, false, false};
    public int index = 0;


    //INPUT
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

    }

    private void init(){
        display = new Display(title, width, height);
        // get frame that we are and allow to listen what we press the key
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);

        //Polymorphism
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        introState = new IntroState(handler);
        endingState = new EndingState(handler);
        howToState = new HowToState(handler);

        //temp
        State.setState(menuState);
        //State.setState(gameState);
    }

    private void tick(){

        keyManager.tick();

        // currentState have some state
        if(State.getState() != null){
            //call currentState's tick method
            State.getState().tick();
        }
    }

    private void render(){

        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //CLEAR SCREEN
        g.clearRect(0,0, width, height);
        ///////////////////////////////RENDER HERE

        if(State.getState() != null){
            //call currentState's render method
            State.getState().render(g);
        }


        ///////////////////////////////RENDER END
        bs.show();
        g.dispose();
    }

    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta --;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and Frames : "+ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera(){ return gameCamera;}

    public int getWidth() {return width;}
    public int getHeight(){return height;}

    // return weather the stage is cleared or not
    public boolean getClear(int index){return clear[index];}
    public void setClear(int index){clear[index] = true;}

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
