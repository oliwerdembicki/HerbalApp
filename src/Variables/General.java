package Variables;

public class General {

    public String nameAndSurname;
    public String contact;
    public String assignedRecipe;
    public String assignedHerb;
    public String illnesses;


    public General(String nameAndSurname, String contact, String assignedHerb,
                   String assignedRecipe, String illnesses) {
        this.nameAndSurname = nameAndSurname;
        this.contact = contact;
        this.assignedHerb = assignedHerb;
        this.assignedRecipe = assignedRecipe;
        this.illnesses = illnesses;


    }

    public String getNameAndSurname() {
        return this.nameAndSurname;

    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAssignedRecipe() {
        return assignedRecipe;
    }

    public void setAssignedRecipe(String assignedRecipe) {
        this.assignedRecipe = assignedRecipe;
    }

    public String getAssignedHerb() {
        return assignedHerb;
    }

    public void setAssignedHerb(String assignedHerb) {
        this.assignedHerb = assignedHerb;
    }

    public String getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(String illnesses) {
        this.illnesses = illnesses;
    }


    public static String parseIntoStringClient(Client client) {
        String parsedName = client.getName() + " " + client.getSurname();
        return parsedName;
    }

    public static String parseIntoStringContact(Client client) {
        String parsedContact = client.getPhoneNumber() + " " + client.getMail();
        return parsedContact;
    }

    public static String parseIntoStringIllnesses(Client client) {
        String parsedIllness = client.getCurrentIllness() + " " + client.getPreviousIllness();
        return parsedIllness;
    }

    @Override
    public String toString() {
        return nameAndSurname;
    }
}