package com.face3_test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 15-01-14.
 */
public class Viewactordetailcontroller  extends Activity{

    public TextView _chname;
    public TextView _acname;
    public ImageView _chimg;
    public ImageView _acimg,_voteico;
    public TextView _id;
    RelativeLayout _vote_layout;
    public DatabaseHandler db;
    public int id;
    public int newsno =0;
    LinearLayout _back;
    public TextView _votecount;
    private Intent _Dashboard;
    private Bundle bundle = new Bundle();
    private ImageLoadingListener animateFirstListener = null;
    CustomToastAdapter _CustomToast;
    public ArrayList<String> productpic;
    public ArrayList<String> productpic1;
    DisplayImageOptions options = null;
   public int vote=0;
    String _pic[];
    String _pic1[];
    public  Actordetailcontroller actor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.actor_detail_vote);
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.default_image)
                .showImageForEmptyUri(R.drawable.default_image)
                .showImageOnFail(R.drawable.default_image)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new RoundedBitmapDisplayer(160))
                .build();
        animateFirstListener = new AnimateFirstDisplayListener();
        this._initAllElement();

        this.__bindEventToButtons();

    }
    private void _initAllElement() {

        db = new DatabaseHandler(this);
        this._Dashboard = new Intent(getApplicationContext(),
                Actorlistcontroller.class);

        productpic = new ArrayList<String>();
        productpic1 = new ArrayList<String>();


        this._chname = (TextView) findViewById(R.id.character_detail_text);
        this._acname = (TextView) findViewById(R.id.actor_detail_text);
        this._chimg = (ImageView) findViewById(R.id.charimg_detail_vote);
        this._acimg = (ImageView) findViewById(R.id.actorimg_detail_vote);
        this._votecount = (TextView) findViewById(R.id.number_vote);
        this._vote_layout = (RelativeLayout) findViewById(R.id.shopingdetail_layout_vote);
        this._voteico = (ImageView)findViewById(R.id.detailico_vote);
        this._back = (LinearLayout) findViewById(R.id.regist_layout_1);
        this._id = (TextView) findViewById(R.id.productid);
        _CustomToast = new CustomToastAdapter(getApplicationContext(), "");

        bundle = getIntent().getExtras();
         id = Integer.parseInt(bundle.getString("productid"));
        actor = db.getActor(id);

       this._chname.setText(actor.getcharname());
        this._acname.setText(actor.getactorname());
        this._votecount.setText(actor.getlike()+"");

        if(actor.getcharimgurl() != null)
        {
            productpic.add(actor.getcharimgurl());
            _pic =productpic.toArray(new String[productpic.size()]);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
            Log.i("ZONRgfdhgfhgfdghfdg", "Hfdhfdh");
            Log.i("ZONRgfdhg",actor.getcharimgurl());
            imageLoader.displayImage(_pic[newsno].toString(), _chimg, options, animateFirstListener);
        }
       else
        {
            _chimg.setImageResource(R.drawable.default_image);
        }
        if(actor.getactorimgurl() != null)
        {
            productpic1.add(actor.getactorimgurl());
            _pic1 =productpic1.toArray(new String[productpic1.size()]);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
            Log.i("ZONRgfdhgfhgfdghfdg", "Hfdhfdh");
            Log.i("ZONRgfdhg",actor.getcharimgurl());
            imageLoader.displayImage(_pic1[newsno].toString(), _acimg, options, animateFirstListener);
        }
        else
        {
            _acimg.setImageResource(R.drawable.default_image);
        }

    }

    private void __bindEventToButtons() {

        _back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                _Dashboard.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(_Dashboard);
                finish();


            }
        });
        _vote_layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                vote = actor.getlike();
                Log.d("vote",String.valueOf(vote));
                int newvote = vote+1;
                _votecount.setText(String.valueOf(newvote));
                int val = db.updatevote(newvote,id);
                Log.i("voteupdate", String.valueOf(val));
                Log.i("voteupdate", String.valueOf(newvote));

            }
        });
        _voteico.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                vote = actor.getlike();
                Log.d("vote",String.valueOf(vote));
                int newvote = vote+1;
                _votecount.setText(String.valueOf(newvote));
                int val = db.updatevote(newvote,id);
                Log.i("voteupdate", String.valueOf(val));
                Log.i("voteupdate", String.valueOf(newvote));

            }
        });
    }


    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {

        static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (loadedImage != null) {
                ImageView imageView = (ImageView) view;
                boolean firstDisplay = !displayedImages.contains(imageUri);
                if (firstDisplay) {
                    FadeInBitmapDisplayer.animate(imageView, 500);
                    displayedImages.add(imageUri);
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        _Dashboard.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(_Dashboard);
        finish();
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }

}
