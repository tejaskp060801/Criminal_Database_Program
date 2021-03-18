

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
        people.add(p);
    }

    public boolean removePerson(Person p) { 
        for(int i = 0; i< people.size(); i++) {
            if(people.get(i) == p){
                people.remove(i); 
                return true;
            }
        }
        return false; 
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
        person.toString(); 
    }
}
