public class BloodSample extends Evidence {
    public String bloodType; 
    public double bloodVolume; 

    public BloodSample() {
        super.description = description; 
        super.evidenceId = evidenceId; 
        super.evidenceType = evidenceType; 
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
        return ""; 
    }
}