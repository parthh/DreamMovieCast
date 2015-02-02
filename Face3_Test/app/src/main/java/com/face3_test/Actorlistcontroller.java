package com.face3_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-01-14.
 */
public class Actorlistcontroller extends Activity {

    private ListView productlist;
    private TextView noactor;
    private Intent _ViewDetail, _AddActor;
    private FrameLayout addact;
    private DatabaseHandler db;
    private ImageView v;
    AlertDialogManager _Alert = new AlertDialogManager();
    private Map<ArrayList<String>, ArrayList<String>> _actordetail = new HashMap();
    ArrayList<String> _charname = new ArrayList<String>();
    ArrayList<String> _charimgurl = new ArrayList<String>();
    ArrayList<String> _actorname = new ArrayList<String>();
    ArrayList<String> _actorimgurl = new ArrayList<String>();
    ArrayList<Integer> _vote = new ArrayList<Integer>();
    ArrayList<Integer> _actorid = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.actor_list_view);



      this._initAllElement();

        this.__bindEventToButtons();


    }

    private void _initAllElement() {

        // TODO: Initialize Navigation Intent
        Log.d("sg","1");
       //Toast.makeText(getApplicationContext(),"eloo",Toast.LENGTH_LONG).show();
        db = new DatabaseHandler(this);
        productlist = (ListView) findViewById(R.id.list_actor);
        this._ViewDetail = new Intent(getApplicationContext(),
                Viewactordetailcontroller.class);
        this._AddActor = new Intent(getApplicationContext(),
                AddActorcontroller.class);
        addact = (FrameLayout) findViewById(R.id.as_layout1);

        v = (ImageView) findViewById(R.id.register_image_addactor);

        List<Actordetailcontroller> actor = db.getAllActors();
        Log.d("sg","2");
      //  Toast.makeText(getApplicationContext(),"eloo",Toast.LENGTH_LONG).show();
        if(actor != null) {

            Log.d("sg","3");
            for (Actordetailcontroller cn : actor) {

                _charname.add(cn.getcharname());
                _charimgurl.add(cn.getcharimgurl());
                _actorname.add(cn.getactorname());
                _actorimgurl.add(cn.getactorimgurl());
                _vote.add(cn.getlike());
                _actorid.add(cn.getID());


                String log = "Id: " + cn.getcharname();
                // Writing Contacts to log
                Log.d("Name: ", log);
            }


            String charname[] = _charname
                    .toArray(new String[_charname.size()]);
            String charimgurl[] = _charimgurl
                    .toArray(new String[_charimgurl.size()]);
            String actorname[] = _actorname
                    .toArray(new String[_actorname.size()]);
            String actorimgurl[] = _actorimgurl.toArray(new String[_actorimgurl
                    .size()]);
            Integer vote[] = _vote
                    .toArray(new Integer[_vote.size()]);
            Integer actorid[] = _actorid
                    .toArray(new Integer[_actorid.size()]);

            productlist.setAdapter(new actor_view_list(this,
                    charname, charimgurl, actorname, actorimgurl,
                    vote, actorid));
        }
        else
        {
            Log.d("sg","4");
            Toast.makeText(getApplicationContext(),"eloo",Toast.LENGTH_LONG).show();
            _Alert.showAlertDialog(
                    Actorlistcontroller.this,
                    getString(R.string.no_character_title),
                    getString(R.string.no_character),
                    false);
        }

    }

    public void __bindEventToButtons() {

        Log.d("sg","5");


        addact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("sg","6");
                startActivity(_AddActor);
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("sg","7");
                startActivity(_AddActor);
            }
        });


    }
}