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
    private int currXPostition = 0;
    private int currYPosition = 0;
    //--------------------------------------------------------------- 
    // Set up circle and buttons to move it. 
    //--------------------------------------------------------------- 
    public CirclePanel(int width, int height) 
    { 
        // Set coordinates so circle starts in middle 
        x = (width/2)-(CIRCLE_SIZE/2); 
        y = (height/2)-(CIRCLE_SIZE/2); 
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

        if (checkEdge()) {
            
        }
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
            try {
                if (checkEdge()) {
                    x += dx; 
                    currXPostition += dx;
                    y += dy; 
                    currYPosition +=dy;
                    repaint();
                }
            } catch (Exception error) {
                System.out.println("No space available");
            }
             
        } 

        public boolean checkEdge() {
            if (currXPostition >= 0 || currYPosition >= 0) {
                return true;
            }
            return false;
        }
    } 
}