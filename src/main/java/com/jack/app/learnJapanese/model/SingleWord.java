package com.jack.app.learnJapanese.model;

import lombok.Data;

@Data
public class SingleWord {

    private String pronunciation;

    private String hiragana;

    private String katakana;

    public SingleWord(String pronunciation, String hiragana, String katakana) {
        this.pronunciation = pronunciation;
        this.hiragana = hiragana;
        this.katakana = katakana;
    }



}
