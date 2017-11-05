import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    static JFrame jFrame = getJFame();

    static JComponent jComponent = new MyComponent();

    public static void main(String[] args) {

        jComponent.setBackground(Color.white);

        jFrame.add(jComponent);

        jFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                MyComponent.xCoord = mouseEvent.getX();
                MyComponent.yCoord = mouseEvent.getY();
                jComponent.repaint();
            }
        });

        jFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (jComponent.getBackground().equals(Color.white)) jComponent.setBackground(Color.blue);
                else jComponent.setBackground(Color.white);
            }
        });

    }

    static class MyComponent extends JComponent{
        public static int xCoord;
        public static int yCoord;
        @Override
        protected void paintComponent(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            Font font = new Font(null, Font.PLAIN, 20);
            graphics2D.setFont(font);
            graphics2D.setPaint(Color.red);
            graphics2D.drawString("x = " + xCoord + "; y = " + yCoord, 50, 50);
        }

    }

    static JFrame getJFame(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setBounds(600,300,750,500);
        jFrame.setTitle("My App");
        return jFrame;
    }

}
