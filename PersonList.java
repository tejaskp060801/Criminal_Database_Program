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

    public ArrayList<Person> searchPerson(ArrayList<String> parameterChoices, ArrayList<String> searchParameters) {
    //.get(index) = It returns the element at the specified index in the given list.
    //had to change it from people[j] and parameterChoices[j] and searchParameters[j] cause it gave errors
        ArrayList<Person> temp = personlist.getPeople();
        for(int i = 0; i< people.size(); i++)
        {
            Person current = people.get(i);
            for(int j = 0; j < searchParameters.size(); j++)
            {
                
                if(parameterChoices.get(j).equals("1"))
                {
                    if(searchParameters.get(j) != current.getFirstName())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("2"))
                {

                    if(searchParameters.get(j) != current.getLastName())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("3"))
                {
                    int age = Integer.parseInt(searchParameters.get(j));
                    if(age != current.getAge()) 
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("4"))
                {
                    if(searchParameters.get(j) != current.getGender())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("5"))
                {
                    if(searchParameters.get(j) != current.getRace())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("6"))
                {
                    UUID id = UUID.fromString(searchParameters.get(j));
                    if(id !=  current.getPersonID())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("7"))
                {
                    if(searchParameters.get(j) != current.getAddress())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("8"))
                {
                    if(searchParameters.get(j) != current.getProfession())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("9"))
                {
                    double height = Double.parseDouble(searchParameters.get(j));
                    if(height != current.getHeight()) //double
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("10"))
                {
                    double weight = Double.parseDouble(searchParameters.get(j));
                    if(weight != current.getWeight()) //double
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("15"))
                {
                    if(searchParameters.get(j) != current.getSkinColor())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("16"))
                {
                    if(searchParameters.get(j) != current.getHairColorNatural())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("15"))
                {
                    if(searchParameters.get(j) != current.getHairColorUnNatural())
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("14"))
                {
                    String search = searchParameters.get(j);
                    if(current.getClothing().contains(search))
                        break;
                    else {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("15"))
                {
                    String search = searchParameters.get(j);
                    if(current.getTattooDescription().contains(search)) 
                        break;
                    else {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("16"))
                {
                    double shoeSize = Double.parseDouble(searchParameters.get(j));
                    if(shoeSize != current.getShoeSize())  
                    {
                        temp.remove(current);
                        break;
                    }
                }
                if(parameterChoices.get(j).equals("17"))
                {
                    String search = searchParameters.get(j);
                    if(current.getOrganization().contains(search))
                        break;
                    else {
                        temp.remove(current);
                        break;
                    }
                }
                
            }
        }
        if(temp.isEmpty()) {
            return null;
        }

        else {
            return temp;
        }
    }

    public void getInformation(Person person) {
        person.toString(); 
    }

    public ArrayList<Person> getPeople() {
        return (ArrayList) this.people.clone();  //  Changes made to objects inside this arraylist will be reflected in PersonList -- passbyref
    }
}
