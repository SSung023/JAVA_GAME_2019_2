package inventory;

import GFX.Assets;
import GFX.Text;
import item.Item;
import item.ItemManager;
import main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    private int invX = 144, invY = 108, invWidth = 512, invHeight = 384,
                invListCenterX = invX + 171,
                invListCenterY = invY + invHeight / 2 - 15,
                invListSpacing = 30;

    // x & y coordinate 쪽지에 대한 내용이 출력될 좌표
    private int invMessageX = invListCenterX + 152, invMessageY = invListCenterY - 30;

   // x & y coordinate and width & height that image gonna have
    private int invImageX = 532, invImageY = 142,
                invImageWidth = 64, invImageHeight = 64;

    //coordinates for the count that will be displayed
    private int invCountX = 565, invCountY = 213;

    //tell what item is selected, index of Item
    private int selectedItem = 0;

    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();

        //test code
        //addItem(Item.hammerItem.createNew(320,2100));
    }


    public void tick(){

        //turning ON and OFF the inventory
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_C)){
            active = !active;
        }
        if(!active)
            return;

        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP))
            selectedItem--;
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN))
            selectedItem++;

        if(selectedItem < 0)
            selectedItem = inventoryItems.size() -1;
        else if(selectedItem >= inventoryItems.size())
            selectedItem = 0;

    }

    public void render(Graphics g){
        if(!active)
            return;

        g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);

        int len = inventoryItems.size();
        if(len == 0) return;

        // center(0)을 기준으로 inventory의 창이 위, 아래로 각각 5개씩
        for(int i = -5; i<6; i++){
            //check outOfBounds
            if(selectedItem + i < 0 || selectedItem + i >= len)
                continue;
            if(i == 0){
                Text.drawString(g, ">"+inventoryItems.get(selectedItem + i).getName() +"<", invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);

                //만약 아이템의 이름이 note 1이라면 (쪽지에 대한 내용 쓰기)
                if(inventoryItems.get(selectedItem+ i).getName().equals("note 1")){
                    Text.drawString(g, "       > 쪽지<\n 회사 탈출하려고 하는 거야?\n     그럼 이걸 챙겨.", invMessageX, invMessageY, false, Color.white, Assets.fontNote);
                }
                else if(inventoryItems.get(selectedItem+i).getName().equals("note 2")){
                    Text.drawString(g, "       > 쪽지<\n결국 환풍구 안까지 왔구나?\n나는 당신 자리 전 주인이고 \n퇴사를 결정한 뒤 \n탈출 방법을 만들었어\n회사에 탈출할 때 \n필요한 아이템들이 있으니깐 \n중간에 잘 챙겨두라고",
                            invMessageX, invMessageY,false,  Color.white, Assets.fontNote);
                }else if(inventoryItems.get(selectedItem+i).getName().equals("note 3")){
                    Text.drawString(g, "       > 쪽지<\n용케 경비실에 왔네? \n좋아, 다음 힌트를 알려줄게. \n2층은 아마 탈출하기 더 힘들거야. \n수상한 벽을 부수면 나갈 수 있어.",
                            invMessageX, invMessageY,false,  Color.white, Assets.fontNote);
                }
            }else{
                Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
            }

        }

        Item item = inventoryItems.get(selectedItem);

        //show items in inventory
        g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
        Text.drawString(g,Integer.toString(1), invCountX, invCountY,
                true, Color.WHITE, Assets.font28);

    }

    public void printNoteMessage(){

    }


    // Inventory Methods
    public void addItem(Item item){
        for(Item i : inventoryItems){
            //If there is a item inside the inventory
            if(i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
        ItemManager.have++;
    }


    //GETTERS AND SETTERS
    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
