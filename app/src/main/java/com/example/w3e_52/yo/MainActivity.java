package com.example.w3e_52.yo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private RecyclerView recyclerView;

    private ArrayList<Persons> image;

    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


       initContrls(getApplicationContext());
//        addListenerOnClickBtn();

    }



    private void initContrls( Context context) {
        File[] listFile;
        Persons person = new Persons();


        //  cardView = (CardView) findViewById(R.id.cardList);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        image  = new ArrayList<Persons>();




        File file= new File(android.os.Environment.getExternalStorageDirectory(),"DCIM");
        listValidFiles(file);
        listFile = file.listFiles();

        int count=0;
        for (int i = 0; i < listFile.length; i++)
        {
            if(!listFile[i].isHidden()){
                count+=1;
            }


        }
        System.out.println("das"+count);
        String[] image_path =  new String[count];
        String[] names =  new String[count];

        String[] thumbImage =  new String[count];
        String[] folderSize=new String[count];
        if (file.isDirectory() )
        {
            listFile = file.listFiles();

            int k=0;
            String path=null;
            for (int i = 0; i < listFile.length; i++)
            {

                if(!listFile[i].isHidden()  ) {


                    names[k]=listFile[i].getName();
                    image_path[k]=listFile[i].getAbsolutePath();
                    thumbImage[k]=getIsTrueImageFolder(new File(listFile[i].getAbsolutePath()));
                    folderSize[k]=getFolderSize(new File(listFile[i].getAbsolutePath()));
                    image.add(new Persons(image_path[k],names[k],  thumbImage[k],folderSize[k]));

                    k++;
                }

            }
        }






        // ListView
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));

        //Grid View
        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,1,false));

        //StaggeredGridView
        // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        // create an Object for Adapter
        mAdapter = new CardViewAdapter(image,context);

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);


    }

    public String getIsTrueImageFolder(File dir)
    {
        String counteri=null;
        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {

                }
                else {
                    if (listFile[i].getName().endsWith(".png")|| listFile[i].getName().endsWith(".jpg")|| listFile[i].getName().endsWith(".jpeg")|| listFile[i].getName().endsWith(".gif"))
                    {
                        counteri=  listFile[i].getAbsolutePath();

                    }
                }            }
        }
        return counteri;
    }

    public String getFolderSize(File dir)
    {
        String counteri=null;
        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {

                }
                else {
                    if (listFile[i].getName().endsWith(".png")|| listFile[i].getName().endsWith(".jpg")|| listFile[i].getName().endsWith(".jpeg")|| listFile[i].getName().endsWith(".gif"))
                    {
                        counteri= String.valueOf(listFile.length);

                    }
                }            }
        }
        return counteri;
    }


    private File[] listValidFiles(File file) {
        return file.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String filename) {
                File file2 = new File(dir, filename);
                System.out.println("asdf"+filename.contains(".png"));
                return (filename.contains(".png") || filename.contains(".jpg") || file2
                        .isDirectory())
                        && !file2.isHidden()
                        && !filename.startsWith(".");

            }
        });
    }

    @Override
    public void onItemClick (AdapterView < ? > arg0, View arg1,int arg2, long arg3){
        // TODO Auto-generated method stub
        CheckedTextView ctv = (CheckedTextView) arg1;
        if (ctv.isChecked()) {
            Toast.makeText(MainActivity.this, "now it is unchecked", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "now it is checked", Toast.LENGTH_SHORT).show();
        }
    }






}