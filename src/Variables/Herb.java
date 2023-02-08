package Variables;

import java.time.LocalDate;
import java.util.List;

public class Herb {

    public String name;
    public int quantity;
    public LocalDate dateOfPurchase;
    public String properties;
    public String limitations; //probably would be best to include this as someone who SHOULD not take the herb/recepie
    public String restrictions;

    public Herb(String name, int quantity, LocalDate dateOfPurchase,
                String properties, String limitations, String restrictions) {
    this.name = name;
    this.quantity = quantity;
    this.dateOfPurchase = dateOfPurchase;
    this.properties = properties;
    this.limitations = limitations;
    this.restrictions = restrictions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getLimitations() {
        return limitations;
    }

    public void setLimitations(String limitations) {
        this.limitations = limitations;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    @Override
    public String toString() {
        return name;
    }
}
