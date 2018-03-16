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

package com.example.android.lifecycles.step1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Chronometer;

import com.example.android.codelabs.lifecycle.R;

/**
 * 在 Activity 中添加
 * android:configChanges="orientation|keyboardHidden"
 * 可以防止 Activity 重构，但是无法避免 Chronometer 重构
 * onCreate 不会调用
 * onConfigurationChanged 会调用
 */
public class ChronoActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("JING", "onCreate");
        Chronometer chronometer = findViewById(R.id.chronometer);
        chronometer.start();
    }
}
