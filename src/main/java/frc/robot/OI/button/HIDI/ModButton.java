package frc.robot.OI.button.HIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.Controller;
import frc.robot.OI.button.ButtonType;

public enum ModButton implements ButtonType {

    MOD;

    public int getValue() {
        return 11;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        // TODO: have button 11 output modchanged (toggle not wait+off)
        return new Trigger(() -> Controller.HIDI3.getRawButton(11));
    }

}
