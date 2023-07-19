package com.example.carebuddy;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.carebuddy.databinding.ActivityMapBinding;

import java.util.Vector;

public class Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapBinding binding;

    MarkerOptions marker;
    LatLng centerLocation;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerLocation = new LatLng(3.0,101);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Tuanku Ja'afar Hospital")
                .position(new LatLng(2.7107670113603453, 101.94500789467278))
                .snippet("Jalan Rasah, Bukit Rasah, 70300 Seremban, Negeri Sembilan")
        );

        markerOptions.add(new MarkerOptions().title("Melaka Hospital")
                .position(new LatLng(2.2174599346253236, 102.26135645413358))
                .snippet("Jalan Mufti Haji Khalil, 75400 Melaka")
        );

        markerOptions.add(new MarkerOptions().title("Kuala Lumpur Hospital")
                .position(new LatLng(3.1717824738341047, 101.70260644959826))
                .snippet("Jalan Pahang, 50586 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur")
        );
        markerOptions.add(new MarkerOptions().title("Tengku Ampuan Afzan Hospital")
                .position(new LatLng(3.801152811357177, 103.32149333878924))
                .snippet("Jalan Tanah Putih, 25100 Kuantan, Pahang")
        );
        markerOptions.add(new MarkerOptions().title("Sultanah Aminah Hospital")
                .position(new LatLng(1.459306911132446, 103.74601864621862))
                .snippet("Jalan, Persiaran Abu Bakar Sultan, 80100 Johor Bahru, Johor")
        );
        markerOptions.add(new MarkerOptions().title("Sungai Buloh Hospital")
                .position(new LatLng(3.233057466675439, 101.58245730407458))
                .snippet("Jalan Hospital, 47000 Sungai Buloh, Selangor")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Sultanah Bahiyah")
                .position(new LatLng(6.150059333429332, 100.40656916993402))
                .snippet("Km 6, Jln Langgar, Bandar, 05460 Alor Setar, Kedah")
        );
        markerOptions.add(new MarkerOptions().title("Raja Permaisuri Bainun Hospital")
                .position(new LatLng(4.612526527326609, 101.09170069538547))
                .snippet("Hospital Raja Permaisuri Bainun, Jalan Raja Ashman Shah, 30450 Ipoh, Perak")
        );
        markerOptions.add(new MarkerOptions().title("Raja Perempuan Zainab II Hospital")
                .position(new LatLng(6.125204926500762, 102.24560413188345))
                .snippet("Bandar Kota Bharu, 15586 Kota Bharu, Kelantan")
        );
        markerOptions.add(new MarkerOptions().title("Tuanku Fauziah Hospital")
                .position(new LatLng(6.4412905166943695, 100.19132588095826))
                .snippet("3, Jalan Tun Abdul Razak, Pusat Bandar Kangar, 01000 Kangar, Perlis")
        );
        markerOptions.add(new MarkerOptions().title("Putrajaya Hospital")
                .position(new LatLng(2.9292671858275825, 101.67416339007401))
                .snippet("Jalan P9, Presint 7, 62250 Putrajaya, Wilayah Persekutuan Putrajaya")
        );
        markerOptions.add(new MarkerOptions().title("Sultanah Nur Zahirah Hospital")
                .position(new LatLng(5.327707865833766, 103.15160986648063))
                .snippet("84GX+RH Hospital Sultanah Nur Zahirah, 20400 Kuala Terengganu, Terengganu")
        );
        markerOptions.add(new MarkerOptions().title("Penang General Hospital")
                .position(new LatLng(5.417003329499932, 100.31129742262854))
                .snippet("Jalan Residensi, 10990 George Town, Pulau Pinang")
        );

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for (MarkerOptions mark : markerOptions) {
            mMap.addMarker(mark);
        }

        enableMyLocation();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLocation,8));
    }

    private void enableMyLocation(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if (mMap != null){
                mMap.setMyLocationEnabled(true);
            }
        }else {
            String perms [] = {"android.permission.ACCESS_FINE_LOCATION"};
            ActivityCompat.requestPermissions(this,perms,200);
        }
    }
}