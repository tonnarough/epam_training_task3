package by.epam.training.task3.entity;

public final class Lexeme {
    private LexemeType lexemeType;
    private String value;

    public Lexeme(LexemeType lexemeType, String value) {
        this.lexemeType = lexemeType;
        this.value = value;
    }

    public Lexeme(LexemeType lexemeType, Character value) {
        this.lexemeType = lexemeType;
        this.value = value.toString();
    }

    public LexemeType getLexemeType() {
        return lexemeType;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "lexemeType=" + lexemeType +
                ", value='" + value + '\'' +
                '}';
    }
}