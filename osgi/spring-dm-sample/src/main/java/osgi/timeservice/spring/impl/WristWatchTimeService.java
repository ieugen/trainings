package osgi.timeservice.spring.impl;

import osgi.timeservice.api.TimeService;

/**
 * Tels time by watching the wrist-watch. High precision at it's best.
 */
public class WristWatchTimeService implements TimeService {

    @Override
    public long now() {
        long time = System.currentTimeMillis();
        System.out.println(getClass() + " time is " + time);
        return time;
    }
}
