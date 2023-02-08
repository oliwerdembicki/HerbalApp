package Variables;

import java.time.LocalDate;

public class Client {

    public String name;
    public String surname;
    public LocalDate dateOfBirth;
    public int phoneNumber;
    public String mail;
    public String previousIllness;
    public String currentIllness;

    public Client(String name, String surname, LocalDate dateOfBirth,
                  int phoneNumber, String mail, String previousIllness, String currentIllness) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.previousIllness = previousIllness;
        this.currentIllness = currentIllness;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPreviousIllness() {
        return previousIllness;
    }

    public void setPreviousIllness(String previousIllness) {
        this.previousIllness = previousIllness;
    }

    public String getCurrentIllness() {
        return currentIllness;
    }

    public void setCurrentIllness(String currentIllness) {
        this.currentIllness = currentIllness;

    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
