package com.danilapots.varB3.application;
import com.danilapots.varB3.logic.MathFormulaCalculator;
import com.danilapots.varB3.view.FrameItemsCreator;
import com.danilapots.varB3.view.MathFrame;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        MathFormulaCalculator mathFormulaCalculator = new MathFormulaCalculator();
        FrameItemsCreator frameItemsCreator = new FrameItemsCreator(mathFormulaCalculator);
        MathFrame frame = new MathFrame(frameItemsCreator);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
