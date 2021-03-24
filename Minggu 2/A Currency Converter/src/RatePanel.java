import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class RatePanel extends JPanel 
{
    private double[] rate; // exchange rates 
    private String[] currencyName; 
    private JLabel result; 
    private JComboBox selection;
    private JTextField textField;
    private JButton submit;
    private JLabel convertionResult;
    
    public RatePanel () 
    { 
        JLabel title = new JLabel ("How much is that in dollars?"); 
        title.setAlignmentX (Component.CENTER_ALIGNMENT); 
        title.setFont (new Font ("Helvetica", Font.BOLD, 20)); 
        // Set up the arrays for the currency conversions 
        currencyName = new String[] {"Select the currency..", 
                                    "European Euro", "Canadian Dollar", 
                                    "Japanese Yen", "Australian Dollar", 
                                    "Indian Rupee", "Mexican Peso"}; 
        rate = new double [] {0.0, 1.2103, 0.7351, 
                            0.0091, 0.6969, 
                            0.0222, 0.0880}; 
        
        result = new JLabel (" ------------ "); 

        selection = new JComboBox(currencyName); 

        textField = new JTextField();

        textField.setPreferredSize(new Dimension(80, 30));

        submit = new JButton("SUBMIT");

        convertionResult = new JLabel();
        
        add (title); 
        
        add (result); 

        add (selection);

        add (textField);

        add (submit);

        add (convertionResult);

        selection.addActionListener(new ComboListener());
        submit.addActionListener(new ComboListener());
    } 

    public double checkInput(JTextField text) {
        String value = text.getText();
        double valueInput = 0;

        try {
            valueInput = Double.parseDouble(value);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(new JFrame(), "Invalid input. Please only fill with number", "Warning",
            JOptionPane.ERROR_MESSAGE);
        }
        return valueInput;
    }

    private class ComboListener implements ActionListener 
    { 
        public void actionPerformed (ActionEvent event) 
        { 
            int index = selection.getSelectedIndex(); 

            if (event.getSource() == selection) {
                result.setText ("1 " + currencyName[index] + 
                    " = " + rate[index] + " U.S. Dollars"); 
            }
            if (event.getSource() == submit) {
                double ammountOfMoney = checkInput(textField) 
                                        * rate[index];
                convertionResult.setText(" = " + ammountOfMoney + 
                    " U.S. Dollars");
            }
        } 
    } 
}
