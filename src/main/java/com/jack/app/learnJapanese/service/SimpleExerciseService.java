package com.jack.app.learnJapanese.service;

import com.jack.app.learnJapanese.model.SingleWord;

import java.util.Map;

public interface SimpleExerciseService {

    /**
     * getARandomHiragana
     * @return
     */
    String getARandomHiragana();

    String getARandomSingleWordPronunciation();

    boolean answerTheHiraganaOfPronunciation( String pronunciation, String answer );

    Map<String, SingleWord> pronunciationMap();

    Map<String, SingleWord> hiraganaMap();

}
