package frc.robot.controls.inputs.button.HID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.controls.inputs.button.ButtonType;

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
    SQUARES(7),
    N1(1),
    N2(2),
    N3(3),
    N4(4),
    N5(5),
    N6(6),
    N7(7),
    N8(8),
    N9(9),
    N0(10);

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
