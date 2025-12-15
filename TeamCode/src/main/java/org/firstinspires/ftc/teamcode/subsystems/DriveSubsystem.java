package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class DriveSubsystem extends SubsystemBase {
    private MecanumDrive drivetrain;
    private Motor leftFront, leftBack, rightFront, rightBack;

    public DriveSubsystem(HardwareMap hwMap){
        leftFront = new Motor(hwMap, "leftFront", Motor.GoBILDA.RPM_312);
        leftBack = new Motor(hwMap, "leftBack", Motor.GoBILDA.RPM_312);
        rightFront = new Motor(hwMap, "rightFront", Motor.GoBILDA.RPM_312);
        rightBack = new Motor(hwMap, "rightBack", Motor.GoBILDA.RPM_312);

        drivetrain = new MecanumDrive(leftFront, rightFront, leftBack, rightBack);
    }

    public void drive(double strafe, double forward, double rotate){
        drivetrain.driveRobotCentric(strafe, forward, rotate);
    }

}
