package com.face3_test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 15-01-14.
 */
public class actor_view_list extends BaseAdapter {
    public RelativeLayout shopingdetail_layout;
    public TextView tv;
    private ImageLoadingListener animateFirstListener = null;
    public String cname[];
    public String cimg[];
    public String aname[];
    public String aimg[];
    public Integer vote[];
    public Integer id[];
    public static Context _Context;
    private CustomToastAdapter _CustomToast;
    DisplayImageOptions options = null;
    public Bundle bundle = new Bundle();


    public actor_view_list(Context c, String[] _charname,
                                 String[] _charimg, String[] _actorname, String[] _actorimg,
                                 Integer[] _vote,Integer[] id) {


        _Context = c;

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



        this.cname = _charname;
        this.cimg = _charimg;
        this.aname = _actorname;
        this.aimg = _actorimg;
        this.vote = _vote;
        this.id = id;
        this._CustomToast = new CustomToastAdapter(_Context, "");

        Log.i("nggame5", Arrays.toString(cname));
        Log.i("nggame6", Arrays.toString(cimg));
        Log.i("nggame7", Arrays.toString(vote));
        Log.i("nggame8", Arrays.toString(aimg));



    }

    @Override
    public int getCount() {
        Log.i("2", String.valueOf(cname.length));
        return cname.length;
    }

    @Override
    public Object getItem(int position) {
        Log.i("3", "l");
        return cname[position];
    }

    @Override
    public long getItemId(int position) {
        Log.i("4", "l");
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        Log.i("5", String.valueOf(position));
        View v = convertView;
        final ViewHolder holder;

        if (v == null) {

            Log.i("6", "l");
            LayoutInflater li = (LayoutInflater) _Context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = li.inflate(R.layout.actor_detail_list, null);
            holder = new ViewHolder();
            holder._chname = (TextView) v.findViewById(R.id.character);
            holder._acname = (TextView) v.findViewById(R.id.actor);
            holder._chimg = (ImageView) v.findViewById(R.id.register_image);
            holder._acimg = (ImageView) v.findViewById(R.id.register_image1);
            holder._id = (TextView) v.findViewById(R.id.productid);
            v.setTag(holder);



        }
        else {
            holder = (ViewHolder) v.getTag();
        }

        String p = cname[position];


        {
            if (p != null) {
                Log.i("7", "l");




                Log.i("8", "l");

                holder._chname.setText(cname[position]);
                holder._acname.setText(aname[position]);
                holder._id.setText(String.valueOf(id[position]));




			/*String ZONE = QBQueries.SERVER_PRODUCT_IMAGE_ZONE + pid[position]
					+ "/" + pimg[position].toString();
			URL = String.format("http://%s", ZONE);*/
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.init(ImageLoaderConfiguration.createDefault(_Context));
                Log.i("ZONRgfdhgfhgfdghfdg", "Hfdhfdh");
                imageLoader.displayImage(cimg[position], holder._chimg, options, animateFirstListener);
                imageLoader.init(ImageLoaderConfiguration.createDefault(_Context));
                Log.i("ZONRgfdhgfhgfdghfdg", "Hfdhfdh");
                imageLoader.displayImage(aimg[position], holder._acimg, options, animateFirstListener);
                //Log.i("ZONR", URL);



                //Bitmap bm = decodeUri(URL);
                //Bitmap result1 = Bitmap.createScaledBitmap(bm, 115, 115, true);
                //_Proimg.setImageBitmap(result1);

                //spinner.setVisibility(View.GONE);

                Log.i("9", "l");

                Log.i("parebnt", String.valueOf(_Context));

                shopingdetail_layout = (RelativeLayout) v
                        .findViewById(R.id.shopingdetail1_detail);
                tv = (TextView)v.findViewById(R.id.viewdetail_text);


                shopingdetail_layout.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        _viewdetail(holder._id.getText().toString());
                    }

                });


                tv.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        _viewdetail(holder._id.getText().toString());
                    }

                });


                Log.i("10", String.valueOf(v));

            }
            else
            {
                Toast.makeText(_Context, "No Internet Connection", Toast.LENGTH_LONG).show();
            }

            Log.i("12", String.valueOf(position));

        }


        return v;
    }



    private class ViewHolder {
        public TextView _chname;
        public TextView _acname;
        public ImageView _chimg;
        public ImageView _acimg;
        public TextView _id;

    }

    public void _viewdetail(String id) {
        // TODO Auto-generated method stub
        String productid = id;
        bundle.putString("productid", productid);
        Intent intent = new Intent(_Context, Viewactordetailcontroller.class);
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _Context.startActivity(intent);

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
}
