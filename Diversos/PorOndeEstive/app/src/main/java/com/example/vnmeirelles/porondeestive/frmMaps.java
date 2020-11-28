package com.example.vnmeirelles.porondeestive;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.vnmeirelles.porondeestive.DAO.DAOLocais;
import com.example.vnmeirelles.porondeestive.Entidade.Configuracao;
import com.example.vnmeirelles.porondeestive.Entidade.Locais;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class frmMaps extends SupportMapFragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener, LocationListener{

    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final String TAG = "frmMaps";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync((OnMapReadyCallback) this);

   }

    @Override
    public void onResume() {
        super.onResume();

        //Escolhe o provider padrão GPS
        try {
            locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000,100, this);
        }catch (SecurityException ex){
            Log.e(TAG, "Erro", ex);
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationManager.removeUpdates(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setOnMapClickListener(this);
        //Busca o melhor Provider
        try {
           // locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
           // Criteria criteria = new Criteria();
           // String provider = locationManager.getBestProvider(criteria, true);
           // Toast.makeText(getContext(), "Provider: " +provider, Toast.LENGTH_LONG).show();
            mMap.setMyLocationEnabled(true);
        }catch (SecurityException ex){
            Log.e(TAG, "Erro", ex);
        }
        /*
        // Seta uma Posição Fixa
        LatLng home = new LatLng(-20.2115923, -47.76454134);
        MarkerOptions marker = new MarkerOptions();
        marker.position(home);
        marker.title("Home");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
        */
    }

    private String getCityByLocation(Location location, boolean click) {
        //obtendo coordenadas
        double latPoint = location.getLatitude();
        double lngPoint = location.getLongitude();

        //Classe que fornece a localização da cidade
        Geocoder geocoder = new Geocoder(this.getContext());
        List myLocation = null;

        try {
            //Obtendo os dados do endereço
            myLocation = geocoder.getFromLocation(latPoint, lngPoint, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ( myLocation != null && myLocation.size() > 0) {
            Address a = (Address) myLocation.get(0);
            //Pronto! Vocêm tem o nome da cidade!
            String cidade = a.getLocality();
            String logradouro = a.getAddressLine(0);
            //Seu código continua aqui...
            if (click) {
                Toast.makeText(getContext(), cidade + logradouro, Toast.LENGTH_SHORT).show();
            }else {
                return "Cidade: " + cidade + " End: " + logradouro;
            }
        } else {
            Log.d("geolocation", "endereço não localizado");
        }
        return "";
    }

    public void SalvarLocal(Location location){

        Locais locais = new Locais();
        locais.setLatitude(location.getLatitude());
        locais.setLongitude(location.getLatitude());

        DAOLocais daoLocais = new DAOLocais(getContext());

        String resultado;

        resultado = daoLocais.InsereLocais(locais, getCityByLocation(location, false));
        //Toast.makeText(getContext(), resultado,Toast.LENGTH_LONG).show();

    }

    public void DeleteAll(){

        DAOLocais daoLocais = new DAOLocais(getContext());

        daoLocais.DeletarTodoRegistro();
        Toast.makeText(getContext(), "Todo Histórico Foi Deletado",Toast.LENGTH_LONG).show();

    }


    @Override
    public void onMapClick(LatLng latLng) {
        Location loc = new Location(LocationManager.GPS_PROVIDER);

        loc.setLatitude(latLng.latitude);
        loc.setLongitude(latLng.longitude);

        getCityByLocation(loc,true);

    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng newLocation = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions marker = new MarkerOptions();
        marker.position(newLocation);
        marker.title("Nova Localização");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));

        SalvarLocal(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
       // Toast.makeText(getContext(), "O Status do Provider foi alterado",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider) {
       // Toast.makeText(getContext(), "Provider Habilitado",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
       // Toast.makeText(getContext(), "Provider Desabilitado",Toast.LENGTH_SHORT).show();
    }

}
