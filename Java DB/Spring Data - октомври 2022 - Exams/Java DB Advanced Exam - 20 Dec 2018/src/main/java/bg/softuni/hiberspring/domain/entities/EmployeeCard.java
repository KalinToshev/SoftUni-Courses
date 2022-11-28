package bg.softuni.hiberspring.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees_cards")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeCard extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String number;
}
