package adapter;

class Calculator {
    public Formula newFormula() {
        return new Formula();
    }

    public static enum Operation {
        SUM, SUB, MULT, DIV, POW;
    }

    public static class Formula {
        protected Double a, b, result;

        protected Formula() {
        }

        public Formula addOperand(double operand) {
            if (a == null) {
                a = operand;
            } else if (b == null) {
                b = operand;
            } else {
                throw new IllegalStateException("Formula is full of operands");
            }
            return this;
        }

        public Formula calculate(Operation op) {
            if (a == null || b == null)
                throw new IllegalStateException("Not enough operands!");
            switch (op) {
                case SUM:
                    result = a + b;
                    break;
                case SUB:
                    result = a - b;
                    break;
                case MULT:
                    result = a * b;
                    break;
                case DIV:
                    result = a / b;
                    break;
                case POW:
                    result = Math.pow(a, b);
                    break;
            }
            return this;
        }

        public double result() {
            if (result == null)
                throw new IllegalStateException("Formula is not computed!");
            return result;
        }
    }
}

interface Ints {
    int sum(int arg0, int arg1);

    int mult(int arg0, int arg1);

    int pow(int a, int b);
}

class IntsCalculator implements Ints {
    protected final Calculator target;

    public IntsCalculator() {
        this.target = new Calculator();
    }

    @Override
    public int sum(int arg0, int arg1) {
        return arg0 + arg1;
    }

    @Override
    public int mult(int arg0, int arg1) {
        return arg0 * arg1;
    }

    @Override
    public int pow(int a, int b) {
        return (int) Math.pow(a, b);
    }
}

public class Main {
    public static void main(String[] args) {

        Ints intsCalc = new IntsCalculator();
        System.out.println(intsCalc.sum(2, 2));
        System.out.println(intsCalc.mult(10, 22));
        System.out.println(intsCalc.pow(2, 10));

    }
}

