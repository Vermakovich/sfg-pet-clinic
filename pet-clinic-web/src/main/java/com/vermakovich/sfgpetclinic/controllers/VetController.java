package com.vermakovich.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("vets")
@Controller
public class VetController {

    @RequestMapping({"", "/index"})
    public String getVets() {
        return "vets/index";
    }
}
