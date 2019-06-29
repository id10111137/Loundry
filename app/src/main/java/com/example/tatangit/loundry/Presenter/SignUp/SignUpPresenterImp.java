package com.example.tatangit.loundry.Presenter.SignUp;

import com.example.tatangit.loundry.Hellper.Library.Retrofit.ServiceRetrofit;
import com.example.tatangit.loundry.Hellper.Library.Retrofit.UtilsRetrofit;
import com.example.tatangit.loundry.View.SignUp.Interface.SignUp;

public class SignUpPresenterImp implements SignUpPresenter {


    private SignUp signUp;
    private ServiceRetrofit serviceRetrofit;

    public SignUpPresenterImp(SignUp signUp){
        this.signUp = signUp;
        this.serviceRetrofit =  UtilsRetrofit.getSOService();
    }

    @Override
    public void Login(String NoTelp, String Password) {
        if(NoTelp.isEmpty() || Password.isEmpty()){
            signUp.SignUpError();
        }else{
            if(NoTelp.equals("123") && Password.equals("123")){
            signUp.SignUpSuccsess();
            }else{
                signUp.SignUpError();
            }
        }
    }

    @Override
    public void Register(String NoTelp, String Email, String Password) {

    }

    @Override
    public void Forgot(String Emil) {
        if(Emil.isEmpty()){
            signUp.SignUpError();
        }else{
            if(Emil.equals("id.10111137@gmail.com")){
                signUp.SignUpSuccsess();
            }else{
                signUp.SignUpError();
            }
        }
    }
}
