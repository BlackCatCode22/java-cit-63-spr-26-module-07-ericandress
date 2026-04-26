// zoo midterm assignment
// cit 63
// es
public class Animal {
    private String uniqueID;
    private String name;
    private String species;
    private String sex;
    private String color;
    private int weight;
    private String birthDate;
    private String origin;
    private String arrivalDate;
// the strings of this code
    public Animal(String uniqueID, String name, String species, String sex,
                  String color, int weight, String birthDate,
                  String origin, String arrivalDate) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.color = color;
        this.weight = weight;
        this.birthDate = birthDate;
        this.origin = origin;
        this.arrivalDate = arrivalDate;
    }
// the traits of the animals
    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getSex() {
        return sex;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getOrigin() {
        return origin;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return uniqueID + "; " + name
                + "; birth date: " + birthDate
                + "; " + color + " color"
                + "; " + sex
                + "; " + weight + " pounds"
                + "; from " + origin
                + "; arrived " + arrivalDate;
    }
}
