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

    public abstract void addPerson(Person p); 
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
    public void setName(String firstName, String lastName) {
        this.firstName = firstName; 
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
    public void PersonID (UUID id) {
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
    public void setHairColorUnNatural(String UnNatHairCol) {
        this.hairColorUnNatural = UnNatHairCol; 
    }
    public void setClothing(String clothing) {
        this.clothing = clothing; 
    }
    public void setTattoo(boolean tattoo) {
        this.tattoo = tattoo; 
    }
    public void setTattooDescription(String tattoDesc) {
        this.tattooDescription = tattoDesc; 
    }
    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize; 
    }
    public void setIsUSCitizen(boolean isUsCitizen) {
        this.isUSCitizen = isUsCitizen; 
    }
    public String toString() {
        return "The persons name is " + this.firstName + " " + this.lastName 
        + "\n The persons age is" + this.age + "\n the persons gender is " + this.gender + "\n the persons race is " + this.race
        + "\n The persons UUID is " +this.PersonID + "\n The persons address is " + this.address + this.profession + this.height + this. weight
        + this.skinColor + this.hairColorNatural + this.hairColorUnNatural + this.clothing + this.tattoo + this.tattooDescription + this.shoeSize
        + this.isUSCitizen + this.crimeOrganization + this.personType; 
    }
}
