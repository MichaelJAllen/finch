package edu.cmu.ri.createlab.terk.robot.finch.services;

import edu.cmu.ri.createlab.terk.TerkConstants;
import edu.cmu.ri.createlab.terk.properties.BasicPropertyManager;
import edu.cmu.ri.createlab.terk.properties.PropertyManager;
import edu.cmu.ri.createlab.terk.robot.finch.FinchController;
import edu.cmu.ri.createlab.terk.services.accelerometer.AccelerometerService;
import edu.cmu.ri.createlab.terk.services.accelerometer.AccelerometerState;
import edu.cmu.ri.createlab.terk.services.accelerometer.BaseAccelerometerServiceImpl;

/**
 * @author Chris Bartley (bartley@cmu.edu)
 */
final class AccelerometerServiceImpl extends BaseAccelerometerServiceImpl
   {
   static AccelerometerServiceImpl create(final FinchController finchController)
      {
      final BasicPropertyManager basicPropertyManager = new BasicPropertyManager();

      basicPropertyManager.setReadOnlyProperty(TerkConstants.PropertyKeys.DEVICE_COUNT, finchController.getFinchProperties().getAccelerometerDeviceCount());
      basicPropertyManager.setReadOnlyProperty(AccelerometerService.PROPERTY_NAME_ACCELEROMETER_DEVICE_ID, finchController.getFinchProperties().getAccelerometerDeviceId());

      return new AccelerometerServiceImpl(finchController,
                                          basicPropertyManager,
                                          finchController.getFinchProperties().getAccelerometerDeviceCount());
      }

   private final FinchController finchController;

   private AccelerometerServiceImpl(final FinchController finchController,
                                    final PropertyManager propertyManager,
                                    final int deviceCount)
      {
      super(propertyManager, deviceCount);
      this.finchController = finchController;
      }

   public AccelerometerState getAccelerometerState(final int id)
      {
      return finchController.getAccelerometerState();
      }
   }