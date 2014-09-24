package osgi.timeservice.blueprint.impl;

import osgi.timeservice.api.TimeService;

public class GpsTimeService implements TimeService {

    @Override
    public long now() {
        long time = System.currentTimeMillis();
        System.out.println(getClass() + " has time " + time);
        return time;
    }
}
