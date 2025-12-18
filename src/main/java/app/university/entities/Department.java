package app.university.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "head_id")
    private Lector head;

    @ManyToMany
    @JoinTable(
        name = "department_lector",
        joinColumns = @JoinColumn(name = "department_id"),
        inverseJoinColumns = @JoinColumn(name = "lector_id")
    )
    private List<Lector> employees;

    public Lector getHead() {
        return head;
    }

    public void setHead(Lector head) {
        this.head = head;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lector> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Lector> employees) {
        this.employees = employees;
    }
}
