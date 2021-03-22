public class Bullet extends Evidence {
    public String type;
    
    public Bullet() {
        super();
        this.type = type;
    }
    public String getType() {
        return this.type; 
    }
    public void setType(String type) {
        this.type = type; 
    }
    public String toString(){
        return super.toString() + this.type; 
    }
}
