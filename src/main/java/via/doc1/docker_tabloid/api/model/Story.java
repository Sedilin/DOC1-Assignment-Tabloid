package via.doc1.docker_tabloid.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;

@Entity(name = "Story")
@Table(name = "stories")
public class Story {
    private String department;
    private String title;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Story(String department, String title, String description, int id) {
        this.department = department;
        this.title = title;
        this.description = description;
        this.id = id;
    }
    @JsonIgnore
    public Story(String department, String title, String description) {
        this.department = department;
        this.title = title;
        this.description = description;
    }

    public Story() {}

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
