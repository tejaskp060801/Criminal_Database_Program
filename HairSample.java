public class HairSample extends Evidence {
    public String color; 
    public double length; 
    public double thickness; 

    public HairSample() {
        this.color = color; 
        super.description = description; 
        super.evidenceId = evidenceId; 
        super.evidenceType = evidenceType; 
        this.length = length; 
        this.thickness = thickness; 
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
        return ""; 
    }
}
