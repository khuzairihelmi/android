package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SystemClock.sleep(3000);
        DashboardFragment dashboardFragment = new DashboardFragment();
        FragmentManager manager= getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.mainLayout,dashboardFragment,dashboardFragment.getTag())
                .commit();
    }
}
