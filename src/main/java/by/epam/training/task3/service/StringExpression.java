package by.epam.training.task3.service;

import by.epam.training.task3.entity.LexemeBuffer;

public final class StringExpression {

    private StringExpression() {

    }

    public static int calculate(String stringExpression) {
        StringAnalyzer stringAnalyzer = new StringAnalyzer();
        LexemeBuffer lexemeBuffer = new LexemeBuffer(stringAnalyzer.lexemeAnalyze(stringExpression));
        Parser parse = new Parser();
        return parse.expression(lexemeBuffer);
    }
}