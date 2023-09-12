package com.springboot.workoutrack.set;

import com.springboot.workoutrack.exercise.Exercise;
import jakarta.persistence.*;

import java.time.Duration;


@Entity
@Table(name = "set")
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer repetition;
    private Float weight;
    private Duration rest;
    @ManyToOne
    private Exercise exercise;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Set(int repetition, Duration  rest, float weight) {
        this.repetition = repetition;
        this.rest = rest;
        this.weight = weight;
    }

    public Set() {
    }


    public Set(Long id, int repetition, Duration  rest, float weight) {
        this.id = id;
        this.repetition = repetition;
        this.rest = rest;
        this.weight = weight;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public Integer getRepetition() {
        return repetition;
    }

    public Duration  getRest() {
        return rest;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public void setRest(Duration  rest) {
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
