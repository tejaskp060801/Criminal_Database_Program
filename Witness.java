public class Witness extends PersonOfInterest {
    public boolean willTestify;

    public Witness(){
        super();
        this.willTestify = willTestify; 
    }

    public String toString(){
        return super.toString() + this.willTestify;
    }
    
}
