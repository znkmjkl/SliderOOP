package slideroop;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderOOP {
    public static Subject subject = new Subject();
    public static class SliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            subject.setState(source.getValue());            
        }    
    }

        
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("SliderOOP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(10, 10));
        
        
        
        
        for(int i = 0; i < 9; i++){
            SliderObserver sliderObs = new SliderObserver(false, subject);
            subject.attach(sliderObs);
            sliderObs.getSlider().addChangeListener(new SliderListener());
            frame.add(sliderObs.getSlider());
        }
        
        
        SliderObserver sliderOposite = new SliderObserver(true, subject);
        subject.attach(sliderOposite);
        sliderOposite.getSlider().addChangeListener(new SliderListener());
        frame.add(sliderOposite.getSlider());
        
        
        frame.setVisible(true);
    }
    
}
