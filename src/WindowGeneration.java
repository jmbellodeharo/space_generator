import javax.swing.*;
import java.awt.*;

public class WindowGeneration extends JFrame {
    MainJPanel mainJPanel = new MainJPanel();
    ButtonJPanel buttonJPanel = new ButtonJPanel(mainJPanel);

    public WindowGeneration(){
        super("SpaceObject Generator");
        // Create a container to add the JPanel
        Container contentPane = getContentPane();
        contentPane.add(buttonJPanel,BorderLayout.SOUTH);
        contentPane.add(mainJPanel,BorderLayout.CENTER);
        // We stablish the default action for X. In this case it stops the execution of the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Makes the window visible
        setVisible(true);
        // Unables the resize option
        setResizable(false);
        pack();
    }
}
