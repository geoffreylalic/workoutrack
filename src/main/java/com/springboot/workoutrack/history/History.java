package com.springboot.workoutrack.history;

import com.springboot.workoutrack.workout.Workout;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "history")
public class History {
    @Id
    private Long id;
    private LocalTime duration;
    private LocalDateTime doneAt;
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

}
