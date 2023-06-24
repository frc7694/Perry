package frc.robot.controls.inputs.button.HID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.controls.inputs.button.ButtonType;

public enum TriggerButton implements ButtonType {

    DOWN(1),
    L(2),
    R(3);

    public final int value;

    TriggerButton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> controller.getRawAxis(input) > Constants.OIConstants.kDriveDeadband);
    }

}
