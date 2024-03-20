package frc.robot.OI.button.HIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.Controller;
import frc.robot.OI.button.ButtonType;

public enum KeyButton implements ButtonType {

    c4(1),
    c_4(2),
    d4(3),
    d_4(4),
    e4(5),
    f4(6),
    f_4(7),
    g4(8),
    g_4(9),
    a4(10),
    a_4(11),
    b4(12),
    c5(13),
    c_5(14),
    d5(15),
    d_5(16),
    e5(17),
    f5(18),
    f_5(19),
    g5(20),
    g_5(21),
    a5(22),
    a_5(23),
    b5(24),
    c6(26);

    public final int pos;

    KeyButton(int pos) {
        this.pos = pos;
    }

    public int getValue() {
        return pos;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        if (input > 16)  {
            return new Trigger(() -> Controller.HIDI2.getRawButton(input - 16));

        } else {
            return new Trigger(() -> Controller.HIDI1.getRawButton(input));
        }

    }

}
