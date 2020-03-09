package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import hu.bme.mit.train.*;

public class TrainSensorTest {

TrainSensor ts;

    @Before
    public void before() {
        // TODO Add initializations
	TrainController tc = new TrainControllerImpl();
	TrainUser tu = new TrainUserImpl(tc);
	ts = new TrainSensorImpl(tc, tu);
	
    }

    @Test
    public void SpeedLimitTest() {
        assert ts.getSpeedLimit() == 6;
    }
}
