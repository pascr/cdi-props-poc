package net.sliceofcode.cdi.props;


import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * @author pascr
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(InjectablePropertiesProvider.class)
public class InjectPropertiesTest
{
    @Inject
    @Value("some.string.value")
    private String someStringValue;

    @Inject
    @Value("some.integer.value")
    private Integer someIntegerValue;


    @Test
    public void injected_properties_matches_test()
    {
        assertEquals("value mismatch [String]", "lorem ipsum", someStringValue);
        assertEquals("value mismatch [Integer]", 33, someIntegerValue.intValue());
    }

}
