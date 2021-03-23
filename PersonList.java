

import java.util.ArrayList;
import java.util.UUID;
import java.util.Iterator;

public class PersonList {
    private static PersonList personlist;
    private ArrayList<Person> people;

    private PersonList() { 
        people = JSONReader.getPeople();
    }

    public static PersonList getPersonList() {
        if (personlist == null) {
            personlist = new PersonList();
        }
        
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

    public Person editPerson(Person oldPerson, Person newPerson) {
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

    public Person searchPerson(UUID id) {

        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person temp = iterator.next();
            if (temp.getPersonID() == id) {
                return temp;
            }
        }
        return null;
    }

    public Person searchPerson(ArrayList<String> parameterChoices, ArrayList<Object> searchParameters) {
        return Person;
    }

    public void getInformation(Person person) {
        person.toString(); 
    }

    public ArrayList<Person> getPeople() {
        return this.people;
    }
}
