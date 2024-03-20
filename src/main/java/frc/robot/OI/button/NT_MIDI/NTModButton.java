package frc.robot.OI.button.NT_MIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.button.ButtonType;

public enum NTModButton implements ButtonType {

    MOD;

    public int getValue() {
        return 0;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> SmartDashboard.getBoolean("midi/modChanged", false));
    }

}
