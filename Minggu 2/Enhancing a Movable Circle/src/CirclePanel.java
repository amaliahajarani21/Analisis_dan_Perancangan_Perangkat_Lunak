// ****************************************************************** 
// CirclePanel.java 
// 
// A panel with a circle drawn in the center and buttons on the 
// bottom that move the circle. 
// ****************************************************************** 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 

public class CirclePanel extends JPanel  

{ 
    private final int CIRCLE_SIZE = 50; 
    private int x,y; 
    private Color c; 
    private int max_X, max_Y;
    private int currXPostition, currYPosition;

    //--------------------------------------------------------------- 
    // Set up circle and buttons to move it. 
    //--------------------------------------------------------------- 
    public CirclePanel(int width, int height) 
    { 
        // Set coordinates so circle starts in middle 
        x = (width/2)-(CIRCLE_SIZE/2); 
        y = (height/2)-(CIRCLE_SIZE/2); 
        currXPostition = x;
        currYPosition = y;
        max_X = width;
        max_Y = height; 
        c = Color.green; 
        
        // Need a border layout to get the buttons on the bottom 
        this.setLayout(new BorderLayout()); 
        
        // Create buttons to move the circle 
        JButton left = new JButton("Left"); 
        JButton right = new JButton("Right"); 
        JButton up = new JButton("Up"); 
        JButton down = new JButton("Down"); 
        
        left.setToolTipText("Moving 20 steps to the left");
        right.setToolTipText("Moving 20 steps to the right");
        up.setToolTipText("Moving 20 steps to the top");
        down.setToolTipText("Moving 20 steps to the bottom");

        // Add listeners and mnemonic to the buttons 
        left.addActionListener(new MoveListener(-20,0)); 
        left.setMnemonic(KeyEvent.VK_1);
        
        right.addActionListener(new MoveListener(20,0)); 
        right.setMnemonic(KeyEvent.VK_R);
        
        up.addActionListener(new MoveListener(0,-20)); 
        up.setMnemonic(KeyEvent.VK_U);
        
        down.addActionListener(new MoveListener(0,20)); 
        down.setMnemonic(KeyEvent.VK_D);
        
        // Need a panel to put the buttons on or they'll be on 
        // top of each other. 
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(left); 
        buttonPanel.add(right); 
        buttonPanel.add(up); 
        buttonPanel.add(down); 

        // Add the button panel to the bottom of the main panel 
        this.add(buttonPanel, "South"); 
    } 

    public boolean checkEdge() {
        if (currXPostition > max_X || currYPosition > max_Y) {
            return false;
        } else if (currXPostition < 0 || currYPosition < 0) {
            return false;
        }
        // } else if (currXPostition == 0 && currYPosition > max_Y || currXPostition == 0 && currYPosition < 0) {
        //     return false;
        // }else if (currYPosition == 0 && currXPostition > max_X || currYPosition == 0 && currXPostition < 0) {
        //     return false;
        // }
        return true;
    }
    
    //--------------------------------------------------------------- 
    // Draw circle on CirclePanel 
    //--------------------------------------------------------------- 
    public void paintComponent(Graphics page) 
    {
        super.paintComponent(page); 
        page.setColor(c); 
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE); 
    } 

    //--------------------------------------------------------------- 
    // Class to listen for button clicks that move circle. 
    //--------------------------------------------------------------- 
    private class MoveListener implements ActionListener 
    { 
        private int dx; 
        private int dy; 
        
        //--------------------------------------------------------------- 
        // Parameters tell how to move circle at click. 
        //--------------------------------------------------------------- 
        public MoveListener(int dx, int dy) 
        { 
            this.dx = dx; 
            this.dy = dy; 
        } 
        
        //--------------------------------------------------------------- 
        // Change x and y coordinates and repaint. 
        //--------------------------------------------------------------- 
        public void actionPerformed(ActionEvent e) 
        { 
            if (checkEdge() == true) {
                currXPostition += dx;
                currYPosition += dy;
                x += dx; 
                y += dy; 
                repaint();
            }  else {
                System.out.println("Please Choose Another Button");
                currXPostition += dx;
                currYPosition += dy;
                x += dx; 
                y += dy;
            }
            System.out.println( "X is ="+ currXPostition + " Y is: " + currYPosition);
        } 
    } 
}