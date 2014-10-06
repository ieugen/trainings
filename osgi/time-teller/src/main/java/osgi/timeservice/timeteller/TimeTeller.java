package osgi.timeservice.timeteller;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import osgi.timeservice.api.TimeService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component(immediate = true)
public class TimeTeller {

    Set<TimeService> timeServices = new HashSet<TimeService>();

    @Activate
    public void activate(Map<String,Object> config) {
        System.out.println(getClass() + " activated");
        tellTime();
    }

    @Modified
    public void update() {
        System.out.println(getClass() + " modfied");
        tellTime();
    }

    @Deactivate
    public void deactivate() {
        System.out.println(getClass() + " deactivated");
    }

    @Reference(cardinality = ReferenceCardinality.MANDATORY,
            service = TimeService.class,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "removeTimeService",
            policyOption = ReferencePolicyOption.GREEDY
    )
    public void addTimeService(TimeService timeService) {
        timeServices.add(timeService);
        System.out.println("Added " + timeService + " total " + timeServices.size());
    }

    protected void removeTimeService(TimeService timeService) {
        timeServices.remove(timeService);
        System.out.println("Removed " + timeService + " total " + timeServices.size());
    }

    private void tellTime() {
        System.out.println("Telling time now");
        for (TimeService timeService : timeServices) {
            timeService.now();
        }
    }
}
