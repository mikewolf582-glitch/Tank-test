package org.firstinspires.ftc.teamcode.OpMode;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.util.Timing;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Commands.DriveCommands;
import org.firstinspires.ftc.teamcode.Commands.ShooterCommand;
import org.firstinspires.ftc.teamcode.Commands.TimerCommand;
import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystem.Feeder;
import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.Shooter;

import java.util.concurrent.TimeUnit;

@TeleOp
public class TeleOpMode extends CommandOpMode {
    @Override
    public void initialize() {

        //DriveTrain driveTrain= new DriveTrain(hardwareMap, telemetry);
        GamepadEx driver = new GamepadEx(gamepad1);
       // Intake intake = new Intake (hardwareMap, telemetry);
        // Shooter shooter = new Shooter(hardwareMap);
        Feeder feeder = new Feeder(hardwareMap);



/*
       driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
               .whileHeld(()->intake.setPower(1))
               .whenReleased(()->intake.setPower(0));



        driver.getGamepadButton(GamepadKeys.Button.A)
                .whileHeld(()->shooter.setPower(1))
                .whenReleased(()->shooter.setPower(0));




         driver.getGamepadButton(GamepadKeys.Button.Y)
                 .whenPressed(
                         new ShooterCommand(shooter, 1)
                 );


*/

          driver.getGamepadButton(GamepadKeys.Button.X)
                  .whenPressed(
                         new SequentialCommandGroup(
                                 new InstantCommand(()-> feeder.setPosition(100, .3)),
                                 new TimerCommand(),
                                 new InstantCommand(()-> feeder.setPosition(300, .3)),
                                 new TimerCommand(),
                                 new InstantCommand(()-> feeder.setPosition(500, .3))
                         )


                  );







     //   driveTrain.setDefaultCommand(new DriveCommands(driveTrain, ()-> driver.getRightX(), driver::getLeftY))  ;

        schedule(new RunCommand (()-> {
           // driveTrain.update();
           // telemetry.addData("Heading", driveTrain.heading());

        }));








}

}
