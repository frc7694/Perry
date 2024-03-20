package frc.robot.OI.button.HID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.values.Constants.OIConstants;
import frc.robot.OI.button.ButtonType;

public enum AxisButton implements ButtonType {

    DOWN(1),
    LTrigger(2),
    RTrigger(3);

    public final int value;

    AxisButton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> controller.getRawAxis(input) > OIConstants.kDriveDeadband);
    }

}
