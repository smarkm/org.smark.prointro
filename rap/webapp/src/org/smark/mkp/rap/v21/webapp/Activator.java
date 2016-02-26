package org.smark.mkp.rap.v21.webapp;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	private static Activator plugin;
	  private ExampleContributionsTracker serviceTracker;
	  private ServiceRegistration<?> registration;

	  public void start( BundleContext context ) throws Exception {
	    plugin = this;
	    serviceTracker = new ExampleContributionsTracker( context );
	    serviceTracker.open();
	    Dictionary<String, String> properties = new Hashtable<String, String>();
	    properties.put( "contextPath", "rapdemo" );
	    registration = context.registerService( ApplicationConfiguration.class.getName(),
	                                            new BasicApplication(),
	                                            properties );
	  }

	  public void stop( BundleContext context ) throws Exception {
	    registration.unregister();
	    serviceTracker.close();
	    serviceTracker = null;
	    plugin = null;
	  }

	  public ExampleContributionsTracker getExampleContributions() {
	    return serviceTracker;
	  }

	  public static Activator getDefault() {
	    return plugin;
	  }

}
