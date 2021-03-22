import java.util.UUID;

public class Gun extends Evidence {
    public String gunType;
    public String model;
    public String bulletType;
    public int yearMade;

    public Gun(String description, String gunType, String model, Bullet bulletType, int yearMade) {
        this.description = description;
        this.evidenceId = UUID.randomUUID();
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

    public void setGunType(String type) {
        this.gunType = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBulletType(Bullet b) {
        this.bulletType = b;
    }

    public void setYearMade(int year) {
        this.yearMade = year;
    }   

    public String toString() {
        return "";
    }


}