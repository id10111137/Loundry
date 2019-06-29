package com.example.tatangit.loundry.View.SignUp.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.tatangit.loundry.R;
import com.example.tatangit.loundry.View.SignUp.Adapter.AdapterSignUp;
import com.example.tatangit.loundry.View.SignUp.Fragment.FragmentLogin;
import com.example.tatangit.loundry.View.SignUp.Fragment.FragmentRegister;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivitySignUp extends AppCompatActivity {


    @BindView(R.id.tabs)
    TabLayout tableLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        setupViewPager(viewPager);
        tableLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        AdapterSignUp adapter = new AdapterSignUp(getSupportFragmentManager());
        adapter.addFragment(new FragmentLogin(), "Login");
        adapter.addFragment(new FragmentRegister(), "Register");
        viewPager.setAdapter(adapter);
    }

}
