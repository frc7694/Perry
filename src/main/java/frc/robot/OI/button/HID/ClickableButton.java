package frc.robot.OI.button.HID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.button.ButtonType;

public enum ClickableButton implements ButtonType {
    A(1),
    B(2),
    X(3),
    Y(4),
    LB(5),
    RB(6),
    LSTICK(9),
    RSTICK(10),
    LINES(8),
    SQUARES(7);

    public final int value;

    ClickableButton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> controller.getRawButton(input));
    }

}
