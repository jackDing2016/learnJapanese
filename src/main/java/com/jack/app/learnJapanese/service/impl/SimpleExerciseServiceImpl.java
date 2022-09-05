package com.jack.app.learnJapanese.service.impl;

import com.jack.app.learnJapanese.model.SingleWord;
import com.jack.app.learnJapanese.service.SimpleExerciseService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SimpleExerciseServiceImpl implements SimpleExerciseService {

    static final String[] HIRAGANA_ARRAY = {
            "あ", "い", "う", "え", "お",
            "か", "き", "く", "け", "こ",
            "さ", "し", "す", "せ", "そ",
            "た", "ち", "つ", "て", "と",
            "な", "に", "ぬ", "ね", "の",
            "は", "ひ", "ふ", "へ", "ほ",
            "ま", "み", "む", "め", "も",
            "や", "ゆ", "よ",
            "ら", "り", "る", "れ", "ら"
    };

    final static List<SingleWord> singleWordList = List.of(
            new SingleWord("a", "あ", null),
            new SingleWord("i", "い", null),
            new SingleWord("u", "う", null),
            new SingleWord("e", "え", null),
            new SingleWord("o", "お", null),
            new SingleWord("ka", "か", null),
            new SingleWord("ki", "き", null),
            new SingleWord("ku", "く", null),
            new SingleWord("ke", "け", null),
            new SingleWord("ko", "こ", null),
            new SingleWord("sa", "さ", null),
            new SingleWord("shi", "し", null),
            new SingleWord("su", "す", null),
            new SingleWord("se", "せ", null),
            new SingleWord("so", "そ", null),
            new SingleWord("ta", "た", null),
            new SingleWord("chi", "ち", null),
            new SingleWord("tsu", "つ", null),
            new SingleWord("te", "て", null),
            new SingleWord("to", "と", null),
            new SingleWord("na", "な", null),
            new SingleWord("ni", "に", null),
            new SingleWord("nu", "ぬ", null),
            new SingleWord("ne", "ね", null),
            new SingleWord("no", "の", null),
            new SingleWord("ha", "は", null),
            new SingleWord("hi", "ひ", null),
            new SingleWord("fu", "ふ", null),
            new SingleWord("he", "へ", null),
            new SingleWord("ho", "ほ", null),
            new SingleWord("ma", "ま", null),
            new SingleWord("mi", "み", null),
            new SingleWord("mu", "む", null),
            new SingleWord("me", "め", null),
            new SingleWord("mo", "も", null),
            new SingleWord("ra", "ら", null),
            new SingleWord("ri", "り", null),
            new SingleWord("ru", "る", null),
            new SingleWord("re", "れ", null),
            new SingleWord("ro", "ろ", null));

    @Override
    public String getARandomHiragana() {
        return HIRAGANA_ARRAY[ThreadLocalRandom.current().nextInt(0, HIRAGANA_ARRAY.length)];
    }

    @Override
    public String getARandomSingleWordPronunciation() {
        return singleWordList.get( ThreadLocalRandom.current().nextInt(0, singleWordList.size()) ).getPronunciation();
    }

    @Override
    public boolean answerTheHiraganaOfPronunciation(String pronunciation, String answer) {

        if (Strings.isEmpty( answer )) return false;
        if ( hiraganaMap().get(answer) == null ) return false;

        return pronunciation.equals( hiraganaMap().get(answer).getPronunciation() );
    }

    @Override
    public Map<String, SingleWord> pronunciationMap() {
        return singleWordList.stream().collect(Collectors.toMap( SingleWord::getPronunciation, Function.identity() ) );
    }

    @Override
    public Map<String, SingleWord> hiraganaMap() {
        return singleWordList.stream().collect(Collectors.toMap( SingleWord::getHiragana, Function.identity() ) );
    }
}
