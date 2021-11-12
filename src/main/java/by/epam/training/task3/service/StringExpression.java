package by.epam.training.task3.service;

import by.epam.training.task3.entity.LexemeBuffer;

public final class StringExpression {

    private StringExpression() {

    }

    public static double calculate(String stringExpression) {

        StringAnalyzer stringAnalyzer = new StringAnalyzer();
        LexemeBuffer lexemeBuffer = new LexemeBuffer(stringAnalyzer.lexemeAnalyze(stringExpression));
        CalculateExpression calculateExpression = new CalculateExpression();

        return calculateExpression.expression(lexemeBuffer);
    }
}