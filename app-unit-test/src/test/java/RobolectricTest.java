import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class RobolectricTest {

    @Test
    public void shouldHaveHappySmiles() throws Exception {

        Assert.assertNotNull(Robolectric.application);
        System.out.println(Robolectric.application);
    }

}