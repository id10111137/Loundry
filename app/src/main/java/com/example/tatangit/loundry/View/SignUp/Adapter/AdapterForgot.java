package com.example.tatangit.loundry.View.SignUp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tatangit.loundry.Presenter.SignUp.SignUpPresenter;
import com.example.tatangit.loundry.Presenter.SignUp.SignUpPresenterImp;
import com.example.tatangit.loundry.R;
import com.example.tatangit.loundry.View.SignUp.Interface.SignUp;

import me.shaohui.bottomdialog.BaseBottomDialog;

@SuppressLint("ValidFragment")
public class AdapterForgot extends BaseBottomDialog implements SignUp {

    private SignUpPresenter signUpPresenter;
    Context mContext;


    @SuppressLint("ValidFragment")
    public AdapterForgot(Context mContext){
        this.mContext = mContext;
        signUpPresenter = new SignUpPresenterImp(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_forgot;
    }

    @Override
    public void bindView(View v) {
        EditText IdEmail = v.findViewById(R.id.IdEmail);
        LinearLayout IdGoForgot = v.findViewById(R.id.IdGoForgot);

        IdGoForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpPresenter.Forgot(IdEmail.getText().toString());
            }
        });

    }

    @Override
    public void ShowErrorFalidation() {

    }

    @Override
    public void SignUpSuccsess() {
        Toast.makeText(mContext, "Sukses Forgot Password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SignUpError() {
        Toast.makeText(mContext, "Gagal Forgot Password", Toast.LENGTH_SHORT).show();
    }
}
