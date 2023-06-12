package com.example.compendium;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;


public class BasicInfoFragment extends Fragment {

    Button returnButton, nextImageButton;
    ImageView imageIV;
    final int MyVersion = Build.VERSION.SDK_INT;
    String[] requiredPermissions = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};

    int currentImageIndex = 0;

    String[] imagePathFiles = new String[]{
            "/storage/emulated/0/DCIM/image1.jpg",
            "/storage/emulated/0/DCIM/image2.jpg",
            "/storage/emulated/0/DCIM/image3.jpg",
            "/storage/emulated/0/DCIM/image4.jpg",
    };
    public BasicInfoFragment() {
        // Required empty public constructor
    }
    public static BasicInfoFragment newInstance(String param1, String param2) {
        BasicInfoFragment fragment = new BasicInfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_basic_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        returnButton = (Button) getView().findViewById(R.id.basicInfoReturnButton);
        nextImageButton = (Button) getView().findViewById(R.id.nextImageButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_basicInfoFragment_to_FirstFragment);
            }
        });

        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                ActivityCompat.requestPermissions(getActivity(),requiredPermissions, 1);
            } else {
                setMyImage(currentImageIndex);
            }
        }

        nextImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex = (currentImageIndex + 1) % imagePathFiles.length;
                setMyImage(currentImageIndex);
            }
        });

    }

    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setMyImage(currentImageIndex);
                } else {
                    Toast.makeText(getActivity(), "Please give your permission.", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    public void setMyImage(int currentIndex){
        if(currentIndex >= 0 && currentIndex < imagePathFiles.length){
            File imgFile = new File(imagePathFiles[currentIndex]);

            imageIV = (ImageView) getView().findViewById(R.id.galleryImageView);

            if(imgFile.exists()){
                Bitmap imgBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                imageIV.setImageBitmap(imgBitmap);
            }
            else {
                Toast.makeText(getContext(),"Plik nie istnieje!",Toast.LENGTH_LONG);
            }
        }
    }
}