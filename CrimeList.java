import java.util.ArrayList;
import java.util.UUID;
import java.util.Iterator;
import java.util.List;


public class CrimeList {
    private static CrimeList crimelist;
    private ArrayList<Crime> crimes;

    private CrimeList() {
        crimes = JSONReader.getCrimes();
    }

    public static CrimeList getCrimeList() {
        if (crimelist == null) {
            crimelist = new CrimeList();
        }
        
        return crimelist;
    }

    public void addCrime(Crime crime) {
        crimelist.addCrime(crime);
    }

    public boolean removeCrime(Crime crime ) {
        for(int i =0; i < crimes.size(); i++){
            if(crimes.get(i) == crime){
                crimes.remove(i);
                return true;
            }
        }
        return false;
    }

    public Crime editCrime(Crime oldCrime, Crime newCrime) {
        Crime temp = searchCrime(oldCrime);
        if (temp == null) {
            return null;
        } 
        removeCrime(temp);
        addCrime(newCrime);
        return newCrime;
    }

    public Crime searchCrime(Crime crime) {
        return searchCrime(crime.getcasenumber());
    }

    public Crime searchCrime(UUID id){
        Iterator<Crime> iterator = crimes.iterator();
        while (iterator.hasNext()){
            Crime temp = iterator.next();
            if(temp.getcasenumber().compareTo(id) == 0){
                return temp;
            }
        }
        System.out.println("Sorry, this crime does not exist");
        return null;
    }

    /*
    public Crime searchCrime(UUID id) {
        for (int i = 0; i < crimes.size(); i++) {
            if (crimes.get(i).getcasenumber().compareTo(id) == 0) {
                return crimes.get(i);
            }
        }
        System.out.println("Sorry, this crime does not exist");
        return null;
    }
    */

    public ArrayList<Crime> searchCrime(ArrayList<String> parameterChoices, ArrayList<String> searchParameters){
        ArrayList<Crime> temp = crimelist.getCrimes();
        for(int i = 0; i < crimes.size(); i++)
        {
            Crime current = crimes.get(i);
            for(int j =0; j < searchParameters.size(); j++)
            {
                
                if(parameterChoices.get(j).equals("1"))//UUID
                {
                    UUID id = UUID.fromString(searchParameters.get(j));
                    if(current.getcasenumber().compareTo(id) != 0) 
                    {
                        temp.remove(current);
                        break;
                    }
                }

                if(parameterChoices.get(j).equals("2"))//STRING
                {

                    if(searchParameters.get(j) != current.getTitle()) 
                    {
                        temp.remove(current);
                        break;
                    }
                }
                
                if(parameterChoices.get(j).equals("3")) 
                {
                    UUID id = UUID.fromString(searchParameters.get(j));                    
                    if(id != current.getcasenumber()) {
                        temp.remove(current);
                        break;
                    }
                
                }

                if(parameterChoices.get(j).equals("4"))//STRING
                {
                    if(searchParameters.get(j) != current.getLocation()) 
                    {
                        temp.remove(current);
                        break;
                    }
                }

                if(parameterChoices.get(j).equals("5")) 
                {
                   String crimeType = searchParameters.get(j);
                   ArrayList<TypeOfCrime> crimeTypeList = current.getTypeOfCrime();
                   for(int t=0; t<crimeTypeList.size(); t++) {
                        TypeOfCrime a = crimeTypeList.get(t);
                        if(a.toString() == crimeType) {
                            crimeTypeList.remove(a);
                        }
                   }                    
                    if(crimeTypeList.isEmpty()) {
                        temp.remove(current);
                        break;
                    }
                    
                }


                if(parameterChoices.get(j).equals("6")) //String date
                {
                    if(searchParameters.get(j) != current.getDate()) 
                    {
                        temp.remove(current);
                        break;
                    }
                    /*
                    String search = searchParameters.get(j);
                    if(current.getDate().contains(search))
                        break;
                    else{
                        temp.remove(current);
                        break;
                    }
                    */

                    
                }

                if(parameterChoices.get(j).equals("7"))
                {
                    UUID id = UUID.fromString(searchParameters.get(j));  
                    ArrayList<Evidence> e = current.getEvidence();
                    for(int t=0; t<e.size(); t++) {
                        Evidence ev = e.get(t);
                        if(ev.getID() != id) {
                            e.remove(ev);
                        }
                    }
                    if(e.isEmpty()) {
                        temp.remove(current);
                        break;
                    }                    
                }


             }
        }
        if(temp.isEmpty()){
            return null;
        }
        else{
            return temp;
        }
    
    }

   
    public void getInformation(Crime crimes){
        crimes.toString();
    }

    public ArrayList<Crime> getCrimes() {
        return (ArrayList) this.crimes.clone();  //  PassbyRef
    }
}
    









