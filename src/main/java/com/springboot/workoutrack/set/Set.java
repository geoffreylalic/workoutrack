package com.springboot.workoutrack.set;

import jakarta.persistence.*;

@Entity
@Table(name = "set")
public class Set {
    @Id
    @SequenceGenerator(name = "set_sequence", sequenceName = "set_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "set_sequence")
    private Long id;
    private int repetition;

    private float weight;
    private int rest;

    public Set(int repetition, int rest, float weight) {
        this.repetition = repetition;
        this.rest = rest;
        this.weight = weight;
    }

    public Set() {
    }


    public Set(Long id, int repetition, int rest, float weight) {
        this.id = id;
        this.repetition = repetition;
        this.rest = rest;
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public int getRepetition() {
        return repetition;
    }

    public int getRest() {
        return rest;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    @Override
    public String toString() {
        return "Set{" +
                "id=" + id +
                ", repetition=" + repetition +
                ", rest=" + rest +
                '}';
    }
}
