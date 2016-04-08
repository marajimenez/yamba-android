package com.example.mara.yamba.network;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClientException;

public class PostTask extends AsyncTask<String, Void, String> {

    //region CONSTANTS
    private Context context;
    //endregion

    //region CONSTRUCTORS
    public PostTask(Context context){
        this.context = context;
    }
    //endregion

    //region OVERRIDE METHODS
    @Override
    protected String doInBackground(String... params) {
        YambaClient yambaCloud = new YambaClient("student", "password");
        try {
            yambaCloud.postStatus(params[0]);
            return "Successfully posted";
        } catch (YambaClientException e){
            e.printStackTrace();
            return "Failed to post to yamba service";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        Toast.makeText(this.context, result, Toast.LENGTH_LONG).show();
    }
    //endregion
}
