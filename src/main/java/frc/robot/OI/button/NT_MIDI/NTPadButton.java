package frc.robot.OI.button.NT_MIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.button.ButtonType;

public enum NTPadButton implements ButtonType {

    P1(36),
    P2(38),
    P3(40),
    P4(42);

    public int pos;

    NTPadButton(int pos) {
        this.pos = pos;
    }

    public int getValue() {
        return pos;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> SmartDashboard.getNumber("midi/p" + input, 0) > 0);
    }

}
