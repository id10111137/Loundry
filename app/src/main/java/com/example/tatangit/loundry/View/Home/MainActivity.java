package com.example.tatangit.loundry.View.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tatangit.loundry.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    Fragment fragment;

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    FragmentManager fragmentManager;
    ActionBarDrawerToggle toggle;
    FragmentTransaction fragmentTransaction;

    TextView txt_namesheader;
    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        try {
            if (savedInstanceState == null) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.IdContainer, new FragmentHomes());
                fragmentTransaction.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        View navHeader = navigationView.getHeaderView(0);
        txt_namesheader = (TextView) navHeader.findViewById(R.id.id_nameheader);
        txt_namesheader.setText("Loundry");
        imgProfile = (ImageView) navHeader.findViewById(R.id.imageView);

        Menu menuNav = navigationView.getMenu();

//        try {
//
//            if (!UserModelManager.getInstance(getApplicationContext()).isLoggedIn()) {
//                MenuItem mProfil = menuNav.findItem(R.id.mProfil);
//                mProfil.setVisible(false);
//                MenuItem mLogout = menuNav.findItem(R.id.mLogout);
//                mLogout.setVisible(false);
//                txt_namesheader.setText(null);
//                imgProfile.setVisibility(View.GONE);
//
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        fragment = null;

        if (id == R.id.menu_home) {
            fragment = new FragmentHomes();
        }  else if (id == R.id.menu_complain) {
            fragment = new FragmentComplain();
        } else if (id == R.id.menu_belanja) {
            fragment = new FragmentBelanja();
        }else if (id == R.id.menu_promo) {
            fragment = new FragmentPromo();
        }

        goDestination(fragment);
        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void goDestination(Fragment fragment) {
        if (fragment != null) {
            fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.IdContainer, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
