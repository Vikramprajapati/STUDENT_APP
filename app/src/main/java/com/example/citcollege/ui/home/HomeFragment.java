package com.example.citcollege.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citcollege.R;
import com.smarteist.autoimageslider.SliderPager;


public class HomeFragment extends Fragment {

    ImageView instagram,facebook,web;
    TextView email,location,number,number1;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        instagram=view.findViewById(R.id.instagram);
        facebook=view.findViewById(R.id.facebook);
        web=view.findViewById(R.id.website);
        email=view.findViewById(R.id.email);
        location=view.findViewById(R.id.location);
        number1=view.findViewById(R.id.number1);
        number=view.findViewById(R.id.number);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress="info@citabu.ac.in";

                Intent intent =new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+emailAddress));
                startActivity(intent);



            }
        });


        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/info_cit?igsh=MXVodTZ0bDdpeTBqNA==");
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://citabu.ac.in/");
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.facebook.com/citabuinfo?mibextid=ZbWKwL");
            }
        });


        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               double latitude=37.7749;
               double longitude=-122.4194;
               String label="Chartered Institute of Technology Village Danvav, Mt. Road, Abu Road Dist. Sirohi, Rajasthan - 307510.";


               Uri gmmIntentUri=Uri.parse("geo:"+latitude+","+longitude+"?q="+Uri.encode(label));

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);


                mapIntent.setPackage("com.google.android.apps.maps");

              startActivity(mapIntent);


            }
        });

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Phone number to dial
                String phoneNumber = "9829804013";

                // Create an Intent with ACTION_DIAL and the phone number URI
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
startActivity(intent);
            }
        });
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Phone number to dial
                String phoneNumber = "8769788575";

                // Create an Intent with ACTION_DIAL and the phone number URI
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });


        return view;
    }


    void gotoUrl(String s){
        try {
            Uri uri= Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }
        catch (Exception e){
            Toast.makeText(getActivity().getApplicationContext(), "No website Linked",Toast.LENGTH_SHORT).show();
        }

    }
}