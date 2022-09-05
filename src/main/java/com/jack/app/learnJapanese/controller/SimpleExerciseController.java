package com.jack.app.learnJapanese.controller;

import com.jack.app.learnJapanese.service.SimpleExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/simpleExercise" )
public class SimpleExerciseController {

    @Autowired
    private SimpleExerciseService simpleExerciseService;

    @GetMapping( "/getARandomHiragana" )
    @ResponseBody
    String getARandomHiragana() {
        return simpleExerciseService.getARandomHiragana();
    }

    @GetMapping("/getARandomSingleWordPronunciation")
    @ResponseBody
    String getARandomSingleWordPronunciation() {
        System.out.println( "call..." );
        return simpleExerciseService.getARandomSingleWordPronunciation();
    }

    @PostMapping( "/answerTheHiraganaOfPronunciation" )
    @ResponseBody
    boolean answerTheHiraganaOfPronunciation(@RequestParam String pronunciation, @RequestParam String answer) {
        return simpleExerciseService.answerTheHiraganaOfPronunciation(pronunciation, answer);
    }

}
