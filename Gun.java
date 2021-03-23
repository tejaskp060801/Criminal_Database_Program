import java.util.UUID;

public class Gun extends Evidence {
    public String gunType;
    public String model;
    public String bulletType;
    public int yearMade;

    public Gun(String description, UUID evidenceID, String evidenceType,
        String gunType, String model, String bulletType, int yearMade) {
        super(description, evidenceID, evidenceType);
        this.gunType = gunType;
        this.model = model;
        this.bulletType = bulletType;
        this.yearMade = yearMade;
    }

    public String getGunType() {
        return this.gunType;
    }

    public String getModel() {
        return this.model;
    }

    public Bullet getBulletType() {
        return this.bulletType;
    }

    public int getYearMade() {
        return this.yearMade;
    }

    public void setGunType(String gunType) {
        this.gunType = gunType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBulletType(Bullet bulletType) {
        this.bulletType = bulletType;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }   

    public String toString() {
        return super.toString() + this.gunType + this.model +
        this.bulletType + this.yearMade;
    }


}