package by.epam.training.task3.service;

import by.epam.training.task3.entity.Lexeme;
import by.epam.training.task3.entity.LexemeBuffer;
import by.epam.training.task3.entity.LexemeType;

public final class CalculateExpression {
    private static CalculateExpression calculateExpression;

    private CalculateExpression() {
    }

    public static double start(LexemeBuffer lexemeBuffer){
        if(calculateExpression == null){
            calculateExpression = new CalculateExpression();
        }
        return calculateExpression.expression(lexemeBuffer);
    }

    private double expression(LexemeBuffer lexemeBuffer) {
        Lexeme lexeme = lexemeBuffer.next();
        if (lexeme.getLexemeType() == LexemeType.EOF) {
            return 0;
        } else {
            lexemeBuffer.back();
            return plusminus(lexemeBuffer);
        }
    }

    private double plusminus(LexemeBuffer lexemeBuffer) {
        double value = multdiv(lexemeBuffer);
        while (true) {
            Lexeme lexeme = lexemeBuffer.next();
            switch (lexeme.getLexemeType()) {
                case OP_PLUS:
                    value += multdiv(lexemeBuffer);
                    break;
                case OP_MINUS:
                    value -= multdiv(lexemeBuffer);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                    lexemeBuffer.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.getValue()
                            + " at position: " + lexemeBuffer.getPosition());
            }
        }
    }

    private double multdiv(LexemeBuffer lexemeBuffer) {
        double value = factor(lexemeBuffer);
        while (true) {
            Lexeme lexeme = lexemeBuffer.next();
            switch (lexeme.getLexemeType()) {
                case OP_MUL:
                    value *= factor(lexemeBuffer);
                    break;
                case OP_DIV:
                    value /= factor(lexemeBuffer);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case OP_PLUS:
                case OP_MINUS:
                    lexemeBuffer.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.getValue()
                            + " at position: " + lexemeBuffer.getPosition());
            }
        }
    }

    private double factor(LexemeBuffer lexemeBuffer) {
        Lexeme lexeme = lexemeBuffer.next();
        switch (lexeme.getLexemeType()) {
            case OP_MINUS:
                double value = factor(lexemeBuffer);
                return -value;
            case NUMBER:
                return Integer.parseInt(lexeme.getValue());
            case LEFT_BRACKET:
                value = plusminus(lexemeBuffer);
                lexeme = lexemeBuffer.next();
                if (lexeme.getLexemeType() != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.getValue()
                            + " at position: " + lexemeBuffer.getPosition());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.getValue()
                        + " at position: " + lexemeBuffer.getPosition());
        }
    }
}