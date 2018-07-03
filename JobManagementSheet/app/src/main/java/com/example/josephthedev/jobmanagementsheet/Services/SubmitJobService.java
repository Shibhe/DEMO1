package com.example.josephthedev.jobmanagementsheet.Services;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.josephthedev.jobmanagementsheet.Activity.Client.RatingActivity;
import com.example.josephthedev.jobmanagementsheet.Helpers.CustomHttpClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

public class SubmitJobService extends AsyncTask<String, String, String> {

    @SuppressLint("StaticFieldLeak")
    private Context context;
    private ProgressDialog progressDialog;
    String response = null;

    public SubmitJobService(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("\tPlease wait while loading...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Submitting Job");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        String urls = "https://uncreditable-window.000webhostapp.com/JSMA/requestJob.php";
        progressDialog = new ProgressDialog(context);

        ArrayList<NameValuePair> postParameters = new ArrayList<>();
        postParameters.add(new BasicNameValuePair("User_Identifier", strings[0] ));
        postParameters.add(new BasicNameValuePair("Location_Name", strings[1] ));
        postParameters.add(new BasicNameValuePair("Latitude", strings[2] ));
        postParameters.add(new BasicNameValuePair("Longitude", strings[3] ));
        postParameters.add(new BasicNameValuePair("Ref_ID", strings[4] ));
        postParameters.add(new BasicNameValuePair("Job_Type", strings[5] ));
        postParameters.add(new BasicNameValuePair("Description", strings[6] ));
        postParameters.add(new BasicNameValuePair("Required_Date", strings[7] ));
        postParameters.add(new BasicNameValuePair("PhoneNumber", strings[8] ));
        //postParameters.add(new BasicNameValuePair("Complexity", strings[8] ));
        String res = null;
        try {
            response = CustomHttpClient.executeHttpPost(urls, postParameters);
            res = response;
            res= res.replaceAll("\\s+","");
        }
        catch (Exception e) {
            //txt_Error.setText(e.toString());
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return res;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        progressDialog.dismiss();

        try {
            if(jsonObject.getString("success") == "1"){
                progressDialog.dismiss();
                Toast.makeText(context,  "Successfully Added", Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, RatingActivity.class);
                context.startActivity(i);
            }else{
                progressDialog.dismiss();
                Toast.makeText(context, "Something went wrong, Please try again later", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
