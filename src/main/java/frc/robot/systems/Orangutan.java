package frc.robot.systems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class Orangutan {

    // Forward: 180
    // Left: 90
    // Right: 270
    // Backward: 360

    private static AHRS gyro;
    private static double offset = 0;

    public static void init() {
        gyro = new AHRS(SPI.Port.kMXP);
    }

    public static void reset() {
        gyro.reset();
        offset = 0;
    }

    public static void set(double offset) {
        Orangutan.offset = offset;
    }

    private static double positive() {
        return gyro.getYaw() + 180;
    }

    public static double get() {
        return positive() - offset;
    }

    public static boolean is(double desiredPos) {
        return Math.abs(desiredPos % 360 - get() % 360) < .5;
    }

    public static double getRoll() {
        return gyro.getRoll();
    }

    public static double getPitch() {
        return gyro.getPitch();
    }

    // Useful for checking if you eat the orangutan and peel the banana, or you peel the orangutan and eat the banana
    public static boolean isPeelable() {
        return true;
    }

    public static boolean isEdible() {
        return !Banana.isPeelable();
    }

}
