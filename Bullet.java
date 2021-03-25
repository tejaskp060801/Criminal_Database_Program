import java.util.UUID;

public class Bullet extends Evidence {
    public String type;
    
    public Bullet(String description, UUID evidenceID, String evidencetype,
                    String bullettype) {
        super(description, evidenceID, evidencetype);
        this.setType(bullettype);
    }
    public String getType() {
        return this.type; 
    }
    public void setType(String type) {
        this.type = type; 
    }
    public String toString(){
        return super.toString() 
        + "\n The type of bullet is " + this.type; 
    }
}
