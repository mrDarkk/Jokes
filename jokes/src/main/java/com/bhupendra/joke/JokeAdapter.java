package com.bhupendra.joke;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder>{

    private static final String TAG = "JokeAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mcount = new ArrayList<>();
    private Context mContext;

    public JokeAdapter(Context context, ArrayList<String> imageNames,ArrayList<String> count) {
        mImageNames = imageNames;
        mcount = count;

        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");


        holder.imageName.setText(mImageNames.get(position));
        holder.count.setText(mcount.get(position));


        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

                //Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("joke",mImageNames.get(position));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(mContext, "Copied", Toast.LENGTH_SHORT).show();


                // Intent intent = new Intent(mContext, jokemainActivity.class);

                //  intent.putExtra("image_name", mImageNames.get(position));
                //  mContext.startActivity(intent);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = mImageNames.get(position);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Joke");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                mContext.startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView imageName,count;
        ImageView copy, share;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            imageName = itemView.findViewById(R.id.image_name);
            copy = itemView.findViewById(R.id.jcopy);
            share = itemView.findViewById(R.id.jshare);
            count = itemView.findViewById(R.id.count);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}















