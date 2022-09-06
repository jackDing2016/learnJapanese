package com.jack.app.learnJapanese.controller;

import com.jack.app.learnJapanese.service.SimpleExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/simpleExercise" )
public class SimpleExerciseController {

    @Autowired
    private SimpleExerciseService simpleExerciseService;


    @GetMapping("/getARandomSingleWordPronunciation")
    @ResponseBody
    String getARandomSingleWordPronunciation() {
        return simpleExerciseService.getARandomSingleWordPronunciation();
    }

    @GetMapping("/getARandomSingleWordHiragana")
    @ResponseBody
    String getARandomSingleWordHiragana() {
        return simpleExerciseService.getARandomSingleWordHiragana();
    }

    @GetMapping("/getARandomSingleWordKatakana")
    @ResponseBody
    String getARandomSingleWordKatakana() {
        return simpleExerciseService.getARandomSingleWordKatakana();
    }

    @PostMapping( "/answerTheHiraganaOfPronunciation" )
    @ResponseBody
    boolean answerTheHiraganaOfPronunciation(@RequestParam String pronunciation, @RequestParam String answer) {
        return simpleExerciseService.answerTheHiraganaOfPronunciation(pronunciation, answer);
    }

    @PostMapping( "/answerTheKatakanaOfPronunciation" )
    @ResponseBody
    boolean answerTheKatakanaOfPronunciation(@RequestParam String pronunciation, @RequestParam String answer) {
        return simpleExerciseService.answerTheKatakanaOfPronunciation(pronunciation, answer);
    }

    @PostMapping( "/answerThePronunciationOfHiragana" )
    @ResponseBody
    boolean answerThePronunciationOfHiragana(@RequestParam String hiragana, @RequestParam String answer) {
        return simpleExerciseService.answerThePronunciationOfHiragana(hiragana, answer);
    }

    @PostMapping( "/answerThePronunciationOfKatakana" )
    @ResponseBody
    boolean answerThePronunciationOfKatakana(@RequestParam String katakana, @RequestParam String answer) {
        return simpleExerciseService.answerThePronunciationOfKatakana(katakana, answer);
    }

}
