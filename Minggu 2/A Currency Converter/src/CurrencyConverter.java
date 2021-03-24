// *********************************************************************** 
// CurrencyConverter.java 
// 
// Computes the dollar value of the cost of an item in another currency. 
// *********************************************************************** 
import java.awt.*; 
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource; 
public class CurrencyConverter 
{ 
    public static void main (String[] args) 
    { 
        // get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // get 2/3 of the height, and 2/3 of the width
        int height = screenSize.height * 2 / 6;
        int width = screenSize.width * 2 / 6;

        JFrame frame = new JFrame ("Currency Converter"); 
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
        frame.setSize(400,300); 
        frame.setPreferredSize(new DimensionUIResource(width, height));

        RatePanel ratePanel = new RatePanel (); 
        frame.getContentPane().add(ratePanel); 
        frame.pack(); 
        frame.setVisible(true); 
    } 
} 