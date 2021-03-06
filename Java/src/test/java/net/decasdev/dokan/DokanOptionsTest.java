package net.decasdev.dokan;

import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

/**
 * Author : Saine Imad
 * Class : DokanOptionsTest
 * Description : Test DokanOptionsMode
 */
public class DokanOptionsTest {

    private static Logger logger = LoggerFactory.getLogger(DokanOptionsMode.class);

    @Test
    public void OptionsTest(){
        
        int value = 0x20;
        EnumSet<DokanOptionsMode.Mode> mode = DokanOptionsMode.getFlags(value);
        Assert.assertTrue(mode.contains(DokanOptionsMode.Mode.REMOVABLE_DRIVE));
        Assert.assertFalse(mode.contains(DokanOptionsMode.Mode.NETWORK_DRIVE));

        value = 0x10 | 0x1;
        mode = DokanOptionsMode.getFlags(value);
        Assert.assertTrue(mode.contains(DokanOptionsMode.Mode.DEBUG));
        Assert.assertTrue(mode.contains(DokanOptionsMode.Mode.NETWORK_DRIVE));
        Assert.assertFalse(mode.contains(DokanOptionsMode.Mode.REMOVABLE_DRIVE));

        value = DokanOptionsMode.Mode.ALT_STREAM.getValue();
        mode = DokanOptionsMode.getFlags(value);
        Assert.assertFalse(mode.contains(DokanOptionsMode.Mode.REMOVABLE_DRIVE));
        Assert.assertTrue(mode.contains(DokanOptionsMode.Mode.ALT_STREAM));

        value = DokanOptionsMode.Mode.DEBUG.getValue() | DokanOptionsMode.Mode.REMOVABLE_DRIVE.getValue();
        mode = DokanOptionsMode.getFlags(value);
        logger.info("Mode = " + mode);




    }
}
