package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    public enum Intakepart {
        GROUND,
        TRANSFER,
        FULL_INTAKE,
        FULL_REVERSE
    }
    private final IntakeSubsystem intakeSubsystem;
    private final Intakepart partToRun;
    public IntakeCommand(IntakeSubsystem intakeSubsystem, Intakepart partToRun) {
        this.intakeSubsystem = intakeSubsystem;
        this.partToRun = partToRun;
        addRequirements(intakeSubsystem);
    }
    @Override
    public void execute() {
        switch (partToRun) {
            case GROUND:
                intakeSubsystem.runGroundIntake();
                break;
            case TRANSFER:
                intakeSubsystem.runTransfer();
                break;
            case FULL_INTAKE: // Add this case
                intakeSubsystem.runFullIntake();
                break;
            case FULL_REVERSE: // Add this case
                intakeSubsystem.runFullReverse();
                break;

        }
    }

}
