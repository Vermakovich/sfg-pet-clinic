package com.vermakovich.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"", "/index"})
    public String getOwners() {
        return "owners/index";
    }
}
