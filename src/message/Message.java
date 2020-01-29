package message;

import GFX.Assets;
import main.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Message {

    //출력할 메세지
    String line = new String();

    //메세지의 아이디   Entity의 아이디와 일치시킨다
    int id;


    public Message(String line, int id){

        this.id = id;
        this.line = line;

}

    // Message 의 id를 반환
    public String getLine(){
        return line;
    }
}
