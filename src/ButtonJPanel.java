import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import static java.lang.Math.abs;

public class ButtonJPanel extends JPanel implements ActionListener {
    static String planetaString = "Planeta";
    static String estrellaString = "Estrella";
    static String addString = "Add";
    JRadioButton planetaButton = new JRadioButton(planetaString);
    JRadioButton estrellaButton = new JRadioButton(estrellaString);
    JButton addButton = new JButton(addString);
    ButtonGroup group = new ButtonGroup();
    JPanel radioPanel = new JPanel(new GridLayout(0, 1));

    // Panel size
    final private int height = 480;
    final private int width = 600;
    private MainJPanel mainJPanel;

    private void setMainJPanel(MainJPanel mainJPanelR){
        mainJPanel = mainJPanelR;
    }
    private MainJPanel getMainJPanel(){
        return mainJPanel;
    }
    public ButtonJPanel(MainJPanel mainJPanel){
        super(new BorderLayout());
        setMainJPanel(mainJPanel);
        //Create the radio buttons.
        planetaButton.setActionCommand(planetaString);
        planetaButton.setSelected(true);
        estrellaButton.setActionCommand(estrellaString);

        //Group the radio buttons.
        group.add(planetaButton);
        group.add(estrellaButton);

        //Create simple button
        addButton.setActionCommand(addString);

        //Register a listener for the radio buttons.
        planetaButton.addActionListener(this);
        estrellaButton.addActionListener(this);
        addButton.addActionListener(this);

        //Put the radio buttons in a column in a panel.
        radioPanel.add(planetaButton);
        radioPanel.add(estrellaButton);

        add(radioPanel, BorderLayout.LINE_START);
        add(addButton,BorderLayout.LINE_END);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Add"){
            System.out.println("Add");
            MainJPanel mainJPanelR = getMainJPanel();
            Random random = new Random();
            if(planetaButton.isSelected()){
                System.out.println("Planeta");
                // Generar un planeta en el "canvas"
                mainJPanelR.drawPoint(mainJPanelR.getGraphics(), new Point(abs(random.nextInt()) % width,abs(random.nextInt()) % height),"planet");
            }else if(estrellaButton.isSelected()){
                System.out.println("Estrella");
                // Generar una estrella en el "canvas"
                mainJPanelR.drawPoint(mainJPanelR.getGraphics(), new Point(abs(random.nextInt()) % width, abs(random.nextInt()) % height),"star");
            }
        }
    }
}
