package fatec.alunoandroid.gps_01;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtLat, txtLon;
    Double lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLat = findViewById(R.id.txtLat);
        txtLon = findViewById(R.id.txtLon);
    }

    public void configurarServico(){
        try{
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            LocationListener locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    atualizaLocalizacao(location);

                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            };

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        }
        catch (SecurityException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }


    public void atualizaLocalizacao (Location localizacao){
        lat = localizacao.getLatitude();
        lon = localizacao.getLongitude();

        txtLat.setText("Latitude" + lat.toString());
        txtLon.setText("Longitude" + lon.toString());

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permission[], int[] grantResult){

        switch (requestCode){
            case 1:{
                if(grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED)
                    configurarServico();
                else
                    Toast.makeText(this, "Nao funcionou ...", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void ondeEstou(View v){
        if((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                && (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED))
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            else
                configurarServico();

        }
}

