import java.util.ArrayList;

public abstract class PersonOfInterest extends Person{
    protected ArrayList<Crime> crimes;
    protected ArrayList<Person> relations;
    protected String statement;

    public String toString(){
        return super.toString()+this.crimes+this.relations+this.statement;
    }

     
}
