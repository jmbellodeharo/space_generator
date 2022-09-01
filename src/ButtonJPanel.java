import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import static java.lang.Math.abs;

public class ButtonJPanel extends JPanel implements ActionListener {
    static String planetaString = "Planet";
    static String estrellaString = "Star";
    static String saveImageString = "Save";
    static String addString = "Add";
    JRadioButton planetaButton = new JRadioButton(planetaString);
    JRadioButton estrellaButton = new JRadioButton(estrellaString);
    JButton saveImageButton = new JButton(saveImageString);
    JButton addButton = new JButton(addString);
    ButtonGroup group = new ButtonGroup();
    JPanel radioPanel = new JPanel(new GridLayout(2, 2));
    JPanel buttonsPanel = new JPanel(new GridLayout(2, 0));
    // Panel size
    private int height;
    private int width;
    private MainJPanel mainJPanel;

    private void setMainJPanel(MainJPanel mainJPanelR){
        mainJPanel = mainJPanelR;
    }
    private MainJPanel getMainJPanel(){
        return mainJPanel;
    }

    public ButtonJPanel(MainJPanel mainJPanel, int height, int width){
        super(new BorderLayout());
        this.height = height;
        this.width = width;
        setMainJPanel(mainJPanel);
        //Create the radio buttons.
        planetaButton.setActionCommand(planetaString);
        planetaButton.setSelected(true);
        estrellaButton.setActionCommand(estrellaString);

        //Group the radio buttons.
        group.add(planetaButton);
        group.add(estrellaButton);

        //Put the radio buttons in a column in a panel.
        radioPanel.add(planetaButton);
        radioPanel.add(estrellaButton);

        //Create simple button
        addButton.setActionCommand(addString);

        //Create button save
        saveImageButton.setActionCommand(saveImageString);

        //Add buttons to JPanel for buttons
        buttonsPanel.add(addButton);
        buttonsPanel.add(saveImageButton);

        //Register a listener for the radio buttons.
        planetaButton.addActionListener(this);
        estrellaButton.addActionListener(this);
        addButton.addActionListener(this);
        saveImageButton.addActionListener(this);


        add(radioPanel, BorderLayout.WEST);
        add(buttonsPanel,BorderLayout.EAST);

        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainJPanel mainJPanel = getMainJPanel();
        if(e.getActionCommand() == addString){
            System.out.println("Add");

            Random random = new Random();
            if(planetaButton.isSelected()){
                System.out.println("Planeta");
                mainJPanel.setData(new Point(abs(random.nextInt()) % width,abs(random.nextInt()) % height),"planet");
                // Generar un planeta en el "canvas"
                mainJPanel.paintComponent(mainJPanel.getGraphics());
            }else if(estrellaButton.isSelected()){
                System.out.println("Estrella");
                mainJPanel.setData(new Point(abs(random.nextInt()) % width,abs(random.nextInt()) % height),"star");
                // Generar una estrella en el "canvas"
                mainJPanel.paintComponent(mainJPanel.getGraphics());
            }
            //Print star and planet number

        }else if(e.getActionCommand() == saveImageString){
            mainJPanel.saveImage();
        }
    }
}
