/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycles.step2;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Chronometer;

import com.example.android.codelabs.lifecycle.R;

public class ChronoActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("JING", "onCreate");
        // The ViewModelStore provides a new ViewModel or one previously created.
        ChronometerViewModel chronometerViewModel
                = ViewModelProviders.of(this).get(ChronometerViewModel.class);

        // Get the chronometer reference
        Chronometer chronometer = findViewById(R.id.chronometer);

        if (chronometerViewModel.getStartTime() == null) {
            // If the start date is not defined, it's a new ViewModel so set it.
            /**
             * System.currentTimeMillis()获取的是系统时间，是距离1970年1月1日开始计算的一个值；
             * android.os.SystemClock.elapsedRealtime()获取从设备boot后经历的时间值。
             */
            long startTime = SystemClock.elapsedRealtime();
            chronometerViewModel.setStartTime(startTime);
            chronometer.setBase(startTime);
        } else {
            // Otherwise the ViewModel has been retained, set the chronometer's base to the original
            // starting time.
            chronometer.setBase(chronometerViewModel.getStartTime());
        }

        chronometer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("JING", "onDestroy");
    }
}
