package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AlarmTest {

    Alarm alarm;
    Sensor sensor;

    @Before
    public void prepare(){
        sensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(sensor);
    }



    @Test
    public void testAlarmsGoesOnLowPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(14.0);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmsGoesOnHighPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(34.0);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmsIsOff(){
        when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}