import javax.swing.*;
import java.awt.*;

public class MainJPanel extends JPanel {
    public void paintComponent(Graphics g){
        setSize(new Dimension(600,480));
        g.setColor(new Color(0,0,0));
        g.fillRect(0,0,600,480);
    }
}
