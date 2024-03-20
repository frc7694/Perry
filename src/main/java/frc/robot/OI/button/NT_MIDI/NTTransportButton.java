package frc.robot.OI.button.NT_MIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.button.ButtonType;

public enum NTTransportButton implements ButtonType {

    SUS(3),
    REW(5),
    FF(4),
    STOP(1),
    PLAY(2),
    REC(6);

    public int pos;

    NTTransportButton(int pos) {
        this.pos = pos;
    }

    public int getValue() {
        return pos;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> SmartDashboard.getBoolean("midi/b" + input, false));
    }

}
