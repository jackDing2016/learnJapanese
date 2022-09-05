package com.jack.app.learnJapanese.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/hi" )
public class HiController {

    @GetMapping("/test")
    @ResponseBody String test() {
        return "hi";
    }

}
