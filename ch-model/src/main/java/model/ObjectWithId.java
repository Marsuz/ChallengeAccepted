package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class ObjectWithId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    ObjectWithId() {

    }

    ObjectWithId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
