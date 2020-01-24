package dz.stic.trash.model;

import java.util.Date;
import java.util.Objects;

public class Photo {
    private int id;
    private String path;
    private String createDate;
    public Photo(int id, String path, String createDate) {
        this.id = id;
        this.path = path;
        this.createDate = createDate;
    }

    public Photo(String path, String createDate) {
        this.path = path;
        this.createDate = createDate;
    }

    public Photo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id == photo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
