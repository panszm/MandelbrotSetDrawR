import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.*;

class MandelWindow{

    int INITIAL_WIDTH = 200;
    int INITIAL_HEIGHT = 200;
    MandelsetDrawR msd;
    JFrame window = new JFrame("MandelbrotSetDrawR");
    
    MandelWindow(int precision, double bound){
        try{
            window.setIconImage(ImageIO.read(getClass().getResource("MBSDIcon.png")));
        }catch(Exception e){e.printStackTrace();}
        window.setResizable(true);
        Panel settingsMenu = new Panel();
        settingsMenu.setVisible(true);
        settingsMenu.setBounds(0,0,100,120);
        TextField tf1 = new TextField("offsetX");TextField tf2 = new TextField("offsetY");TextField tf3 = new TextField("zoom");
        Button reloadButton = new Button("RELOAD");
        reloadButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    msd.setOffsetX(Double.parseDouble(tf1.getText()));
                    msd.setOffsetY(Double.parseDouble(tf2.getText()));
                    msd.setZoom(Double.parseDouble(tf3.getText()));
                    msd.repaint();
                }  
            });  
        settingsMenu.add(tf1);settingsMenu.add(tf2);settingsMenu.add(tf3);
        settingsMenu.add(reloadButton);
        window.add(settingsMenu);
        msd = new MandelsetDrawR(precision, bound);
        window.add(msd);
        window.setMinimumSize(new DimensionUIResource(INITIAL_WIDTH,INITIAL_HEIGHT));
        window.setFocusable(true);
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void start(){
        window.show();  
    }
    
}