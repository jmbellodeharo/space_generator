import javax.swing.*;
import java.awt.*;

public class WindowGeneration extends JFrame {
    public WindowGeneration(){
        super("Space Generator");
        // Create a container to add the JPanel
        Container cp = getContentPane();
        cp.add(new MainJPanel(),BorderLayout.CENTER);
        cp.add(new ButtonJPanel(),BorderLayout.SOUTH);
        // We stablish the default action for X. In this case it stops the execution of the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // We set an initial size for the window, but can be resized
        setSize(600,600);
        // Makes the window visible
        setVisible(true);
        // Unables the option of resize
        setResizable(false);
    }
}
