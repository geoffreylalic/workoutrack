package com.springboot.workoutrack.workout;

import com.springboot.workoutrack.exercise.Exercise;
import com.springboot.workoutrack.exercise.ExerciseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springboot.workoutrack.utils.Constant.apiPrefix;

@RestController()
@RequestMapping(path = apiPrefix + "workouts")
public class WorkoutController {

    private WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping()
    public ResponseEntity<List<WorkoutDTO>> getWorkouts() {
        return ResponseEntity.ok(workoutService.getWorkouts());
    }

    @PostMapping()
    public ResponseEntity<WorkoutDTO> createWorkout(@RequestBody Workout workout ) {
        return ResponseEntity.ok(workoutService.createWorkout(workout));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutDTO> getWorkout(@PathVariable("id") Long id) {
        return ResponseEntity.ok(workoutService.getWorkout(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WorkoutDTO> updateWorkout( @PathVariable("id") Long id, @RequestBody Workout newWorkout) {
        return ResponseEntity.ok(workoutService.updateWorkout(id, newWorkout));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteWorkout(@PathVariable("id") Long id) {
        return ResponseEntity.ok(workoutService.deleteWorkout(id));
    }

}
