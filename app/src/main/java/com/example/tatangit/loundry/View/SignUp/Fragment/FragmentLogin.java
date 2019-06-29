package com.example.tatangit.loundry.View.SignUp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.loundry.Presenter.SignUp.SignUpPresenter;
import com.example.tatangit.loundry.Presenter.SignUp.SignUpPresenterImp;
import com.example.tatangit.loundry.R;
import com.example.tatangit.loundry.View.SignUp.Adapter.AdapterForgot;
import com.example.tatangit.loundry.View.SignUp.Interface.SignUp;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentLogin extends Fragment implements SignUp {

    Intent mIntent;
    Toolbar toolbar;
    TextView mTitle;
    View root;

    @BindView(R.id.IdPassword)
    EditText IdPassword;

    @BindView(R.id.IdNoTLp)
    EditText IdNoTLp;

    private SignUpPresenter signUpPresenter;


    public FragmentLogin() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, root);
        signUpPresenter = new SignUpPresenterImp(this);
        return root;
    }


    @OnClick(R.id.IdForgotPassword)
    public void GoForgot(){
        AdapterForgot forgot = new AdapterForgot(getContext());
        forgot.show(getFragmentManager());
    }

    @OnClick(R.id.IdGoLogin)
    public void GoLogin(){
        signUpPresenter.Login(IdNoTLp.getText().toString(), IdPassword.getText().toString());
    }

    @Override
    public void ShowErrorFalidation() {

    }

    @Override
    public void SignUpSuccsess() {
        Toast.makeText(getContext(), "Sukses Mengarah Ke Halaman Homes", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SignUpError() {
        Toast.makeText(getContext(), "Error Mengarah Ke Halaman Login", Toast.LENGTH_SHORT).show();
    }
}
