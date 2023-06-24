package frc.robot;

import com.kauailabs.navx.frc.AHRS;

public class OffsettableGyro {

    // Forward: 180
    // Left: 90
    // Right: 270
    // Backward: 360

    static AHRS gyro;
    private static double offset = 0;

    public static void reset() {
        gyro.reset();
        offset = 0;
    }

    public static void set(double offset) {
        OffsettableGyro.offset = offset;
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

}
