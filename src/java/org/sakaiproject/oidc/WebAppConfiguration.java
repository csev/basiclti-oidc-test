
package org.sakaiproject.oidc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.setServletContext(servletContext);
        rootContext.register(org.sakaiproject.oidc.WebMvcConfiguration.class);

		/*
        Dynamic servlet = servletContext.addServlet("org.sakaiproject.oidc.lti13.OIDCServlet",
				new DispatcherServlet(rootContext));
        servlet.addMapping("/lti13/*");
        servlet.setLoadOnStartup(1);
		*/

        Dynamic servlet2 = servletContext.addServlet("org.sakaiproject.oidc.lti11.LTI11AnonymousServlet",
				new DispatcherServlet(rootContext));
        servlet2.addMapping("/lti11/*");
        servlet2.setLoadOnStartup(2);

        Dynamic servlet3 = servletContext.addServlet("org.sakaiproject.oidc.lti11.ZapServlet",
				new DispatcherServlet(rootContext));
        servlet3.addMapping("/zap/*");
        servlet3.setLoadOnStartup(3);
    }
}
