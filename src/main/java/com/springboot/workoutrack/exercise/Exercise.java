package com.springboot.workoutrack.exercise;

import com.springboot.workoutrack.set.Set;
import com.springboot.workoutrack.workout.Workout;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    private Long id;
    private String name;
    private String target_muscle;
    @OneToMany
    private List<Set> sets;
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    public Exercise(Long id, String name, String target_muscle) {
        this.id = id;
        this.name = name;
        this.target_muscle = target_muscle;
    }

    public Exercise(String name, String target_muscle) {
        this.name = name;
        this.target_muscle = target_muscle;
    }

    public Exercise() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTarget_muscle() {
        return target_muscle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTarget_muscle(String target_muscle) {
        this.target_muscle = target_muscle;
    }
}
