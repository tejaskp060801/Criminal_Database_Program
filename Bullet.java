public class Bullet extends Evidence {
    public String type;
    
    public Bullet() {
        super.description = description; 
        super.evidenceId = evidenceId; 
        super.evidenceType = evidenceType; 
        this.type = type; 
    }
    public String getType() {
        return this.type; 
    }
    public void setType(String type) {
        this.type = type; 
    }
    public String toString(){
        return ""; 
    }
}
