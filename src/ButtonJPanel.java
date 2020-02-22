import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ButtonJPanel extends JPanel implements ActionListener {
    static String planetaString = "Planeta";
    static String estrellaString = "Estrella";
    static String addString = "Add";

        public ButtonJPanel(){
        super(new BorderLayout());

        //Create the radio buttons.
        JRadioButton planetaButton = new JRadioButton(planetaString);
        planetaButton.setActionCommand(planetaString);
        planetaButton.setSelected(true);

        JRadioButton estrellaButton = new JRadioButton(estrellaString);
        estrellaButton.setActionCommand(estrellaString);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(planetaButton);
        group.add(estrellaButton);

        //Create simple button
        JButton addButton = new JButton("Add");
        addButton.setActionCommand(planetaString);

        //Register a listener for the radio buttons.
        planetaButton.addActionListener(this);
        estrellaButton.addActionListener(this);
        addButton.addActionListener(this);

        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(planetaButton);
        radioPanel.add(estrellaButton);

        add(radioPanel, BorderLayout.LINE_START);
        add(addButton,BorderLayout.LINE_END);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Planeta"){
            System.out.println("Planeta");
        }else{
            System.out.println("Estrella");
        }
    }
}
