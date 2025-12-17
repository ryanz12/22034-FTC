package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.FlywheelSubsystem;

public class FlywheelCommand extends CommandBase {
    private final FlywheelSubsystem FlywheelSubsystem;
    private final GamepadEx operatorGamepad;

    public FlywheelCommand(FlywheelSubsystem flywheelSubsystem, GamepadEx operatorGamepad) {
        this.FlywheelSubsystem = flywheelSubsystem;
        this.operatorGamepad = operatorGamepad;
        addRequirements(flywheelSubsystem);

    }

    @Override
    public void execute() {

        if (operatorGamepad.getLeftY() > 0) {
            double power = operatorGamepad.getLeftY()/2;
            FlywheelSubsystem.setPower(power+0.5);
        } else {
            FlywheelSubsystem.setPower(0);
        }
    }
    @Override
    public boolean isFinished() {
        return false;
    }

}
