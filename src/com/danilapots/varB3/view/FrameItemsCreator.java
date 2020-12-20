package com.danilapots.varB3.view;

import com.danilapots.varB3.entity.FrameData;
import com.danilapots.varB3.logic.MathFormulaCalculator;

import javax.swing.*;
import java.awt.*;

public class FrameItemsCreator {
    private final MathFormulaCalculator formulaCalculator;

    public FrameItemsCreator(MathFormulaCalculator formulaCalculator) {
        this.formulaCalculator = formulaCalculator;
    }

    private void createHorizontalLine(Box box) {
        box.setBorder(BorderFactory.createLineBorder(Color.RED));
        box.add(Box.createHorizontalGlue());
    }

    public Box createRadioButtonsBox(FrameData frameData) {
        Box formulaButtonsBox = Box.createHorizontalBox();
        createHorizontalLine(formulaButtonsBox);
        JRadioButton firstButton = new JRadioButton("First formula");
        JRadioButton secondButton = new JRadioButton("Second formula");
        setRadioButtonsAction(firstButton, secondButton, frameData);
        firstButton.setSelected(true);
        frameData.setFormulaId(1);
        formulaButtonsBox.add(firstButton);
        formulaButtonsBox.add(secondButton);
        createHorizontalLine(formulaButtonsBox);
        return formulaButtonsBox;
    }

    private void setRadioButtonsAction(JRadioButton first, JRadioButton second, FrameData frameData) {
        first.addActionListener(ev -> {
            frameData.setFormulaId(1);
            second.setSelected(!first.isSelected());
        });
        second.addActionListener(ev -> {
            frameData.setFormulaId(2);
            first.setSelected(!second.isSelected());
        });
    }

    public Box createVariableFieldsBox(FrameData frameData) {
        Box variablesInputBox = Box.createHorizontalBox();
        createHorizontalLine(variablesInputBox);
        addVariableField(variablesInputBox, "X", frameData);
        variablesInputBox.add(Box.createHorizontalStrut(40));
        addVariableField(variablesInputBox, "Y", frameData);
        variablesInputBox.add(Box.createHorizontalStrut(40));
        addVariableField(variablesInputBox, "Z", frameData);
        variablesInputBox.add(Box.createHorizontalStrut(10));
        createHorizontalLine(variablesInputBox);
        return variablesInputBox;
    }

    private void addVariableField(Box variablesInputBox, String variableName, FrameData frameData) {
        JLabel label = new JLabel(variableName + ":");
        JTextField textField = new JTextField("0", 10);
        textField.setMaximumSize(textField.getPreferredSize());
        variablesInputBox.add(Box.createHorizontalStrut(10));
        variablesInputBox.add(label);
        variablesInputBox.add(Box.createHorizontalStrut(10));
        frameData.setVariableField(variableName, textField);
        variablesInputBox.add(textField);
    }

    public Box createResultBox(FrameData frameData) {
        JLabel labelForResult = new JLabel("Результат:");
        JTextField textFieldResult = new JTextField("", 10);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        frameData.setResultField(textFieldResult);
        Box resultBox = Box.createHorizontalBox();
        createHorizontalLine(resultBox);
        resultBox.add(labelForResult);
        resultBox.add(Box.createHorizontalStrut(10));
        resultBox.add(textFieldResult);
        resultBox.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        resultBox.add(Box.createHorizontalGlue());
        return resultBox;
    }

    public Box createButtonsBox(FrameData frameData, JFrame mainFrame) {
        JButton buttonCalc = createCalculatingButton(frameData, mainFrame);
        JButton buttonReset = createClearButton(frameData);
        Box buttons = Box.createHorizontalBox();
        createHorizontalLine(buttons);
        buttons.add(buttonCalc);
        buttons.add(Box.createHorizontalStrut(30));
        buttons.add(buttonReset);
        createHorizontalLine(buttons);
        return buttons;
    }

    private JButton createCalculatingButton(FrameData frameData, JFrame mainFrame) {
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(ev -> {
            try {
                Double x = Double.parseDouble(frameData.getX());
                Double y = Double.parseDouble(frameData.getY());
                Double z = Double.parseDouble(frameData.getZ());
                Double result;
                int formulaId = frameData.getFormulaId();
                result = formulaCalculator.calculate(formulaId, x, y, z);
                frameData.setResult(String.format("%.5f", result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainFrame,
                        "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        return buttonCalc;
    }

    private JButton createClearButton(FrameData frameData) {
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(ev -> frameData.clearVariables());
        return buttonReset;
    }
}
