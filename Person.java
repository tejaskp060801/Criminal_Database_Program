import java.util.UUID;
/**
 * @author Tejas Padmanabhan
 * This is the person class with atrributes
 */
public abstract class Person {
    protected String firstName; 
    protected String lastName;
    protected int age; 
    protected String gender; 
    protected String race; 
    public UUID PersonID; 
    protected String address; 
    protected String profession; 
    protected double height; 
    protected double weight; 
    protected String skinColor; 
    protected String hairColorNatural; 
    protected String hairColorUnNatural; 
    protected String clothing; 
    protected boolean tattoo; 
    protected String tattooDescription; 
    protected double shoeSize; 
    protected boolean isUSCitizen; 
    protected String crimeOrganization; 
    protected Person personType;

    public Person(String firstName, String lastName, int age, String gender, String race, UUID id, String address,
            String profession, double height, double weight, String skinCol, String natHairCol, String unNatHairCol,
            String clothing, boolean hasTattoo, String tatDesc, double shoeSize, boolean isUsCitizen,
            String org) {
                this.setAddress(address);
                this.setAge(age);
                this.setPersonID(id); 
                this.setClothing(clothing);
                this.setCriminalOrganization(org);
                this.setFirstName(firstName);
                this.setGender(gender);
                this.setHairColorNatural(natHairCol);
                this.setHairColorUnNatural(unNatHairCol);
                this.setHeight(height);
                this.setIsUSCitizen(isUsCitizen);
                this.setLastName(lastName);
                this.setProfession(profession);
                this.setRace(race);
                this.setShoeSize(shoeSize);
                this.setSkinColor(skinCol);
                this.setTattoo(tattoo);
                this.setTattooDescription(tatDesc);
    }
    public String getName() {
        return this.firstName + " " + this.lastName; 
    }
    public int getAge() {
        return this.age; 
    }
    public String getRace() {
        return this.race; 
    }
    public UUID getPersonID() {
        //UUID personIUuid= UUID.randomUUID();
        //PersonID = personIUuid; 
        return PersonID;          
    }
    public String getAddress() {
        return this.address; 
    }
    public String getProfession() {
        return this.profession; 
    }
    public double getHeight() {
        return this.height; 
    }
    public double getWeight() {
        return this.weight; 
    }
    public String getSkinColor() {
        return this.skinColor;
    }
    public String getHairColorNatural() {
        return this.hairColorNatural;  
    }
    public String getHairColorUnNatural () {
        return this.hairColorUnNatural; 
    }
    public String getClothing() {
        return this.clothing; 
    }
    public boolean getTattoo() {
        return this.tattoo; 
    }
    public String getTattooDescription() {
        return this.tattooDescription; 
    }
    public double getShoeSize() {
        return this.shoeSize; 
    }
    public boolean getIsUSCitizen() {
        return true;
    }
    public String getOrganization() {
        return this.crimeOrganization;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName; 
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        if(age <= 0) {
            System.out.println("please print a valid age"); 
        }
        this.age = age; 
    }
    public void setGender(String gender) {
        this.gender = gender; 
    }
    public void setRace(String race) {
        this.race = race; 
    }
    public void setPersonID (UUID id) {
        id = PersonID; 
    }
    public void setAddress(String address) {
        this.address = address; 
    }
    public void setProfession(String profession) {
        this.profession = profession; 
    }
    public void setHeight(double height) {
        this.height = height; 
    }
    public void setWeight(double weight) {
        this.weight = weight; 
    }
    public void setSkinColor(String skinCol) {
        this.skinColor = skinCol; 
    }
    public void setHairColorNatural(String natHairCol) {
        this.hairColorNatural = natHairCol; 
    }
    public void setHairColorUnNatural(String unNatHairCol) {
        this.hairColorUnNatural = unNatHairCol; 
    }
    public void setClothing(String clothing) {
        this.clothing = clothing; 
    }
    public void setTattoo(boolean tattoo) {
        this.tattoo = tattoo; 
    }
    public void setTattooDescription(String tatDesc) {
        this.tattooDescription = tatDesc; 
    }
    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize; 
    }
    public void setIsUSCitizen(boolean isUsCitizen) {
        this.isUSCitizen = isUsCitizen; 
    }
    public void setCriminalOrganization(String org) {
        this.crimeOrganization = org;
    }
    public void editPerson() {
        
    }
    public String toString() {
        return "The persons name is " + this.firstName + " " + this.lastName 
        + "\n The persons age is" + this.age + "\n the persons gender is " + this.gender + "\n the persons race is " + this.race
        + "\n The persons UUID is " +this.PersonID + "\n The persons address is " + this.address + this.profession + this.height + this. weight
        + this.skinColor + this.hairColorNatural + this.hairColorUnNatural + this.clothing + this.tattoo + this.tattooDescription + this.shoeSize
        + this.isUSCitizen + this.crimeOrganization + this.personType; 
    }
}
