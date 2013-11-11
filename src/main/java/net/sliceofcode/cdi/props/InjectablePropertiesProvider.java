package net.sliceofcode.cdi.props;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author pascr
 */
@ApplicationScoped
public class InjectablePropertiesProvider {

    private static final String DEFAULT_PROPERTIES_FILENAME = "configuration.properties";
    private Properties props;

    @PostConstruct
    public void loadProperties() throws IOException
    {
        props = new Properties();
        String fileName = DEFAULT_PROPERTIES_FILENAME;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null)
        {
            throw new FileNotFoundException("Properties file " + fileName + " not found");
        }
        props.load(inputStream);
    }

    @Produces
    @Value
    public String getStringValue(InjectionPoint ip)
    {
        Value config = ip.getAnnotated().getAnnotation(Value.class);
        String key = config.value();
        if (key.isEmpty())
        {
            throw new IllegalArgumentException("Property key is required.");
        }
        return props.getProperty(key);
    }

    @Produces
    @Value
    public Integer getIntegerValue(InjectionPoint ip)
    {
        String value = getStringValue(ip);
        return (value != null) ? Integer.valueOf(value) : null;
    }
}