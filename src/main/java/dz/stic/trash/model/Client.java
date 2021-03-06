package dz.stic.trash.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Client extends User {
    private String phoneNumber,androidVersion;
    @JsonBackReference
    private Set<Challenge> rChallenge;

    public Client() {
    }

    public Client(int id, String lastname, String fisrtName, String userName, String password, String birthDate, String phoneNumber, String androidVersion) {
        super(id, lastname, fisrtName, userName, password, birthDate);
        this.phoneNumber = phoneNumber;
        this.androidVersion = androidVersion;
        this.rChallenge =new HashSet<>();
    }

    public Client(int i) {
        id=i;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }
    public void addChallenge(Challenge b){
        if(!getrChallenge().contains(b)) {
            if (b.getrClient() != null) {
            b.removeClient();
            b.setrClient(this);
            getrChallenge().add(b);
            }
        }
    }

    public void removeChallenge(Challenge challenge){
        if(getrChallenge().contains(challenge)){
            challenge.setrClient(null);
            getrChallenge().remove(challenge);
        }
    }
    public Set<Challenge> getrChallenge() {
        return rChallenge;
    }

    public void setrChallenge(Set<Challenge> rChallenge) {
        this.rChallenge = rChallenge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }
}
