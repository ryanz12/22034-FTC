package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;


import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;


public class  DriveCommand extends CommandBase {

    private final DriveSubsystem driveSubsystem;
    private final GamepadEx gamepadEx;

    public DriveCommand(DriveSubsystem driveSubsystem, GamepadEx gamepadEx) {
        this.driveSubsystem = driveSubsystem;
        this.gamepadEx = gamepadEx;

        addRequirements(driveSubsystem);
    }


    @Override
    public void execute() {
        // they are all negative because it feels better for driver
        double strafe = -gamepadEx.getLeftX();
        double forward = -gamepadEx.getLeftY();
        double rotate = -gamepadEx.getRightX();

        driveSubsystem.drive(strafe, forward, rotate);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
