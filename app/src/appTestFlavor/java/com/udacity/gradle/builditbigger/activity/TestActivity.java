package com.udacity.gradle.builditbigger.activity;

import android.util.Log;

import com.udacity.gradle.builditbigger.MainActivity;

public class TestActivity extends MainActivity {

    private TestCallback mCallback;

    public void Callback(TestCallback loginCallback){
        Log.v("Memo" , "Callback");

        mCallback = loginCallback;
    }

    public interface TestCallback {
        void onHandleResponseCalled(String loginResponse);
    }

    @Override
    public void handleResponse(String loginResponse) {
        Log.v("Memo" , "handleLoginResponse2");
        mCallback.onHandleResponseCalled(loginResponse);
    }
}
