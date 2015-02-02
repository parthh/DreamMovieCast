package com.face3_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by admin on 15-01-14.
 */
public class AddActorcontroller extends Activity {
    private EditText charname;
    private EditText charimage;
    private EditText actorname;
    private EditText actorimage;
    private EditText movie;
    private Spinner genere;
    private TextView submit;
    public DatabaseHandler db;
    CustomToastAdapter _CustomToast;
    LinearLayout _back;
    Intent _dashboard;
    RelativeLayout _vote_layout;
    private String[] _GenderCombo = { "Select gender", "Biography", "Cartoon" , "Comic Book" };
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.actor_add);
        this.__initAllElement();



        // TODO: Set action to perform on click
        this.__bindEventToButtons();
    }

    public void __initAllElement() {

        db = new DatabaseHandler(this);
        this._dashboard = new Intent(getApplicationContext(),
                Actorlistcontroller.class);


        submit = (TextView)findViewById(R.id.submit_addactor);
        _back = (LinearLayout) findViewById(R.id.regist_layout_addact);
        _vote_layout =(RelativeLayout) findViewById(R.id.vote_layout);

        _CustomToast = new CustomToastAdapter(getApplicationContext(), "");

        this.charname = (EditText) findViewById(R.id.charcter_name);
        this.charimage = (EditText) findViewById(R.id.charimage_url);
        this.actorname = (EditText) findViewById(R.id.actor_name);
        this.movie = (EditText) findViewById(R.id.movie_title);
        this.genere = (Spinner) findViewById(R.id.genere);
        this.actorimage = (EditText) findViewById(R.id.actor_img);
        this.genere.setAdapter(new CustomSpinnerAdapter(
                getApplicationContext(), R.layout.actor_add,
                this._GenderCombo, getLayoutInflater()));





    }
    public void __bindEventToButtons() {
        _back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _dashboard.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(_dashboard);
                finish();
            }
        });
        _vote_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Actordetailcontroller actro = new Actordetailcontroller(charname.getText().toString(),actorname.getText().toString(),charimage.getText().toString(),
                        actorimage.getText().toString(),movie.getText().toString());
                Long l = db.addActor(actro);
                if(l!=null)
                {
                    _dashboard.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(_dashboard);
                    finish();
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Actordetailcontroller actro = new Actordetailcontroller(charname.getText().toString(),actorname.getText().toString(),charimage.getText().toString(),
                        actorimage.getText().toString(),movie.getText().toString());
                Long l = db.addActor(actro);
                if(l!=null)
                {
                    _dashboard.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(_dashboard);
                    finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        _dashboard.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(_dashboard);
        finish();
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }

}
