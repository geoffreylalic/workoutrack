package com.springboot.workoutrack.set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.springboot.workoutrack.utils.Constant.apiPrefix;
import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping(path = apiPrefix + "sets")
public class SetController {
    private final SetService setService;

    @Autowired
    public SetController(SetService setService) {
        this.setService = setService;
    }

    @GetMapping()
    public List<Set> getSet() {
        return setService.getSets();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Set> getSetById(@PathVariable(value = "id") Long id) {
        try {
            Set set = setService.getSetById(id);
            return ResponseEntity.ok().body(set);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping()
    public Set createSet(@RequestBody Set set) {
        return setService.createSet(set);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteSet(@PathVariable(value = "id")Long id) {
        return setService.deleteById(id);
    }

    @PatchMapping(path = "/{id}")
    public Set updateSet(@PathVariable(value = "id")Long id, @RequestBody Set set) {
        Set setById = setService.getSetById(id);
        setById.setRest(set.getRest());
        setById.setRepetition(set.getRepetition());
        setById.setWeight(set.getWeight());
        return setService.save(set);
    }

}
