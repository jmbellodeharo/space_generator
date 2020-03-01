import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WindowGeneration extends JFrame {
    MainJPanel mainJPanel = new MainJPanel();
    ButtonJPanel buttonJPanel = new ButtonJPanel(mainJPanel);
    final private int width = 600;
    final private int height = 600;

    public WindowGeneration(){
        super("SpaceObject Generator");
        // Create a container to add the JPanel
        Container cp = getContentPane();
        cp.add(mainJPanel,BorderLayout.CENTER);
        cp.add(buttonJPanel,BorderLayout.SOUTH);
        // We stablish the default action for X. In this case it stops the execution of the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // We set an initial size for the window, but can be resized
        setSize(width,height);
        // Makes the window visible
        setVisible(true);
        // Unables the resize option
        setResizable(false);
    }
}
