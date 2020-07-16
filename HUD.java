import java.awt.*;

public class HUD{
    
    public static int HEALTH = 100;
    
    private int greenValue = 255;
    
    public void tick(){
        
        HEALTH = game.clamp(HEALTH,0, 100);
        
        greenValue = game.clamp(greenValue, 0, 255);
        
        greenValue = HEALTH*2;
    }
    
    public void render(Graphics g){
        //rectangle
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 20);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 15, HEALTH*2, 20);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 20);
        
    }
    
}