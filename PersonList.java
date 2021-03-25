

import java.util.ArrayList;
import java.util.UUID;
import java.util.Iterator;
import java.util.List;

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

    public void addPerson(Person person) {
        personlist.addPerson(person);
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
        Person temp = searchPerson(oldPerson);
        if(temp == null){
            return null;
        }

        removePerson(temp);
        addPerson(newPerson);
        return newPerson;
    }

    public Person searchPerson(Person person) {
        return searchPerson(person.getPersonID());
    }

    public Person searchPerson(UUID id) {
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person temp = iterator.next();
            if (temp.getPersonID().compareTo(id) == 0) {
                return temp;
            }
        }
        System.out.println("Sorry this person does not exist");
        return null;
    }

    public Person searchPerson(ArrayList<String> parameterChoices, ArrayList<Object> searchParameters) {
    //.get(index) = It returns the element at the specified index in the given list.
    //had to change it from people[j] and parameterChoices[j] and searchParameters[j] cause it gave errors
        for(int i = 0; i< people.size(); i++)
        {
            Person temp = people.get(i);
            for(int j = 0; j < searchParameters.size(); j++)
            {
                
                if(parameterChoices.get(j) == "1")
                {

                    if(searchParameters.get(j) == temp.getFirstName())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "2")
                {

                    if(searchParameters.get(j) == temp.getLastName())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "3")
                {
                    if(searchParameters.get(j) == temp.getAge()) 
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "4")
                {
                    if(searchParameters.get(j) == temp.getGender())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "5")
                {
                    if(searchParameters.get(j) == temp.getRace())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "6")
                {
                    if(searchParameters.get(j) ==  temp.getPersonID())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "7")
                {
                    if(searchParameters.get(j) == temp.getAddress())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "8")
                {
                    if(searchParameters.get(j) == temp.getProfession())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "9")
                {
                    if(searchParameters.get(j) == temp.getHeight()) //double
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "10")
                {
                    if(searchParameters.get(j) == temp.getWeight()) //double
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "11")
                {
                    if(searchParameters.get(j) == temp.getSkinColor())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "12")
                {
                    if(searchParameters.get(j) == temp.getHairColorNatural())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "13")
                {
                    if(searchParameters.get(j) == temp.getHairColorUnNatural())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "14")
                {
                    if(searchParameters.get(j) == temp.getClothing())
                    {
                        return temp;
                    }
                }
                if(parameterChoices[j] == "15")
                {
                    if(searchParameters.get(j) == temp.getTattoo())    //boolean
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "16")
                {
                    if(searchParameters.get(j) == temp.getShoeSize())  ///double
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "17")
                {
                    if(searchParameters.get(j) == temp.getIsUSCitizen())  ////boolean
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "18")
                {
                    if(searchParameters.get(j) == temp.getOrganization())
                    {
                        return temp;
                    }
                }
                if(parameterChoices.get(j) == "19")
                {
                    if(searchParameters.get(j) == temp.getType())
                    {
                        return temp;
                    }
                }
             }
         }
    }

    public void getInformation(Person person) {
        person.toString(); 
    }

    public ArrayList<Person> getPeople() {
        return (ArrayList) this.people.clone();  //  Changes made to objects inside this arraylist will be reflected in PersonList -- passbyref
    }
}
