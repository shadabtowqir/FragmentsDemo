package com.example.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener{


    DeptInformation deptInformation;
    InformationFragment informationFragment;
    ListFragment listFragment;
    public final static String INFORMATION="information";

    MyAsyncTask myAsyncTask;
    //declare counter
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize DeptInformation class
        deptInformation=new DeptInformation();
        //create fragment references
        informationFragment= (InformationFragment) getSupportFragmentManager().findFragmentById(R.id.infoFrag);
        listFragment= (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFrag);
        //initialize AsyncTask class
        myAsyncTask= new MyAsyncTask();

    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        //checking if asynctask is still runnning
        if(myAsyncTask!=null && myAsyncTask.getStatus()== AsyncTask.Status.RUNNING){
            //cancel the task before destroying activity
            myAsyncTask.cancel(true);
            myAsyncTask= null;
        }
        super.onDestroy();
    }

    @Override
    public void onButtonClicked(int infoID) {
        if(infoID!= 2){
            if(informationFragment!=null && informationFragment.isInLayout()){
            //informationfragment exists on screen, so we are in landscape mode
                informationFragment.setText(deptInformation.getInfo(infoID));
            }else{
                //for portrait mode
                Intent intent = new Intent(this, InformationActivity.class);
                intent.putExtra(INFORMATION, deptInformation.getInfo(infoID));
                startActivity(intent);
            }
        }else {
            //executing asynctask on button click
            //first checking if it is already running or not
            if(myAsyncTask.getStatus()!= AsyncTask.Status.RUNNING){
                myAsyncTask = new MyAsyncTask();
                //passing in 20 as the limit and executing the task
                myAsyncTask.execute(20);
            }
        }
    }

    private class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... params) {
            while(count < params[0]){
                try{
                    //checking if the asynctask has been cancelled, end loop if so
                    if(isCancelled()) break;

                    Thread.sleep(500);

                    count++;

                    //send count to onProgressUpdate to update UI
                    publishProgress(count);

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //setting count to 0 and setting textview to 0 after doInBackground finishes running
            count= 0;
            listFragment.counter.setText("0");

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            listFragment.counter.setText(values[0]+"");

        }
    }

}