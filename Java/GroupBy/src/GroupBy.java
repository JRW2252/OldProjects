import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class GroupBy {

    public static void main(String args[]) throws IOException {
        List<Person> people = new ArrayList<>();
        people.add(new Person("jon", "location1", 20));
        people.add(new Person("jonny", "location2", 21));
        people.add(new Person("john", "location3", 22));
        people.add(new Person("jone", "location4", 23));
        people.add(new Person("jones", "location5", 24));

        Map<String, List<Person>> personByCity = new HashMap<>();
        for (Person p : people) {
            if (!personByCity.containsKey(p.getCity())) {
                personByCity.put(p.getCity(), new ArrayList<>());
            }
            personByCity.get(p.getCity()).add(p);
        }
        System.out.println("Person by cities:" + personByCity);

        personByCity = people.stream().collect(Collectors.groupingBy(Person::getCity));

        Map<Integer,List <Person> > personByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));

        System.out.println("Person by age: " +personByAge);

    }
}
class Person {
    private String name;
    private String city;
    private int age;

    public Person(String name, String city, int age){
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName (){
        return name;
    }

    public void setCity () {
        this.city = city;
    }

    public void setAge(){
        this.age = age;
    }

    public String getCity(){
        return city;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s(%s,%d)", name, city, age);
    }

    @Override public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (this.age != other.age) { return false; }

        return true;
    }
}