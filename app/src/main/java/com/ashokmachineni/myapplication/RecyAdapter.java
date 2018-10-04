package com.ashokmachineni.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.MiViewHolder> {
    Context context;
    ArrayList<Jobs> jobs;

    public RecyAdapter(Context context, ArrayList<Jobs> jobs) {
        this.context = context;
        this.jobs = jobs;
    }

    View view;
    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.reclayout,parent,false);
        MiViewHolder miViewHolder =new MiViewHolder(view);
        return miViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MiViewHolder miViewHolder, int position) {
        final Jobs job = jobs.get(position);
        miViewHolder.texts.setText(job.getTitle());
        String imgUrl = job.getThumbnail();
        String vurl = job.getUrl();
        Glide.with(context)
                .load(imgUrl)
                .thumbnail(0.5f)
                .into(miViewHolder.images);
        miViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,VideoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView texts;
        LinearLayout linearLayout;
        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.imgscl);
            texts = itemView.findViewById(R.id.texname);
            linearLayout = itemView.findViewById(R.id.llview);
        }
    }
}
