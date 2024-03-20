// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.util;

import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * A Command that runs instantly; it will initialize, execute once, and end on the same iteration of
 * the scheduler. Users can either pass in a Runnable and a set of requirements, or else subclass
 * this command if desired.
 *
 * <p>This class is provided by the NewCommands VendorDep
 */
public class InstantNonPhysicalCommand extends FunctionalCommand {
    public InstantNonPhysicalCommand(Runnable toRun, Subsystem... requirements) {
        super(toRun, () -> {}, interrupted -> {}, () -> true, requirements);
    }

    public InstantNonPhysicalCommand() {
        this(() -> {});
    }

    @Override
    public boolean runsWhenDisabled() {
        return true;
    }
}
