package bg.softuni.exercise_springdataautomappingobjects.domain.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BaseEntity() {

    }

    public Long getId() {

        return this.id;

    }

    public void setId(Long id) {

        this.id = id;

    }

}