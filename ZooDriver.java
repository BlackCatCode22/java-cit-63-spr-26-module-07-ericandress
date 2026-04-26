import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
// Allows reading and writing files

//to get today's date

// Used to store lists of animals and names
import java.util.ArrayList;
public class ZooDriver {

    static int numOfHyenas = 0;
    static int numOfLions = 0;
    static int numOfTigers = 0;
    static int numOfBears = 0;

    public static void main(String[] args) {
// starting point of the code

// List to store all animals
            ArrayList<Animal> animals = new ArrayList<>();

// names from file into a list
            ArrayList<String> names = loadNames("animalNames.txt");

// Get today's date
            String arrivalDate = LocalDate.now().toString();
            

        try (BufferedReader br = new BufferedReader(new FileReader("arrivingAnimals.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    animals.add(buildAnimal(line, names, arrivalDate));
                }
            }

            writeOutput(animals);
            // write results to output all of the data
            System.out.println("zooPopulation.txt created!");
// end the code here
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Animal buildAnimal(String line, ArrayList<String> names, String arrivalDate) {

        int age = Integer.parseInt(line.split(" ")[0]);

        String sex = line.toLowerCase().contains("female") ? "female" : "male";

        String species = getSpecies(line);

        String season = getSeason(line);

        String color = line.split(",")[2].replace(" color", "").trim();

        int weight = Integer.parseInt(line.split(",")[3].trim().split(" ")[0]);

        String origin = getOrigin(line);

        String birthDate = genBirthDay(age, season);

        String id = genUniqueID(species);
// get all of the information
        String name;
        if (names.isEmpty()) {
            name = "Unnamed";
        } else {
            name = names.remove(0);
        }

        return new Animal(id, name, species, sex, color, weight, birthDate, origin, arrivalDate);
    }

    public static String getSpecies(String line) {
        String l = line.toLowerCase();

        if (l.contains("hyena")) return "hyena";
        if (l.contains("lion")) return "lion";
        if (l.contains("tiger")) return "tiger";
        if (l.contains("bear")) return "bear";

        return "unknown";
    }

    public static String getSeason(String line) {
        String l = line.toLowerCase();

        if (l.contains("spring")) return "spring";
        if (l.contains("summer")) return "summer";
        if (l.contains("fall")) return "fall";
        if (l.contains("winter")) return "winter";
// the seasons
        return "";
    }

    public static String getOrigin(String line) {
        String[] parts = line.split(",");

        if (parts.length >= 6) {
            return parts[4].replace("from ", "").trim() + ", " + parts[5].trim();
        } else if (parts.length >= 5) {
            return parts[4].replace("from ", "").trim();
        }

        return "unknown";
    }

    public static String genBirthDay(int age, String season) {
        int year = LocalDate.now().getYear() - age;

        switch (season) {
            case "spring":
                return year + "-03-21";
            case "summer":
                return year + "-06-21";
            case "fall":
                return year + "-09-21";
            case "winter":
                return year + "-12-21";
            default:
                return year + "-01-01";
        }
    }

    public static String genUniqueID(String species) {
        // unique id for the species

        if (species.equals("hyena")) {
            numOfHyenas++;
            return String.format("Hy%02d", numOfHyenas);

        } else if (species.equals("lion")) {
            numOfLions++;
            return String.format("Li%02d", numOfLions);

        } else if (species.equals("tiger")) {
            numOfTigers++;
            return String.format("Ti%02d", numOfTigers);

        } else if (species.equals("bear")) {
            numOfBears++;
            return String.format("Be%02d", numOfBears);
        }

        return "UN00";
    }

    public static ArrayList<String> loadNames(String file) {
        ArrayList<String> names = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    names.add(line.trim());
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading names: " + e.getMessage());
        }

        return names;
    }

    public static void writeOutput(ArrayList<Animal> animals) {
        try (PrintWriter writer = new PrintWriter("zooPopulation.txt")) {

            writer.println("Hyena Habitat:");
            for (Animal animal : animals) {
                if (animal.getSpecies().equals("hyena")) {
                    writer.println(animal);
                }
            }

            writer.println();
            writer.println("Lion Habitat:");
            for (Animal animal : animals) {
                if (animal.getSpecies().equals("lion")) {
                    writer.println(animal);
                }
            }

            writer.println();
            writer.println("Tiger Habitat:");
            for (Animal animal : animals) {
                if (animal.getSpecies().equals("tiger")) {
                    writer.println(animal);
                }
            }

            writer.println();
            writer.println("Bear Habitat:");
            for (Animal animal : animals) {
                if (animal.getSpecies().equals("bear")) {
                    writer.println(animal);
                }
            }

        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}