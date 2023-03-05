package com.khuongviettai.mymusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.khuongviettai.mymusic.Fragments.HistoryFragment;
import com.khuongviettai.mymusic.Fragments.HomeFragment;
import com.khuongviettai.mymusic.Fragments.PlaylistFragment;
import com.khuongviettai.mymusic.Fragments.ProfileFragment;
import com.khuongviettai.mymusic.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

//        bottom tab
        binding.bottomAppItem.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_Home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.bottom_PlayList:
                    replaceFragment(new PlaylistFragment());
                    break;
                case R.id.bottom_History:
                    replaceFragment(new HistoryFragment());
                    break;
                case R.id.bottom_Profile:
                    replaceFragment(new ProfileFragment());
                    break;
                default:
                    new HomeFragment();
            }
            return true;
        });


//        end bottom tab


    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutMain, fragment);
        fragmentTransaction.commit();
    }
}