package com.springboot.workoutrack.set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<SetDTO> getSet() {
        return setService.getSets();
    }

    @PostMapping()
    public SetDTO createSet(@RequestBody Set set) {
        return setService.createSet(set);
    }

    @GetMapping(path = "/{id}")
    public SetDTO getSetById(@PathVariable(value = "id") Long id) {
        return setService.getSetById(id);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteSet(@PathVariable(value = "id") Long id) {
        return setService.deleteById(id);
    }

    @PatchMapping(path = "/{id}")
    public SetDTO updateSet(@PathVariable(value = "id") Long id, @RequestBody Set set) {
        return setService.getSetById(id);
    }

}
