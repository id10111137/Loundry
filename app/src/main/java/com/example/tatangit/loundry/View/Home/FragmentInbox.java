package com.example.tatangit.loundry.View.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tatangit.loundry.R;

import butterknife.ButterKnife;

public class FragmentInbox extends Fragment {

    View root;
    Fragment fragment;
    FragmentManager fragmentManager;


    public FragmentInbox() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_inbox, container, false);
        ButterKnife.bind(this, root);
        return root;
    }
}
