package by.epam.training.task3.service;

import by.epam.training.task3.entity.LexemeBuffer;

public final class StringExpression {

    private StringExpression() {

    }

    public static double calculate(String stringExpression) {

        LexemeBuffer lexemeBuffer = new LexemeBuffer(StringAnalyzer.analyze(stringExpression));

        return CalculateExpression.start(lexemeBuffer);
    }
}