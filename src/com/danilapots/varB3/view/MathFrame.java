package com.danilapots.varB3.view;

import com.danilapots.varB3.entity.FrameData;

import java.awt.*;
import javax.swing.*;

public class MathFrame extends JFrame {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 700;

    public MathFrame(FrameItemsCreator frameItemsCreator) {
        super("Math formulas calculator");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        FrameData frameData = new FrameData();

        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - FRAME_WIDTH) / 2,
                (kit.getScreenSize().height - FRAME_HEIGHT) / 2);

        Box formulaButtonsBox = frameItemsCreator.createRadioButtonsBox(frameData);
        Box variablesInputBox = frameItemsCreator.createVariableFieldsBox(frameData);
        Box resultBox = frameItemsCreator.createResultBox(frameData);
        Box buttonsBox = frameItemsCreator.createButtonsBox(frameData, this);

        initializeContentBox(formulaButtonsBox, variablesInputBox, resultBox, buttonsBox);
    }

    private void initializeContentBox(Box formulaButtonsBox,Box variablesInputBox,Box resultBox, Box buttonsBox) {
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(formulaButtonsBox);
        contentBox.add(variablesInputBox);
        contentBox.add(resultBox);
        contentBox.add(buttonsBox);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }
}
