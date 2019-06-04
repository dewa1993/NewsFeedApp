/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.upadhyay.newsfeedapplication.network.helper;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import retrofit2.Response;

public class ApiResponse<R> {

    private static final String TAG = ApiResponse.class.getSimpleName();

    public final int code;
    @Nullable
    public final R body;
    @Nullable
    public final String errorMessage;

    public ApiResponse(final Throwable error) {
        code = 500;
        body = null;
        errorMessage = error.getMessage();
    }

    public ApiResponse(final Response<R> response) {
        code = response.code();
        if (isSuccess()) {
            body = response.body();
            errorMessage = null;
        } else {
            String message = null;
            try {
                message = response.errorBody().string();
            } catch (IOException ex) {
                Log.d(TAG, "Error Captured");
            }

            if (TextUtils.isEmpty(message)) {
                message = response.message();
            }

            errorMessage = message;
            body = null;
        }
    }

    public boolean isSuccess() {
        return code >= 200 && code < 300;
    }
}
