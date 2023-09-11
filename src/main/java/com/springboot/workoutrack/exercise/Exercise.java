package com.springboot.workoutrack.exercise;

import com.springboot.workoutrack.set.Set;
import com.springboot.workoutrack.set.SetDTO;
import com.springboot.workoutrack.workout.Workout;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String targetMuscle;
    @OneToMany(mappedBy = "exercise")
    private List<Set> sets;
    @ManyToOne
    private Workout workout;

    public Exercise(Long id, String name, String targetMuscle) {
        this.id = id;
        this.name = name;
        this.targetMuscle = targetMuscle;
    }

    public Exercise(String name, String targetMuscle) {
        this.name = name;
        this.targetMuscle = targetMuscle;
    }

    public Exercise() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Workout getWorkout() {
        return workout;
    }
}
