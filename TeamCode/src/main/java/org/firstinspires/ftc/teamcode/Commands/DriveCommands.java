package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.robocol.Command;

import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;

import java.util.function.DoubleSupplier;

public class DriveCommands extends CommandBase {
    private DriveTrain driveTrain;
    private DoubleSupplier leftY, rightX;

    public DriveCommands(DriveTrain driveTrain, DoubleSupplier leftY, DoubleSupplier rightX){
        this.driveTrain = driveTrain;
        this.leftY = leftY;
        this.rightX = rightX;

        addRequirements(driveTrain);

    }

    @Override
    public void execute() {
        driveTrain.drive(leftY.getAsDouble(), rightX.getAsDouble());
    }
}
