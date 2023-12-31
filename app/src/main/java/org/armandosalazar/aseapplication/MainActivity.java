package org.armandosalazar.aseapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferencesKeys;

import org.armandosalazar.aseapplication.databinding.ActivityMainBinding;
import org.armandosalazar.aseapplication.ui.home.HomeFragment;
import org.armandosalazar.aseapplication.ui.map.MapFragment;
import org.armandosalazar.aseapplication.ui.notification.NotificationFragment;
import org.armandosalazar.aseapplication.ui.people.PeopleFragment;
import org.armandosalazar.aseapplication.ui.profile.ProfileFragment;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, HomeFragment.newInstance()).commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, HomeFragment.newInstance()).commit();
                return true;
            }
            if (item.getItemId() == R.id.navigation_location) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, MapFragment.newInstance()).commit();
                return true;
            }
            if (item.getItemId() == R.id.navigation_people) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, PeopleFragment.newInstance()).commit();
                return true;
            }
            if (item.getItemId() == R.id.navigation_notifications) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, NotificationFragment.newInstance()).commit();
                return true;
            }
            if (item.getItemId() == R.id.navigation_profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ProfileFragment.newInstance()).commit();
                return true;
            }
            return false;
        });

        setContentView(binding.getRoot());
    }
}