

public class Gun extends Evidence {
    public String gunType;
    public String model;
    public Bullet bulletType;
    public int yearMade;

    public Gun() {

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