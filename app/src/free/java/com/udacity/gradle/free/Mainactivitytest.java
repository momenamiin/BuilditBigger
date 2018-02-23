package com.udacity.gradle.free;


import android.util.Log;

import com.udacity.gradle.builditbigger.MainActivity;

/**
 * Created by momenamiin on 2/22/18.
 */

public class Mainactivitytest extends MainActivity {


    private TestCallback mCallback;

    public void setCallback(TestCallback Callback){
        Log.v("Memo" , "setCallback");
        mCallback = Callback;
    }

    public interface TestCallback{
        void onHandleResponseCalled(String Response);
    }


}
