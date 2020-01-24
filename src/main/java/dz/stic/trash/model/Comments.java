package dz.stic.trash.model;

import java.util.Date;
import java.util.Objects;

public class Comments {
private int id;
private String content;
private Date creationDate ;
private int isEnabled;
    private Client rClient;
    public Comments() {
    }

    public Comments(String content, Date creationDate, int isEnabled) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
        this.isEnabled = isEnabled;
    }

    public Comments(int id) {
        this.id = id;
    }

    public Comments(String content) {
        this.content=content;
    }

    public int getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(int isEnabled) {
        this.isEnabled = isEnabled;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public Client getrClient() {
        return rClient;
    }

    public void setrClient(Client rClient) {
        this.rClient = rClient;
    }
    public void addClient(Client client){
        setrClient(client);
    }
    public void remove(Client client){
        setrClient(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return id == comments.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
