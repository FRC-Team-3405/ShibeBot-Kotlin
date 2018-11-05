package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot
import frc.team3405.robot.Xbox

var enabled = false
var xpressed = false

class SmartDashboardCommand : Command(){
    init {}

    override fun execute() {
        if (Robot.joystick.joystick.getRawButton(Xbox.XButton) && !xpressed ) {
            xpressed = true
            enabled = enabled.not()
            print("smartdashboard is $enabled")
        }
        if (!Robot.joystick.joystick.getRawButton(Xbox.YButton)) {
            xpressed = false
        }
        if(enabled) {
            Robot.SmartDashboard.run()
        }
    }

    override fun isFinished(): Boolean = false
}