import com.sh1nj1.android.exercise.MainActivity;
import com.trumpia.android.test.MyRobolectricTestRunner;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.io.InputStream;

/**
 * Test case to read asset files in androidTest context.
 *
 * chk0ndanger
 */
@Config(manifest = "app/src/androidTest/AndroidManifest.xml")
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

        InputStream input = Robolectric.getShadowApplication().getAssets().open("b.xml");
        Assert.assertNotNull(input);
    }

}
