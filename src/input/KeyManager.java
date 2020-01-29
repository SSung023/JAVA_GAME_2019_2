package input;

import entity.creature.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys, justPressed, cantPress;
    public boolean up, down, right, left, ctrl;

    //tmp
    public boolean interact, breakThing, showInven, esc;

    public KeyManager(){
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }

    public void tick(){
        for(int i=0; i<keys.length; i++){
            if(cantPress[i] && !keys[i]){
                cantPress[i] = false;
            }else if(justPressed[i]){
                cantPress[i] = true;
                justPressed[i] = false;
            }

            if(!cantPress[i] && keys[i]){
                justPressed[i] = true;
            }
        }

        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        ctrl = keys[KeyEvent.VK_CONTROL];

        //to show message
        interact = keys[KeyEvent.VK_Z];
        // 타일이나 엔티티들 부수기
        breakThing = keys[KeyEvent.VK_X];
        // 인벤토리 보여주기
        showInven = keys[KeyEvent.VK_C];
        esc = keys[KeyEvent.VK_ESCAPE];


    }

    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;

        keys[e.getKeyCode()] = true;

        //System.out.println("Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;

        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
