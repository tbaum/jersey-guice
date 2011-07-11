package test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author tbaum
 * @since 11.07.11
 */
@Entity
@XmlRootElement
public class DataClass {
// ------------------------------ FIELDS ------------------------------

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    private String name;

// --------------------------- CONSTRUCTORS ---------------------------

    protected DataClass() {
    }

    public DataClass(String name) {
        this.name = name;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
