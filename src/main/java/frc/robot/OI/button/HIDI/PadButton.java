package frc.robot.OI.button.HIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.Controller;
import frc.robot.OI.button.ButtonType;

public enum PadButton implements ButtonType {

    P1(1),
    P2(2),
    P3(3),
    P4(4);

    public int pos;

    PadButton(int pos) {
        this.pos = pos;
    }

    public int getValue() {
        return pos;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> Controller.HIDI3.getRawButton(input));
    }

}
