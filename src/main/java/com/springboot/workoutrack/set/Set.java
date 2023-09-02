package com.springboot.workoutrack.set;

import com.springboot.workoutrack.exercise.Exercise;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "set")
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int repetition;
    private float weight;
    private LocalTime rest;
    @ManyToOne
    private Exercise exercise;


    public Set(int repetition, LocalTime rest, float weight) {
        this.repetition = repetition;
        this.rest = rest;
        this.weight = weight;
    }

    public Set() {
    }


    public Set(Long id, int repetition, LocalTime rest, float weight) {
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

    public LocalTime getRest() {
        return rest;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public void setRest(LocalTime rest) {
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
