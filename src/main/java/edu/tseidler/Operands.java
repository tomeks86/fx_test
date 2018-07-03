package edu.tseidler;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Operands {
    private final IntegerProperty firstArgument;
    private final IntegerProperty secondArgument;

    public Operands() {
        this.firstArgument = new SimpleIntegerProperty();
        this.secondArgument = new SimpleIntegerProperty();
    }

    public int getFirstArgument() {
        return firstArgument.get();
    }

    public IntegerProperty firstArgumentProperty() {
        return firstArgument;
    }

    public void setFirstArgument(int firstArgument) {
        this.firstArgument.set(firstArgument);
    }

    public int getSecondArgument() {
        return secondArgument.get();
    }

    public IntegerProperty secondArgumentProperty() {
        return secondArgument;
    }

    public void setSecondArgument(int secondArgument) {
        this.secondArgument.set(secondArgument);
    }
}
