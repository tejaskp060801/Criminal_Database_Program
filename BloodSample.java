public class BloodSample extends Evidence {
    public String bloodType; 
    public double bloodVolume; 

    public BloodSample(String description, String bloodType, double bloodVolume) {
        this.description = description; 
        this.evidenceId = UUID.randomUUID(); 
        this.evidenceType = "Blood sample";
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
