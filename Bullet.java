public class Bullet extends Evidence {
    public String type;
    
<<<<<<< HEAD
    public Bullet(String description, String type) {
        this.description = description; 
        this.evidenceId = UUID.randomUUID(); 
        this.evidenceType = "Bullet"; 
        this.type = type; 
=======
    public Bullet() {
        super();
        this.type = type;
>>>>>>> 7d84de8fca1393e8c476be140cb844ac5277240c
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
