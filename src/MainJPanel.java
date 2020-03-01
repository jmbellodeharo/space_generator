import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class MainJPanel extends JPanel {
    final private int width = 600;
    final private int height = 480;
    final private int maxPlanetSize = 7;
    final private int minPlanetSize = 4;
    final private int maxStarSize = 3;
    ArrayList<SpaceObject> spaceObjects = new ArrayList();

    public void paintComponent(Graphics g){
        setSize(new Dimension(width,height));
        g.setColor(new Color(0,0,0));
        g.fillRect(0,0,width,height);
    }

    public void drawPoint(Graphics g, Point start, String type){
        Random random = new Random();
        if(type == "planet"){
            System.out.println("PLANET");
            //Atmosphere
            //Surface
            int planetSize = (abs(random.nextInt()) % maxPlanetSize);
            if(planetSize < minPlanetSize){
                planetSize = minPlanetSize;
            }
            System.out.println("Planet size: " + planetSize);
            g.setColor(new Color(abs(random.nextInt()) % 255, abs(random.nextInt() % 255), abs(random.nextInt() % 255)));
            g.fillOval(start.x, start.y, planetSize, planetSize);

            //Atmosphere probability
            boolean atmosphere = abs(random.nextInt() % (planetSize + 3)) > 3;
            if(atmosphere){
                int atmosphereSize = planetSize + 2;
                System.out.println("Atmosphere size: " + atmosphereSize);
                g.setColor(new Color(135,206,250, 75));
                g.fillOval(start.x, start.y, atmosphereSize, atmosphereSize);
            }

            spaceObjects.add(new SpaceObject(start, planetSize ,type));
        }else if(type == "star"){
            int starSize = (abs(random.nextInt()) % maxStarSize) + 1;
            System.out.println("Star size: " + starSize);
            g.setColor(new Color(abs(random.nextInt() % 255), abs(random.nextInt() % 255), abs(random.nextInt() % 255)));
            g.fillOval(start.x, start.y, starSize, starSize);
            spaceObjects.add(new SpaceObject(start, starSize ,type));
        }



    }

}
