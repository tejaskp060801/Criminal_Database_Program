public class BloodSample extends Evidence {
    public String bloodType; 
    public double bloodVolume; 

<<<<<<< HEAD
    public BloodSample(String description, String bloodType, double bloodVolume) {
        this.description = description; 
        this.evidenceId = UUID.randomUUID(); 
        this.evidenceType = "Blood sample";
=======
    public BloodSample() {
        super(); 
>>>>>>> 7d84de8fca1393e8c476be140cb844ac5277240c
        this.bloodType = bloodType; 
        this.bloodVolume = bloodVolume; 
    }

    public String getBloodType() {
        return bloodType; 
    }
    public double getBloodAmount() {
        return bloodVolume; 
    }
    public void setType(String bloodType){
        this.bloodType = bloodType; 
    }
    public void setBloodVolume(double bloodVolume) {
        this.bloodVolume = bloodVolume; 
    }
    public String toString() {
        return super.toString() + this.bloodType + this.bloodVolume; 
    }
}
