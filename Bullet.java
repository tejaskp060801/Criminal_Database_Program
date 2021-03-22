public class Bullet extends Evidence {
    public String type;
    
    public Bullet(String description, String type) {
        this.description = description; 
        this.evidenceId = UUID.randomUUID(); 
        this.evidenceType = "Bullet"; 
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
