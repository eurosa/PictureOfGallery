package com.example.w3e_52.yo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by w3e-52 on 3/15/16.
 */
public class CardViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;

    private static ArrayList<Persons> dataSet;


    public CardViewAdapter(ArrayList<Persons> dataSet, Context context) {

        this.dataSet = dataSet;
        this.context=context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
// create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recylce_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        System.out.println("counter"+i+dataSet.get(i).getName());
        final Persons fp = dataSet.get(i);
        TextView textName=viewHolder.txtName;
        TextView fSize=viewHolder.fSize;
        fp.setName(dataSet.get(i).getName());
        textName.setText(dataSet.get(i).getName());
        fSize.setText(dataSet.get(i).getSize());



if(dataSet.get(i).getThumb()!=null) {

    System.out.println("SSSS" + dataSet.get(i).getThumb());
    File f = new File(dataSet.get(i).getThumb());
    Picasso.with(context).load(f).placeholder(R.drawable.icon).fit().centerCrop().into(viewHolder.imageShow);
}
        viewHolder.imageShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent intent =new Intent(mContext,ShowFolderImage.class);
                intent.putExtra("textImageName",fp.getName() );
                mContext.startActivity(intent);

//                Toast.makeText(v.getContext(), "Image is: ", Toast.LENGTH_SHORT).show();
            }

        });

    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

// inner class to hold a reference to each item of RecyclerView
class ViewHolder extends RecyclerView.ViewHolder {

    MainActivity activity;
    public TextView txtName;
    public TextView fSize;
    public ImageView imageShow;


    public ViewHolder(View itemLayoutView) {
        super(itemLayoutView);

//        this.imageList = (ImageView) itemLayoutView.findViewById(R.id.image_list);
        this.txtName=(TextView)itemLayoutView.findViewById(R.id.textName);
        this.imageShow=(ImageView)itemLayoutView.findViewById(R.id.image_list);
        this.fSize=(TextView) itemLayoutView.findViewById(R.id.fSize);

//
        imageShow = (ImageView) itemLayoutView.findViewById(R.id.image_list);



//       imageShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Context mContext = v.getContext();
//                Intent intent =new Intent(mContext,ShowFolderImage.class);
//                intent.putExtra("textImageName", String.valueOf(mContext));
//                mContext.startActivity(intent);
//
//                Toast.makeText(v.getContext(), "Image is: ", Toast.LENGTH_SHORT).show();
//            }
//
//        });


    }

}


