/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
  private static Motor m_motor;
  double m_wheelSpeed;
  double m_speed;
  public final double MAX_MOTOR_RPM = 5310;

  /**
   * Creates a new Motor.
   */
  private Motor() {
    m_wheelSpeed = 0;
  }

  public static Motor getInstance() {
    if (m_motor == null) {
      m_motor = new Motor();
    }
    return m_motor;
  }

  public void setSpeed(double speed) {
    m_speed = speed;
  }

  public void changeSpeed(double delta) {
    if (m_speed + delta > 1) {
      m_speed = 1;
    } else if (m_speed + delta < -1) {
      m_speed = -1;
    }
    else {
      m_speed = m_speed + delta;
    }
  }

  public double getWheelSpeed() {
    return m_wheelSpeed;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_wheelSpeed = m_speed * MAX_MOTOR_RPM;
    SmartDashboard.putNumber("m_wheelSpeed",m_wheelSpeed);
  }
}
