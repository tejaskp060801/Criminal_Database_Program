import java.util.UUID;

public class HairSample extends Evidence {
    public String color; 
    public double length; 
    public double thickness; 

    public HairSample(String description, UUID evidenceID, String evidenceType,
        String color, double length, double thickness) {
        super(description, evidenceID, evidenceType);
        this.setColor(color);
        this.setLength(length);
        this.setThickness(thickness);
    }
    public String getColor(){
        return color; 
    }
    public double getLength(){
        return length; 
    }
    public double getThickness(){
        return thickness; 
    }
    public void setColor(String color){
        this.color = color; 
    }
    public void setLength(double length){
        this.length = length; 
    }
    public void setThickness(double thickness){
        this.thickness = thickness; 
    }
    public String toString() {
        return super.toString() 
        + "\n The hair sample color is " +  this.color 
        + "\n The length of the hair sample is " + this.length 
        + "\n The thickness of this hair is " + this.thickness;
    }
}
