package Variables;

import Main.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Recipe {

    public static String name;
    public static List<Herb> composition;
    public static LocalDate dateDue;
    public static String properties;
    public static String limitations;
    public static String restrictions;


    public Recipe(String name, List<Herb> composition, LocalDate dateDue,
                  String properties, String limitations, String restrictions) {
        this.name = name;
        this.composition = composition;
        this.dateDue = dateDue;
        this.properties = properties;
        this.limitations = limitations;
        this.restrictions = restrictions;
    }


    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Recipe.name = name;
    }

    public List<Herb> getComposition() {
        return composition;
    }

    public void setComposition(List<Herb> composition) {
        this.composition = composition;
    }

    public static LocalDate getDateDue() {
        return dateDue;
    }

    public static void setDateDue(LocalDate dateDue) {
        Recipe.dateDue = dateDue;
    }

    public static String getProperties() {
        return properties;
    }

    public static void setProperties(String properties) {
        Recipe.properties = properties;
    }

    public static String getLimitations() {
        return limitations;
    }

    public static void setLimitations(String limitations) {
        Recipe.limitations = limitations;
    }

    public static String getRestrictions() {
        return restrictions;
    }

    public static void setRestrictions(String restrictions) {
        Recipe.restrictions = restrictions;
    }


    public static String parseIntoString(List<Herb> herbs) {
        String parsed = "";
        for (int i = 0; i < Main.herbs.size(); i++) {
            parsed += herbs.get(i).getName() + ";";

        }
        return parsed;
    }

    public static List<Herb> parseIntoList(String parsed) {
        List<Herb> herbs = new ArrayList<>();
        String[] names = parsed.split(";");
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < Main.herbs.size(); j++) {
                if (names[i].equals(Main.herbs.get(j).getName())) {
                    herbs.add(Main.herbs.get(j));

                }

            }
        }
        return herbs;
    }

    @Override
    public String toString() {
        return name;
    }
}


