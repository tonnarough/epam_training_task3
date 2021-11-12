package by.epam.training.task3.entity;

import java.util.List;

public final class LexemeBuffer {
    private int position;
    private List<Lexeme> lexemeList;

    public LexemeBuffer(List<Lexeme> lexemeList) {
        this.lexemeList = lexemeList;
    }

    public Lexeme next() {
        return lexemeList.get(position++);
    }

    public void back() {
        position--;
    }

    public int getPosition() {
        return position;
    }
}