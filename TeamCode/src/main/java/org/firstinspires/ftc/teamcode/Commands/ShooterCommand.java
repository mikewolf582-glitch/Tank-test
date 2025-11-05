package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.Shooter;

import java.util.concurrent.TimeUnit;

public class ShooterCommand extends CommandBase {

    Shooter m_shooter;
    double power;
    Timing.Timer timer = new Timing.Timer(5, TimeUnit.SECONDS);

    public ShooterCommand( Shooter m_shooter, double power) {
        this.power = power;
        this.m_shooter = m_shooter;

        addRequirements( m_shooter);

    }

    @Override
    public void initialize() {
        timer.start();
    }


    @Override
    public void execute() {
        m_shooter.setPower(power);
    }

    @Override
    public boolean isFinished(){
        return timer.done();
    }

    @Override
    public void end(boolean interrupted) {

        m_shooter.setPower(0);
        super.end(interrupted);

    }
}