package cn.link.linklive.network;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpManager {
    private static OKHttpManager mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;

    private OKHttpManager()
    {
        mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        mDelivery = new Handler(Looper.getMainLooper());
    }
    public static OKHttpManager getInstance()
    {
        if (mInstance == null)
        {
            synchronized (OKHttpManager.class)
            {
                if (mInstance == null)
                {
                    mInstance = new OKHttpManager();
                }
            }
        }
        return mInstance;
    }
    /**
     * 同步的Get请求
     *
     * @param url
     * @return Response
     */

    private void _getAsyn(String url, final ResultCallback callback)
    {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        deliveryResult(callback, request);
    }

    private void _getAsyn(String url, RequestBody form, final ResultCallback callback)
    {
        final Request request = new Request.Builder()
                .post(form)
                .url(url)
                .build();
        deliveryResult(callback, request);
    }

    public static void getAsyn(String url, ResultCallback callback)
    {
        getInstance()._getAsyn(url, callback);
    }

    public static void getAsyn(String url, RequestBody form, ResultCallback callback)
    {
        getInstance()._getAsyn(url,form, callback);
    }


    private void deliveryResult(final ResultCallback callback, Request request)
    {
        mOkHttpClient.newCall(request).enqueue(new Callback()
        {

            @Override
            public void onFailure(Call call, IOException e) {
                sendFailedStringCallback(call.request(), e, callback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                sendSuccessResultCallback(response, callback);
            }
        });
    }



    private void sendFailedStringCallback(final Request request, final Exception e, final ResultCallback callback)
    {
        mDelivery.post(new Runnable()
        {
            @Override
            public void run()
            {
                if (callback != null)
                    callback.onError(request, e);
            }
        });
    }

    private void sendSuccessResultCallback(final Response response, final ResultCallback callback)
    {
        mDelivery.post(new Runnable()
    {
        @Override
        public void run()
        {
            if (callback != null)
            {
                callback.onResponse(response);
            }
        }
    });
    }

    public static abstract class ResultCallback{
        public abstract void onError(Request request,Exception e);
        public abstract void onResponse(Response response);
    }
}
