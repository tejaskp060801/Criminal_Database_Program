

import java.util.ArrayList;

public class PersonList {
    private PersonList personlist;
    private ArrayList<Person> people;

    private PersonList() {
        this.personlist = personlist; 
        this.people = people; 
    }

    public PersonList getPersonList() {
        return personlist;
    }

    public void addPerson(Person p) {
        for(int i = 0; i<1; i++) {
            people.add(people.size()+1, p);
        }
        personlist.addPerson(p);
    }

    public boolean removePerson(Person p) {
        boolean checker; 
        for(int i = 0; i< people.size(); i++) {
            if(people.get(i) == p){
                checker = true; 
            }
        }
        checker = false; 

        if(checker == true) {
            removePerson(p); 
            for(int i = 0; i<people.size(); i++)
            {
                people.remove(i); 
            }
        }

        return checker; 
    }

    public Person editPerson(Person person) {
        searchPerson(person); 
        
        return person;
    }

    public Person searchPerson(Person person) {
        boolean found = false; 
        for(int i = 0; i<people.size(); i++) {
            if(people.get(i).getPersonID() == person.getPersonID()) {
                found = true;  
            }
        }

        if(found == false) {
            System.out.println("Sorry this person does not exist");  
        }
        return person; 
    }

    public void getInformation(Person person) {
        person.getAddress(); 
        person.getAge(); 
        person.getClothing(); 
        person.getHairColorNatural(); 
        person.getHairColorUnNatural(); 
        person.getHeight(); 
        person.getWeight(); 
        person.getIsUSCitizen(); 
        person.getName(); 
        person.getOrganization(); 
        person.getPersonID(); 
        person.getProfession(); 
        person.getRace(); 
        person.getSkinColor(); 
        person.getShoeSize(); 
        person.getTattoo(); 
        person.getTattooDescription(); 
    }
}
