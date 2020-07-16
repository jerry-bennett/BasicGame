import java.awt.*;
import javax.swing.JFrame;
public class Window extends Canvas{
    
    //constructor
    public Window(int width, int height, String title, game game){
        JFrame frame = new JFrame(title);
        
        //set up size
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        //be able to close window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        //window starts in middle of screen
        frame.setLocationRelativeTo(null);
        //add game into frame
        frame.add(game);
        frame.setVisible(true);
        
        //run start method
        game.start();
    }
}