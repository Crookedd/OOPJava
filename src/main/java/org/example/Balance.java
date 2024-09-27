package org.example;

public class Balance {
    private int leftWeight;
    private int rightWeight;

    public Balance() {
        this.leftWeight = 0;
        this.rightWeight = 0;
    }

    public void addLeft(int weight) {
        if (weight > 0) {
            leftWeight += weight;
        }
    }

    public void addRight(int weight) {
        if (weight > 0) {
            rightWeight += weight;
        }
    }

    public void reset() {
        leftWeight = 0;
        rightWeight = 0;
    }

    public String result() {
        return getResult();
    }

    String getResult() {
        if (leftWeight == rightWeight) {
            return "=";
        } else if (leftWeight > rightWeight) {
            return "L";
        } else {
            return "R";
        }
    }
}
