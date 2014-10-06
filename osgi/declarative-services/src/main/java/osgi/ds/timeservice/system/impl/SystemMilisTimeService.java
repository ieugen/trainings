package osgi.ds.timeservice.system.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import osgi.timeservice.api.TimeService;

import java.util.Map;

@Component(properties = "META-INF/SystemTimeService.properties",
        immediate = true, service = TimeService.class)
public class SystemMilisTimeService implements TimeService {

    private Map<String, Object> config;

    @Activate
    public void activate(Map<String, Object> props) {
        System.out.println(getClass() + " activated");
        this.config = props;
    }

    @Modified
    public void update(Map<String, Object> props) {
        System.out.println(getClass() + " updated");
        config = props;
    }

    @Deactivate
    public void deactivate() {
        System.out.println(getClass() + " deactivated");
    }

    @Override
    public long now() {
        long time = System.currentTimeMillis();
        System.out.println(getClass().toString() +"" +config.get("message") + time);
        return time;
    }

}
