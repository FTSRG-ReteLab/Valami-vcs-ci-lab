package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

TrainSensor ts;

    @Before
    public void before() {
        // TODO Add initializations
	TrainController tc = new TrainController();
	TrainUser tu = new TrainUser(tc);
	ts = new TrainSensor(tc, tu);
	
    }

    @Test
    public void SpeedLimitTest() {
        assert ts.getSpeedLimit() == 6;
    }
}
