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
        return ""; 
    }
    public int getAge() {
        return 5; 
    }
    public String getRace() {
        return ""; 
    }
    public UUID getPersonID() {
        UUID uuid = UUID.randomUUID();
        return uuid;          
    }
    public String getAddress() {
        return ""; 
    }
    public String getProfession() {
        return ""; 
    }
    public double getHeight() {
        return 0.0; 
    }
    public double getWeight() {
        return 0.0; 
    }
    public String getHairColor() {
        return "";
    }
    public String getHairColorNatural() {
        return ""; 
    }
    public String getHairColorUnNatural () {
        return ""; 
    }
    public String getClothing() {
        return ""; 
    }
    public boolean getTattoo() {
        return true; 
    }
    public String getTattooDescription() {
        return ""; 
    }
    public double getShoeSize() {
        return 0.0; 
    }
    public boolean getIsUSCitizen() {
        return true;
    }
    public String getOrganization() {
        return "";
    }
    public void setName() {
        
    }
    public void setAge(int age) {
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
    public void addToDataBase() {

    }
    public void editPerson() {

    }
    public String toString() {
        return ""; 
    }
}
