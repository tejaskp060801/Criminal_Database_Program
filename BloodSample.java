import java.util.UUID;

public class BloodSample extends Evidence {
    public String bloodType; 
    public double bloodVolume; 

    public BloodSample(String description, UUID evidenceID, String evidencetype,
        String bloodType, double bloodVolume) {
        super(description, evidenceID, evidencetype);
        this.setType(bloodType);
        this.setBloodVolume(bloodVolume);
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
        return super.toString() 
        + "\n The blood type of this sample is " +this.bloodType 
        + "\n the amount of blood is " +this.bloodVolume; 
    }
}
