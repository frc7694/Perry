package frc.robot.OI.button.HIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.Controller;
import frc.robot.OI.button.ButtonType;

public enum TransportButton implements ButtonType {

    REW(5),
    FF(6),
    STOP(7),
    PLAY(8),
    REC(9),
    SUS(10);

    public int pos;

    TransportButton(int pos) {
        this.pos = pos;
    }

    public int getValue() {
        return pos;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> Controller.HIDI3.getRawButton(input));
    }

}
