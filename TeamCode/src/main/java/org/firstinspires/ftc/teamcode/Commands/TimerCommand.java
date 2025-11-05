package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystem.Shooter;

import java.util.concurrent.TimeUnit;

public class TimerCommand extends CommandBase {



    private  final  Timing.Timer timer;

    public TimerCommand() {

        timer = new Timing.Timer(5, TimeUnit.SECONDS);

        addRequirements();

    }

    @Override
    public void initialize() {
        timer.start();
    }


    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished(){
        return timer.done();
    }

    @Override
    public void end(boolean interrupted) {

        super.end(interrupted);

    }
}

