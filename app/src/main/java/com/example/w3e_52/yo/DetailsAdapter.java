package com.example.w3e_52.yo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by w3e-52 on 4/5/16.
 */
public class DetailsAdapter extends RecyclerView.Adapter<ViewHolder1> {

    Context context;

    private static ArrayList<ModelFolderImage> dataSet;


    public DetailsAdapter(ArrayList<ModelFolderImage> dataSet, Context context) {

        this.dataSet = dataSet;
        this.context=context;
    }


    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup viewGroup, int i) {
// create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recylce_item, null);

        // create ViewHolder

        ViewHolder1 viewHolder = new ViewHolder1(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder1 viewHolder, int i) {

 ModelFolderImage folderImage=dataSet.get(i);
        TextView textName=viewHolder.txtName;
//        TextView size=viewHolder.;


        textName.setText(dataSet.get(i).getFname());
//        size.setText(dataSet.get(i).getSize());




        if(dataSet.get(i).getImageName()!=null) {


            File f = new File(dataSet.get(i).getImageName());
            Picasso.with(context).load(f).placeholder(R.drawable.icon).fit().centerCrop().into(viewHolder.imageShow);
        }
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

// inner class to hold a reference to each item of RecyclerView
class ViewHolder1 extends RecyclerView.ViewHolder {


    public TextView txtName;
    private TextView size;

    public ImageView imageShow;


    public ViewHolder1(View itemLayoutView) {
        super(itemLayoutView);

//        this.imageList = (ImageView) itemLayoutView.findViewById(R.id.image_list);
        this.txtName=(TextView)itemLayoutView.findViewById(R.id.textName);
        this.size=(TextView)itemLayoutView.findViewById(R.id.fSize);
        this.imageShow=(ImageView)itemLayoutView.findViewById(R.id.image_list);


//
        imageShow = (ImageView) itemLayoutView.findViewById(R.id.image_list);

//
//        imageShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//                Intent intent = new Intent(v.getContext(), ShowFolderImage.class);
//                v.getContext().startActivity(intent);
//                Toast.makeText(v.getContext(), "Image is: ", Toast.LENGTH_SHORT).show();
//            }
//
//        });


    }

}


