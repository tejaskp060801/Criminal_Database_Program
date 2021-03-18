public class Victim extends PersonOfInterest {
    public boolean willTestify;

    public Victim(){
        super(); 
        this.willTestify = willTestify;
    }

    public String toString(){
        return super.toString() + this.willTestify;
    }
}
