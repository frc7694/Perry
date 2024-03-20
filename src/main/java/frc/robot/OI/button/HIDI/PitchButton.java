package frc.robot.OI.button.HIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.Controller;
import frc.robot.OI.button.ButtonType;
import frc.robot.values.Constants;

public enum PitchButton implements ButtonType {

    UP(1),
    DOWN(2);

    public int value;

    PitchButton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        if (input == 0) {
            return new Trigger(() -> Controller.HIDI3.getRawAxis(input) > Constants.OIConstants.kDriveDeadband);
        } else {
            return new Trigger(() -> Controller.HIDI3.getRawAxis(input) < Constants.OIConstants.kDriveDeadband);
        }
    }

}
