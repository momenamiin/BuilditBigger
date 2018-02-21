import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;


/**
 * Created by momenamiin on 2/21/18.
 */

/*
    https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
 */


public class AsyncTaskTest extends AndroidTestCase {

    public void asynctaskTest(){
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(getContext());
        String result ;
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
        assertNotNull(result);
    }
}
