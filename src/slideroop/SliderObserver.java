package slideroop;

import javax.swing.JSlider;

public class SliderObserver implements Observer{
    private JSlider slider;
    private Subject subject;
    public SliderObserver(boolean inverted,Subject subject){
        this.slider = new JSlider();
        this.slider.setValue(0);
        this.subject = subject;
        slider.setInverted(inverted);
        
    }
    public JSlider getSlider(){
        return slider;
    }
    
    public void update() {
        this.slider.setValue(subject.getState());
    }
    
}
