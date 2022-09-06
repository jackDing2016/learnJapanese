package com.jack.app.learnJapanese.service;

import com.jack.app.learnJapanese.model.SingleWord;

import java.util.Map;

public interface SimpleExerciseService {



    String getARandomSingleWordPronunciation();

    String getARandomSingleWordHiragana();

    String getARandomSingleWordKatakana();

    boolean answerTheHiraganaOfPronunciation( String pronunciation, String answer );

    boolean answerTheKatakanaOfPronunciation( String pronunciation, String answer );

    boolean answerThePronunciationOfHiragana( String hiragana, String answer );

    boolean answerThePronunciationOfKatakana( String katakana, String answer );

    Map<String, SingleWord> pronunciationMap();

    Map<String, SingleWord> hiraganaMap();

    Map<String, SingleWord> katakanaMap();

}
