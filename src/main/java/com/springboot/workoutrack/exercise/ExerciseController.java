package com.springboot.workoutrack.exercise;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springboot.workoutrack.utils.Constant.apiPrefix;

@RestController()
@RequestMapping(path = apiPrefix + "exercises")
public class ExerciseController {
    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping()
    public ResponseEntity<List<ExerciseDTO>> getExercises() {
        return ResponseEntity.ok(exerciseService.getExercises());
    }

    @PostMapping()
    public ResponseEntity<ExerciseDTO> createExercise(@RequestBody Exercise exercise ) {
        return ResponseEntity.ok(exerciseService.createExercise(exercise));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTO> getExercise(@PathVariable("id") Long id) {
        return ResponseEntity.ok(exerciseService.getExercise(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExerciseDTO> updateExercise( @PathVariable("id") Long id, @RequestBody Exercise newExercise) {
        return ResponseEntity.ok(exerciseService.updateExercise(id, newExercise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteExercise(@PathVariable("id") Long id) {
        return ResponseEntity.ok(exerciseService.deleteExercise(id));
    }

}
