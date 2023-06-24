// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSource;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OIConstants;
import frc.robot.controls.ControlList;
import frc.robot.controls.inputs.Controller;
import frc.robot.controls.lists.Comp;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import java.util.UUID;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  public static final DriveSubsystem m_robotDrive = new DriveSubsystem();
  public static final ArmSubsystem m_robotArm = new ArmSubsystem();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_robotDrive.setDefaultCommand(
            // The left stick controls translation of the robot.
            // Turning is controlled by the X axis of the right stick.
            new RunCommand(
                    () -> {
                      if (!RunningConfig.perryIsControllingHimselfAgainOhNo)
                        m_robotDrive.drive(
                              -MathUtil.applyDeadband(Controller.XBox.getLeftY(), OIConstants.kDriveDeadband),
                              -MathUtil.applyDeadband(Controller.XBox.getLeftX(), OIConstants.kDriveDeadband),
                              -MathUtil.applyDeadband(Controller.XBox.getRightX(), OIConstants.kDriveDeadband),
                              true, true);
                    },
                    m_robotDrive));
    if (Robot.isReal()) {
      Cameras.init();
    }
  }

  private void configureButtonBindings() {
    for (ControlList control : Comp.values()) {
      Trigger button = control.getType().getSupplier(control.getController(), control.getType().getValue());

      switch (control.getWhen()) {
        case ON_TRUE:
          button.onTrue(control.getFunction());
          break;
        case ON_FALSE:
          button.onFalse(control.getFunction());
          break;
        case WHILE_TRUE:
          button.whileTrue(control.getFunction());
          break;
        case WHILE_FALSE:
          button.whileFalse(control.getFunction());
          break;
      }
    }
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
   * passing it to a
   * {@link JoystickButton}.
   */

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public static void setX() {
    m_robotDrive.setX();
  }

  public static ControlList[] getControls() {
    return Comp.values();
  }

  // Resets the gyro to tell the robot that it
  // is facing forward relative to the field
  public static void resetFOD() {
    OffsettableGyro.reset();
  }

  public static void toggleFOD() {
    RunningConfig.fod = !RunningConfig.fod;
  }

}
