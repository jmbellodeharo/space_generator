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
    private int width;
    private int height;
    final private int maxPlanetSize = 7;
    final private int minPlanetSize = 4;
    final private int maxStarSize = 3;
    private int contador = 0;
    Point start;
    String type;
    ArrayList<SpaceObject> spaceObjects = new ArrayList();
    private BufferedImage bufferedImage;

    public MainJPanel(int height, int width){

        setBackground(new Color(0,0,0));
        this.height = height;
        this.width = width;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    }

    public Dimension getPreferredSize(){
        return new Dimension(width,height);
    }

    public void setData(Point start, String type){
        this.start = start;
        this.type = type;
    }


    public void paintComponent(Graphics graphics) {
        Graphics gn = bufferedImage.getGraphics();
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
            int r = abs(random.nextInt()) % 255;
            int g = abs(random.nextInt()) % 255;
            int b = abs(random.nextInt()) % 255;
            gn.setColor(new Color(r, g, b));
            gn.fillOval(start.x, start.y, planetSize, planetSize);
            //Atmosphere probability
            boolean atmosphere = abs(random.nextInt() % (planetSize + 3)) > 3;
            if(atmosphere){
                int atmosphereSize = planetSize + 2;
                System.out.println("Atmosphere size: " + atmosphereSize);
                gn.setColor(new Color(135,206,250, 75));
                gn.fillOval(start.x, start.y, atmosphereSize, atmosphereSize);
            }
            spaceObjects.add(new SpaceObject(start, planetSize, type));
        }else if(type == "star"){
            int starSize = (abs(random.nextInt()) % maxStarSize) + 1;
            System.out.println("Star size: " + starSize);
            int r = abs(random.nextInt()) % 255;
            int g = abs(random.nextInt()) % 255;
            int b = abs(random.nextInt()) % 255;
            gn.setColor(new Color(r, g, b));
            gn.fillOval(start.x, start.y, starSize, starSize);
            spaceObjects.add(new SpaceObject(start, starSize, type));
        }
        //BufferedImage is drawn on MainJPanel
        graphics.drawImage(bufferedImage,0,0, null);
    }

    /**
     * Save the JPanel content as PNG
     */
    public void saveImage() {
        try{
            String imageName = "save" + getContador() + ".png";
            ImageIO.write(bufferedImage, "png", new File(imageName));
            String currentDir = System.getProperty("user.dir");
            System.out.println("Image " + imageName + " saved at " + currentDir);
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
