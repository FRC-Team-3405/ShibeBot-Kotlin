package frc.team3405.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import frc.team3405.robot.Xbox
import frc.team3405.robot.commands.DriveCommand
import kotlin.math.pow

class DriveTrain : Subsystem() {
    private val Left1 = Talon(0) //Right Bottom
//    private val Right1 = Talon(1) //Left Top
//    private val Left2 = Talon(2) //Left Bottom
//    private val Right2 = Talon(3) //Right Top

    override fun initDefaultCommand() {
        defaultCommand = DriveCommand()
    }

    fun arcadeDrive() {
        val x = Robot.joystick.leftX.pow(2)
        val y = Robot.joystick.leftY.pow(2)
        val maxOutput = .7
        val left: Double = (y - x) * maxOutput
        val right: Double = (y + x) * maxOutput

//        Right1.set(-right)
//        Right2.set(-right)

        Left1.set(left)
//        Left2.set(left)
    }

    //For Eastmond
    fun tankDrive() {
        val leftY = Robot.joystick.leftY * 0.7
        val rightY = Robot.joystick.rightY * 0.7
        var maxOutput = .7
        if(Robot.joystick.joystick.getRawButton(Xbox.RightLowerBumper)) {
            maxOutput += .1
        } else if(Robot.joystick.joystick.getRawButton(Xbox.LeftLowerBumper)) {
            maxOutput -= .1
        }
        if(maxOutput < .1) {
            maxOutput = .1
        }
        if(maxOutput > 1.0) {
            maxOutput = 1.0
        }
        val left: Double = leftY * maxOutput
        val right: Double = rightY * maxOutput

        Left1.set(left)
//        Left2.set(left)
//        Right1.set(-right)
//        Right2.set(-right)

    }
}

