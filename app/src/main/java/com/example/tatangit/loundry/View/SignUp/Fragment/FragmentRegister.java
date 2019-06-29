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
import com.example.tatangit.loundry.View.SignUp.Interface.SignUp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentRegister  extends Fragment implements SignUp {

    Intent mIntent;
    Toolbar toolbar;
    TextView mTitle;
    View root;


    @BindView(R.id.IdNoTLp)
    EditText IdNoTLp;

    @BindView(R.id.IdEmail)
    EditText IdEmail;

    @BindView(R.id.IdPassword)
    EditText IdPassword;

    private SignUpPresenter signUpPresenter;


    public FragmentRegister() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, root);
        signUpPresenter = new SignUpPresenterImp(this);
        return root;
    }

    @OnClick(R.id.IdGoRegister)
    public void GoRegister(){
        signUpPresenter.Register(IdNoTLp.getText().toString(),IdEmail.getText().toString(),IdPassword.getText().toString());
    }

    @Override
    public void ShowErrorFalidation() {

    }

    @Override
    public void SignUpSuccsess() {
        Toast.makeText(getContext(), "Sukses Registrasi", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SignUpError() {
        Toast.makeText(getContext(), "Gagal Registrasi", Toast.LENGTH_SHORT).show();
    }
}

