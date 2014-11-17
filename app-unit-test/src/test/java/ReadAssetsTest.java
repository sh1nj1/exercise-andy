import com.trumpia.android.test.MyRobolectricTestRunner;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import java.io.IOException;
import java.io.InputStream;

/**
 * Test case to read asset files in androidTest context.
 *
 * chk0ndanger
 */
@Config
@RunWith(MyRobolectricTestRunner.class)
public class ReadAssetsTest {

    @Before
    public void setUp() {

        //Robolectric.buildActivity(MainActivity.class).create().get();
        // Mochito initialise
        System.setProperty("dexmaker.dexcache", Robolectric.getShadowApplication().getCacheDir().getPath());
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_ToReadAssetsFileInAndroidTestContext() throws IOException {

        ShadowApplication application = Robolectric.getShadowApplication();
        Assert.assertNotNull(application);
        InputStream input = application.getAssets().open("b.xml");
        Assert.assertNotNull(input);
    }

}
