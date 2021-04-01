package net.gamedev.battleship.model;

public class Task {
    public static final String ATTR = "task";
    private int randNumber1;
    private int randNumber2;
    private int expectedResult;
    private int actualResult;

    public int getRandNumber1() {
        return randNumber1;
    }

    public void setRandNumber1(int randNumber1) {
        this.randNumber1 = randNumber1;
    }

    public int getRandNumber2() {
        return randNumber2;
    }

    public void setRandNumber2(int randNumber2) {
        this.randNumber2 = randNumber2;
    }

    public int getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(int expectedResult) {
        this.expectedResult = expectedResult;
    }

    public int getActualResult() {
        return actualResult;
    }

    public void setActualResult(int actualResult) {
        this.actualResult = actualResult;
    }
}
