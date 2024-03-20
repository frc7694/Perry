package frc.robot.OI.button.HIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.Controller;
import frc.robot.OI.button.ButtonType;

public enum EncoderButton implements ButtonType {
    RIGHT(90),
    LEFT(270);

    public int angle;

    EncoderButton(int angle) {
        this.angle = angle;
    }

    public int getValue() {
        return angle;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> Controller.HIDI3.getPOV() == input);
    }

}
