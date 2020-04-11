import com.sun.tools.javac.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class MainJPanel extends JPanel {
    final private int width = 600;
    final private int height = 480;
    final private int maxPlanetSize = 7;
    final private int minPlanetSize = 4;
    final private int maxStarSize = 3;
    private int contador = 0;
    ArrayList<SpaceObject> spaceObjects = new ArrayList();
    private BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    public MainJPanel(){
        setBackground(new Color(0,0,0));
    }

    public Dimension getPreferredSize(){
        return new Dimension(width,height);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Draw the spaceObject
     *
     * @param start point object (x,y) where the planet/star will be created
     * @param type spaceObject type: planet or star
     */
    public void drawPoint(Point start, String type, MainJPanel mainJPanel){
        Random random = new Random();
        Graphics gm = mainJPanel.getGraphics();
        Graphics gb = bufferedImage.getGraphics();
        if(type == "planet"){
            System.out.println("PLANET");
            //Atmosphere
            //Surface
            int planetSize = (abs(random.nextInt()) % maxPlanetSize);
            if(planetSize < minPlanetSize){
                planetSize = minPlanetSize;
            }
            System.out.println("Planet size: " + planetSize);
            int r = abs(random.nextInt()) % 255;
            int g = abs(random.nextInt()) % 255;
            int b = abs(random.nextInt()) % 255;
            gm.setColor(new Color(r, g, b));
            gm.fillOval(start.x, start.y, planetSize, planetSize);
            gb.setColor(new Color(r, g, b));
            gb.fillOval(start.x, start.y, planetSize, planetSize);
            //Atmosphere probability
            boolean atmosphere = abs(random.nextInt() % (planetSize + 3)) > 3;
            if(atmosphere){
                int atmosphereSize = planetSize + 2;
                System.out.println("Atmosphere size: " + atmosphereSize);
                gm.setColor(new Color(135,206,250, 75));
                gm.fillOval(start.x, start.y, atmosphereSize, atmosphereSize);
                gb.setColor(new Color(135,206,250, 75));
                gb.fillOval(start.x, start.y, atmosphereSize, atmosphereSize);
            }
            spaceObjects.add(new SpaceObject(start, planetSize, type));
        }else if(type == "star"){
            int starSize = (abs(random.nextInt()) % maxStarSize) + 1;
            System.out.println("Star size: " + starSize);
            int r = abs(random.nextInt()) % 255;
            int g = abs(random.nextInt()) % 255;
            int b = abs(random.nextInt()) % 255;
            gm.setColor(new Color(r, g, b));
            gm.fillOval(start.x, start.y, starSize, starSize);
            gb.setColor(new Color(r, g, b));
            gb.fillOval(start.x, start.y, starSize, starSize);
            spaceObjects.add(new SpaceObject(start, starSize, type));
        }
    }

    /**
     * Save the JPanel content as PNG
     */
    public void saveImage(MainJPanel mainJPanel) {
        try{
            ImageIO.write(bufferedImage, "png", new File("save" + getContador() + ".png"));
        }catch (Exception e){
            System.out.println("ERROR");
            e.printStackTrace();
        }
        setContador();
    }

    public int getContador() {
        return contador;
    }
    public void setContador() {
        this.contador += 1;
    }
}
