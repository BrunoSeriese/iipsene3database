package nl.hsleiden.iipsene3database.model;

import javax.persistence.*;

@Entity
@Table(name = "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Node() {}

    public Long getId() {
        return id;
    }
}
