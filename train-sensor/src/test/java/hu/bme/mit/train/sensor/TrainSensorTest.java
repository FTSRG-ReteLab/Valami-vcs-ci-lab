package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller;
    TrainUser user;
    TrainSensor sensor;

    @Before
    public void before() {
        // TODO Add initializations
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void TestCase1() {
        sensor.overrideSpeedLimit(-1);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void TestCase2() {
        sensor.overrideSpeedLimit(501);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void TestCase3() {
        sensor.overrideSpeedLimit(sensor.getSpeedLimit()/4);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void TestCase4() {
        sensor.overrideSpeedLimit(sensor.getSpeedLimit());
        verify(user, times(0)).setAlarmState(true);
    }
}

