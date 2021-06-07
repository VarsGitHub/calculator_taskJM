/*Class, designed to keep necessary information about expression in usable logical blocks.*/
public class Data {
    private int firstArg;
    private int secondArg;
    private String operand;
    private char notation;

    public void setFirstArg(int firstArg) {
        this.firstArg = firstArg;
    }

    public void setSecondArg(int secondArg) {
        this.secondArg = secondArg;
    }

    public void setNotation(char notation) {
        this.notation = notation;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public int getFirstArg() {
        return firstArg;
    }

    public int getSecondArg() {
        return secondArg;
    }

    public String getOperand() {
        return operand;
    }

    public char getNotation() {
        return notation;
    }
}
