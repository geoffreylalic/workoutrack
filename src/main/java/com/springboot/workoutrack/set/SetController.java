package com.springboot.workoutrack.set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static com.springboot.workoutrack.utils.Constant.apiPrefix;

@RestController
@RequestMapping(path = apiPrefix + "sets")
public class SetController {
    private final SetService setService;

    @Autowired
    public SetController(SetService setService) {
        this.setService = setService;
    }

    @GetMapping()
    public ResponseEntity<List<SetDTO>> getSet() {
        return ResponseEntity.ok(setService.getSets());
    }

    @PostMapping()
    public ResponseEntity<SetDTO> createSet(@RequestBody Set set) {
        return ResponseEntity.ok(setService.createSet(set));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SetDTO> getSetById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(setService.getSetById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteSet(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(setService.deleteById(id));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<SetDTO> updateSet(@PathVariable(value = "id") Long id, @RequestBody Set set) {
        return ResponseEntity.ok(setService.updateSetById(id, set));
    }

}
