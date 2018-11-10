package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import frc.team3405.robot.Xbox
import frc.team3405.robot.commands.ShootCommand

class Launcher : Subsystem() {

    private val feeder by lazy {Robot.feeder}
    private val leftLauncher by lazy{ Robot.leftLauncher}
    private val rightLauncher by lazy{ Robot.rightLauncher}

    override fun initDefaultCommand() {
        defaultCommand = ShootCommand()
    }

    fun arcadeDrive() {
        val x = Robot.joystick.rightX
        val y = Robot.joystick.rightY
        val maxOutput = .6
        val feederSpeed = -0.5
        var left: Double = (y - x) * maxOutput
        var right: Double = (y + x) * maxOutput
        if (left > 0.0) {
            left = 0.0
        }
        if (right > 0.0) {
            right = 0.0
        }
        rightLauncher.set(-right)
        leftLauncher.set(left)
        if(Robot.joystick.joystick.getRawButton(Xbox.RightLowerBumper)) {
            feeder.set(feederSpeed)
        } else {
            feeder.set(0.0)
        }
    }

    //For Eastmond
    fun tankDrive() {
        print("Tank drive")
        val maxOutput = .5
        val feederSpeed = .2
        if(Robot.joystick.joystick.getRawButton(Xbox.LeftLowerBumper)) {
            rightLauncher.set(maxOutput)
            leftLauncher.set(maxOutput)
        } else {
            rightLauncher.set(0.0)
            leftLauncher.set(0.0)
        }
        if(Robot.joystick.joystick.getRawButton(Xbox.RightLowerBumper)) {
            feeder.set(feederSpeed)
        } else {
            feeder.set(0.0)
        }
    }
}

