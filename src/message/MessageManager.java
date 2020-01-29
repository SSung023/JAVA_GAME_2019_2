package message;

import GFX.Assets;
import GFX.Text;
import entity.Entity;
import main.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;

public class MessageManager{

    private Handler handler;
    private Message message[] = new Message[100];

    private static String resultLine;

    //출력 할 좌료 설정


    public MessageManager(Handler handler){
        this.handler = handler;

        resultLine = "";

        initMessage();


    }

    public void initMessage(){

        //3층 사무실
        message[0] = new Message("중요한 것은 없어 보인다.", 0); // 복사기
        message[1] = new Message(">부장님 책상<\n지 책상만 깨끗한거 봐라 어휴- \n볼 것도 없다.", 1);    // D1
        message[2] = new Message("직원 :흡…끄흑…또…또 고쳐야 해…\n나 : 저런...",2);// D2
        message[3] = new Message("직원 :크어어억 커억 큭 드르렁~\n나 : 수면실가서 주무시지…",3); // D3
        message[4] = new Message("직원 :.........\n건들지 말아야겠다.",4); // D4
        message[5] = new Message("직원 : ………….\n나 : .. 도와줄 수 없어요..",5); // D5
        message[6] = new Message("직원 : ……………@#@#....\n     #@#$%^@>……\n욕 소리가 들린다.",6); // D6
        message[7] = new Message("중요한 것은 없어보인..\n잠깐만 이 칸 유난히 좁은데? \n쪽지와 드라이버를 획득했다.\nC키를 눌러 인벤토리를 확인해보자!", 7); //myDesk
        message[8] = new Message("[회사 탈출하려고 하는 거야?\n그럼 이걸 챙겨.]",8); //쪽지1
        message[9] = new Message("냉장실에는 핫세븐이 빼곡하다..윽.. \n냉동실에는 투게덜이 있다.맛있겠다.\n투게덜을 획득했다", 9);  // 냉장고
        message[10] = new Message("철컥철컥,\n역시 열리지 않는다.",10); //문
        message[11] = new Message("드라이버로 열 수 있는 환풍구다.\n드라이버를 찾아보자",11); //드라이버 x
        message[12] = new Message("…!!! 이게열려? \n여길 들어가보는 것은 미친짓이지만…\n이 회사에 더 있는 게 미친짓이야.",12); // 드라이버 o

        //환풍구 안
        message[13] = new Message("부스럭 부스럭..\n마취총과 쪽지를 발견했다!!\n아이템을 줍고 인벤토리를 열어보자.",13); //상자
        message[14] = new Message("[결국 환풍구 안까지 왔구나?ㅋㅋㅋ\n나는 당신 자리 전 주인이고 퇴사를 결정한 뒤 탈출 방법을 만들었어\n회사에 탈출할 때 필요한 아이템들이 있으니깐 중간에 잘 챙겨두라고]",14); //쪽지2

        // 3층 경비실 복도
        message[15] = new Message("달칵달칵!\n버튼을 아무리 눌러도 작동하지 않는다.",15); // 엘레베이터
        message[16] = new Message("(덜컹덜컹) \n문을 열려면 ID카드가 필요하다\nID카드는 경비원이 가지고 있는 듯 하다.",16); // 경비실 문, id카드 x
        message[17] = new Message("(띠로링) \n열렸다!",17); //경비실 문, id 카드 o
        message[18] = new Message("지금 가면 CCTV에 모습이 다 찍힐거야..\n경비실에서 CCTV부터 처리하자.",18);//계단 (경비실 문 안열림)
        message[19] = new Message("... 설마 이 마취총을 경비원한테..? \n경비원 아저씨의 뒷목에 마취제를 꽂았다. \n기절했다... \n경비원의 ID 카드를 획득했다 ",19); //경비원
        message[36] = new Message("경비원 : '크으~ 밤공기 좋구만~..'\n경비 아저씨한테 ID 카드가 있어!\n경비 아저씨를 처리(?)할 방법이 없을까...",36);
        message[37] = new Message("경비원 : 커..크어...쿠울.......\n휴; 정말 마취침이었나보다. 잠들었다.",37);
            //3층 복도
        message[35] = new Message("바깥 풍경이 보인다.\n...그냥 창문으로 뛰어내릴까..?\n아, 아니다. \n뛰어내렸다가 다치면 보험 처리도 안해줄 것 같다.",35);

        // 3층 경비실
        message[20] = new Message("화면에는 3층 건물 cctv가 송출되고 있다.\n내 모습이 cctv에 찍히면.. 곤란해지겠지? \n컴퓨터 전원을 껐다.",20); //컴퓨터
        message[21] = new Message("책장에 경비원의 헤드셋이 있다. \n혹시 모르니 챙겨가자.",21); //책장
        message[22] = new Message("경비원의 일기장이다.\n'아.. 퇴근하고 싶다..♥' \n ...? \n일기장 사이에 쪽지가 있다. \n인벤토리를 열어보자.",22); //일기장
        message[23] = new Message("[용케 경비실에 왔네? 좋아, 다음 힌트를 알려줄게. \n 2층은 아마 탈출하기 더 힘들거야. \n수상한 벽을 찾아서 부수면 나갈 수 있어.]",23); //쪽지3
        message[24] = new Message("말랑말랑~ 침대가 매우 푹신해보인다…\n조금만 누울까? 주인도 없는데 뭐.\n부스럭\n?! 왠 쪽지를 찾았다",24); //침대

        //3층 계단
        message[25] = new Message("아니 이 곳에 왜 망치가..? \n혹시 모르니 주워가자.",25);

        //2층 복도
        message[26] = new Message("앗 이 벽 색깔만 다른데? \n망치로 부수면 될까? \n망치로 벽을 부셨다. \n독한놈.. 이렇게 통로를 만들어놓네?;;;",26); //금이 간 벽
        message[27] = new Message("안에 사람들이 있을 수 있어..\n들어가면 들킬지도 몰라",27); //파란문들
        message[38] = new Message("앗! 이 방은 회의 중이야\n들어가면 사람들이 있을거야.",38);
        message[28] = new Message("이 앞은 cctv 때문에 못 지나가.",28); //cctv 있는 벽

        //2층 미로
        message[29] = new Message("헉 이건 초코잼 누텔랴? 맛있겠다. \n누텔랴 주워가서 먹어야겠다.",29); //누텔랴
        message[30] = new Message("귀엽게 포장된 SSD다.\n몇 기가지?\n집에 가져가서 데스크탑에 달아야겠다.",30); //스스디
        message[31] = new Message("이 벽도 금이 가있어! \n망치로 부셔버리자.",31); // 금이 간 벽

        //2층 복도
        message[32] = new Message("System: 인벤토리 검사 시작 \n뭐야? 엘레베이터가 말을 해?? ",32); //엘레베이터
        message[33] = new Message(">System<\nSSD, 헤드셋, ID카드, 투게덜... \n'SHIT'단어 확인. \n엘레베이터가 재작동됩니다. \n뭐야 shit?? 쒣??? 나.. 그럼 탈출인건가?" ,33);  //아이템이 모두 있을 경우
        message[34] = new Message(">System<\n삐빅! 필요한 아이템이 존재하지 않습니다\n다시 가서 찾아오세요.\n나 : 뭐야?;;;",34); //아이템이 없을 경우
        message[39] = new Message("집!!!!!!!!!111집!!!집집ㅈ짖지집!!! \n고투 더 홈 고투 더 베드 플리즈...",39);

    }

    // Player Class의 checkInteract 메소드에서 id를 받으면
    public void setResultLine(int id){
        resultLine = message[id].getLine();
    }

    public static String getResultLine(){
        return resultLine;
    }


}
