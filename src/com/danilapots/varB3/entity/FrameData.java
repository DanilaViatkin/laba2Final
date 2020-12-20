package com.danilapots.varB3.entity;

import javax.swing.*;

public class FrameData {
    private int formulaId;
    private JTextField x;
    private JTextField y;
    private JTextField z;
    private JTextField result;

    public int getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(int formulaId) {
        this.formulaId = formulaId;
    }

    public String getX() {
        return x.getText();
    }

    public String getY() {
        return y.getText();
    }

    public String getZ() {
        return z.getText();
    }

    public void setResultField(JTextField field) {
        result = field;
    }

    public void setResult(String result) {
        this.result.setText(result);
    }

    public void setVariableField(String variableName, JTextField field) {
        switch (variableName) {
            case "X":
                x = field;
                break;
            case "Y":
                y = field;
                break;
            case "Z":
                z = field;
                break;
        }
    }

    public void clearVariables() {
        x.setText("0");
        y.setText("0");
        z.setText("0");
        result.setText("");
    }

}
