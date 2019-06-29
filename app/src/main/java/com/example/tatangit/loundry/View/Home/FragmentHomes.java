package com.example.tatangit.loundry.View.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.tatangit.loundry.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentHomes extends Fragment {

    @BindView(R.id.btn_navigation_mInfo)
    BottomNavigationView bottomNavigationView;

    View root;
    Fragment fragment;
    FragmentManager fragmentManager;


    public FragmentHomes(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_homes, container, false);
        ButterKnife.bind(this, root);
        setupNavigationView();
//        BottomNavigation.disableShiftMode(bottomNavigationView);
        return root;
    }


    private void setupNavigationView() {

        if (bottomNavigationView != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = bottomNavigationView.getMenu();
            selectmInfo(menu.getItem(0));

            // Set action to perform when any menu-item is selected.
            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectmInfo(item);
                            return false;
                        }
                    });
        }
    }


    protected void selectmInfo(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.menu_home:
                pushFragment(new FragmentHome());
                break;
            case R.id.menu_pesanan:
                pushFragment(new FragmentPesanan());
                break;
            case R.id.menu_inbox:
                pushFragment(new FragmentInbox());
                break;
            case R.id.menu_profil:
                pushFragment(new FragmentProfil());
                break;
        }
    }


    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.frame_homes, fragment);
                ft.commit();
            }
        }
    }


}
