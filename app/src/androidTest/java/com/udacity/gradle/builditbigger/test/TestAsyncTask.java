package com.udacity.gradle.builditbigger.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.activity.TestActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

/**
 * This test is created for testing asynchronous login.
 *
 */
@RunWith(AndroidJUnit4.class)
public class TestAsyncTask {

    private static final String TAG = TestAsyncTask.class.getSimpleName();

    @Rule
    public ActivityTestRule<TestActivity> mActivityRule = new ActivityTestRule<>(TestActivity.class);


    @Test
    public void testLoginViaService() throws Exception {
        /** 1.*/
        /** 2.*/
        Log.v("Memo" , "testLoginViaService");
        final Object syncObject = new Object();

        TestActivity loginActivity = mActivityRule.getActivity();
        Log.v("Memo" , "TestActivity");
        loginActivity.Callback(new TestActivity.TestCallback() {
            @Override
            public void onHandleResponseCalled(String loginResponse) {
                Log.v(TAG, "onHandleResponseCalled in thread " + Thread.currentThread().getId());
                Log.v("Memo" , "onHandleResponseCalled-test");
                assertNotNull(loginResponse);
                synchronized (syncObject){
                    Log.v("Memo" , "synchronized.noti");
                    syncObject.notify();
                }
            }
        });

        /** 3.*/
        onView(withId(R.id.joke_button)).perform(click());
        /** 4.
         * Here is a synchronization on local variable but it's ok.
         */
    }
}