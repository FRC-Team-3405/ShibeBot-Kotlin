package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot
import frc.team3405.robot.Xbox
var pressed = false
class DriveCommand : Command() {

    init {
        requires(Robot.driveTrain)
    }

    override fun execute() {
        if (Robot.joystick.joystick.getRawButton(Xbox.YButton) && !pressed ) {
            pressed = true
            Robot.ArcadeDrive = Robot.ArcadeDrive.not()
        }
        if (!Robot.joystick.joystick.getRawButton(Xbox.YButton)) {
            pressed = false
        }
        if(Robot.ArcadeDrive) {
            Robot.driveTrain.arcadeDrive()
        } else {
            Robot.driveTrain.tankDrive()
        }
    }

    override fun isFinished(): Boolean = false
}