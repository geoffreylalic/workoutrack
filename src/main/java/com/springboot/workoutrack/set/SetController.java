package com.springboot.workoutrack.set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<Set> getSets() {
        return setService.getSets();
    }

    @PostMapping()
    public Set createSet(@RequestBody Set set) {
        return setService.createSet(set);
    }
}
