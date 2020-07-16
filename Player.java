import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {
    Handler handler;
    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }
    
    @Override
    public void tick(){
        
        
        x += velX;
        y += velY;
        
        handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.09f, handler));
        //call clamp
        x = game.clamp(x, 0, game.WIDTH - 32);
        y = game.clamp(y, 0, game.HEIGHT - 55);
        
        collision();
    }
    
    public void collision(){
        for(int i = 0; i <handler.object.size(); i++){
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.BasicEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 2;
                }
                
            }
        }
    }
    
    @Override
    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
}