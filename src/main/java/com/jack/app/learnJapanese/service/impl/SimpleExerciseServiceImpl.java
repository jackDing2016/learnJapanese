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
            new SingleWord("a", "あ", "ア"),
            new SingleWord("i", "い", "イ"),
            new SingleWord("u", "う", "ウ"),
            new SingleWord("e", "え", "エ"),
            new SingleWord("o", "お", "オ"),
            new SingleWord("ka", "か", "カ"),
            new SingleWord("ki", "き", "キ"),
            new SingleWord("ku", "く", "ク"),
            new SingleWord("ke", "け", "ケ"),
            new SingleWord("ko", "こ", "コ"),
            new SingleWord("sa", "さ", "サ"),
            new SingleWord("shi", "し", "シ"),
            new SingleWord("su", "す", "ス"),
            new SingleWord("se", "せ", "セ"),
            new SingleWord("so", "そ", "ソ"),
            new SingleWord("ta", "た", "タ"),
            new SingleWord("chi", "ち", "チ"),
            new SingleWord("tsu", "つ", "ツ"),
            new SingleWord("te", "て", "テ"),
            new SingleWord("to", "と", "ト"),
            new SingleWord("na", "な", "ナ"),
            new SingleWord("ni", "に", "ニ"),
            new SingleWord("nu", "ぬ", "ヌ"),
            new SingleWord("ne", "ね", "ネ"),
            new SingleWord("no", "の", "ノ"),
            new SingleWord("ha", "は", "ハ"),
            new SingleWord("hi", "ひ", "ヒ"),
            new SingleWord("fu", "ふ", "フ"),
            new SingleWord("he", "へ", "ヘ"),
            new SingleWord("ho", "ほ", "ホ"),
            new SingleWord("ma", "ま", null),
            new SingleWord("mi", "み", null),
            new SingleWord("mu", "む", null),
            new SingleWord("me", "め", null),
            new SingleWord("mo", "も", null),
            new SingleWord("ra", "ら", null),
            new SingleWord("ri", "り", null),
            new SingleWord("ru", "る", null),
            new SingleWord("re", "れ", null),
            new SingleWord("ro", "ろ", null)
    );

    @Override
    public String getARandomSingleWordPronunciation() {
        return singleWordList.get( ThreadLocalRandom.current().nextInt(0, singleWordList.size()) ).getPronunciation();
    }

    @Override
    public String getARandomSingleWordHiragana() {
        return singleWordList.get( ThreadLocalRandom.current().nextInt(0, singleWordList.size()) ).getHiragana();
    }

    @Override
    public String getARandomSingleWordKatakana() {
        return singleWordList.get( ThreadLocalRandom.current().nextInt(0, singleWordList.size()) ).getKatakana();
    }

    @Override
    public boolean answerThePronunciationOfHiragana(String hiragana, String answer) {
        if ( Strings.isEmpty( answer ) ) return false;
        if (pronunciationMap().get(answer) == null ) return false;
        return hiragana.equals(pronunciationMap().get(answer).getHiragana());
    }

    @Override
    public boolean answerThePronunciationOfKatakana(String katakana, String answer) {
        if ( Strings.isEmpty( answer ) ) return false;
        if (pronunciationMap().get(answer) == null ) return false;
        return katakana.equals(pronunciationMap().get(answer).getHiragana());
    }

    @Override
    public boolean answerTheHiraganaOfPronunciation(String pronunciation, String answer) {

        if (Strings.isEmpty( answer )) return false;
        if ( hiraganaMap().get(answer) == null ) return false;

        return pronunciation.equals( hiraganaMap().get(answer).getPronunciation() );
    }

    @Override
    public boolean answerTheKatakanaOfPronunciation(String pronunciation, String answer) {
        if (Strings.isEmpty( answer )) return false;
        if ( katakanaMap().get(answer) == null ) return false;

        return pronunciation.equals( katakanaMap().get(answer).getPronunciation() );
    }

    @Override
    public Map<String, SingleWord> pronunciationMap() {
        return singleWordList.stream().collect(Collectors.toMap( SingleWord::getPronunciation, Function.identity() ) );
    }

    @Override
    public Map<String, SingleWord> hiraganaMap() {
        return singleWordList.stream().collect(Collectors.toMap( SingleWord::getHiragana, Function.identity() ) );
    }

    @Override
    public Map<String, SingleWord> katakanaMap() {
        return singleWordList.stream().collect(Collectors.toMap( SingleWord::getKatakana, Function.identity(), ( o, n ) -> n ) );
    }
}
