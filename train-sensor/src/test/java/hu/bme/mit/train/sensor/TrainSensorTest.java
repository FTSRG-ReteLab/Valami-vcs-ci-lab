package hu.bme.mit.train.sensor;


import hu.bme.mit.train.interfaces.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensor sensor;
    TrainController controller;
    TrainUser user;

    @Before
    public void before() {
        controller=mock(TrainController.class);
        user=mock(TrainUser.class);

        sensor=new TrainSensorImpl(controller,user);
    }

    @Test
    public void SpeedLimitBelow0Test() {
        when(controller.getReferenceSpeed()).thenReturn(150);

        sensor.overrideSpeedLimit(-1);
        verify(user,times(1)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitAbove500Test() {
        when(controller.getReferenceSpeed()).thenReturn(150);

        sensor.overrideSpeedLimit(501);
        verify(user,times(1)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitInRangeTest() {
        when(controller.getReferenceSpeed()).thenReturn(150);

        sensor.overrideSpeedLimit(200);
        verify(user,times(1)).setAlarmState(false);
    }

    @Test
    public void SpeedLimitRelativeTest() {
        when(controller.getReferenceSpeed()).thenReturn(150);

        sensor.overrideSpeedLimit(50);
        verify(user,times(1)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitGetTest() {
        when(controller.getReferenceSpeed()).thenReturn(150);

        sensor.overrideSpeedLimit(200);
        assert sensor.getSpeedLimit()==200;
    }

}
