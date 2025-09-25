package org.firstinspires.ftc.teamcode.OpMode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Commands.DriveCommands;
import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;

public class TeleOpMode extends CommandOpMode {
    @Override
    public void initialize() {

        DriveTrain driveTrain= new DriveTrain(hardwareMap);
        GamepadEx driver = new GamepadEx(gamepad1);

        driveTrain.setDefaultCommand(new DriveCommands(driveTrain, ()-> driver.getLeftY(), driver::getRightX))  ;
    }
}
