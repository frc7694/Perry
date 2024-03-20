package frc.robot.OI.button.HID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.button.ButtonType;

public enum POVButton implements ButtonType {
    NN(0),
    NE(45),
    EE(90),
    SE(135),
    SS(180),
    SW(225),
    WW(270),
    NW(315);

    public int angle;

    POVButton(int angle) {
        this.angle = angle;
    }

    public int getValue() {
        return angle;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> controller.getPOV() == input);
    }

}
