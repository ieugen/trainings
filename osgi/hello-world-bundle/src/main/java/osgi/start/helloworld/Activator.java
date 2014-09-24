package osgi.start.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Hello from OSGi");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye from OSGi");
    }
}
