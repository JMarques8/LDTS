package org.example.model.menu;

import java.util.Arrays;
import java.util.List;

public class InstructionsMenu {

    private final List<String> instructions;

    private int currentInstruction = 0;

    public InstructionsMenu() {
        this.instructions = Arrays.asList(
                "Back"
        );
    }

    public void nextInstruction() {
        currentInstruction++;

        if (currentInstruction > this.instructions.size() - 1) {
            currentInstruction = 0;
        }
    }

    public void previousInstruction() {
        currentInstruction--;
        if (currentInstruction < 0) {
            currentInstruction = this.instructions.size() - 1;
        }
    }

    public int getCurrentInstruction() {
        return currentInstruction;
    }

    public String getInstruction(int i) {
        return instructions.get(i);
    }

    public boolean isSelected(int i) {
        return currentInstruction == i;
    }

    public int getNumberOfInstructions() {
        return this.instructions.size();
    }

}
