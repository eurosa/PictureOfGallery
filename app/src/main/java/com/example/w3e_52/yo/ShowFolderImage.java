package com.example.w3e_52.yo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * Created by w3e-52 on 4/5/16.
 */
public class ShowFolderImage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ModelFolderImage> dataset;
    private RecyclerView.Adapter mAdapter;
    TextView textNameImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        textNameImage = (TextView) findViewById(R.id.textName);
        Intent intent = getIntent();
        String sabuj = intent.getStringExtra("textImageName");

        controlImageView(getApplicationContext(), sabuj);
//        addListenerOnClickBtn();

    }

    public void controlImageView(Context context, String name) {

        File[] listFile;

        File[] listFile2;
        Toast.makeText(this, "Folder:  " + name, Toast.LENGTH_LONG).show();
        //  cardView = (CardView) findViewById(R.id.cardList);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        dataset = new ArrayList<ModelFolderImage>();


        File file = new File(android.os.Environment.getExternalStorageDirectory(), "DCIM");

        listFile = file.listFiles();

        int count = 0;
        for (int i = 0; i < listFile.length; i++) {
            if (!listFile[i].isHidden()) {
                count += 1;
            }


        }



        String[] thumbImage = new String[count];


        if (file.isDirectory()) {
            listFile = file.listFiles();

            int k = 0;

            for (int i = 0; i < listFile.length; i++) {

                if (!listFile[i].isHidden()) {


                    File file2 = new File(listFile[i].getAbsolutePath());
                    listFile2 = file2.listFiles();
//

                    if (file2.isDirectory()) {

                        listFile2 = file2.listFiles();
                        if (name.equals(listFile[i].getName())) {

                            for (int l = 0; l < listFile2.length; l++) {
                                File file3=new File(listFile2[l].getAbsolutePath());

                                File[] listFile3;

//                                System.out.println("getradhason" + listFile2[l].getAbsolutePath());

                                if(file3.isDirectory()){
                                    listFile3= file3.listFiles();
                                   String counter= String.valueOf(counterMethod(listFile3));
                                    String[] url=new String[Integer.parseInt(counter)];
//                                    String[] url=new String[counterMethod(listFile3)];
                                    Toast.makeText(this,"hello my name "+counter+" "+"folder" ,Toast.LENGTH_LONG).show();



                                    System.out.println("lengthoffolder"+counterMethod(listFile3));

                                    url[l]=getIsTrueImageFolder(new File(listFile2[l].getAbsolutePath()));
                                    System.out.println("world"+ url[l]);
                                    dataset.add(new ModelFolderImage(url[l], file3.getName(),counter));
                                }else {


                                    dataset.add(new ModelFolderImage(listFile2[l].getAbsolutePath(), file3.getName(),null));
                                }
                            }

                        }
                    }
                    k++;
                }

            }
        }


        // ListView
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

        //Grid View
        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,1,false));


        // create an Object for Adapter
        mAdapter = new DetailsAdapter(dataset, context);

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);

    }


    public int counterMethod(File[] file) {
        int count = 0;
        for (int i = 0; i < file.length; i++) {
            if (!file[i].isHidden()) {
                count += 1;
            }


        }
        return count;
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
}

