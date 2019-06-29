package com.example.tatangit.loundry.Hellper.Library.Retrofit;

public class UtilsRetrofit {

    public static final String BASE_URL = "http://api.umrota.com/index.php/";

    public static ServiceRetrofit getSOService() {
        return AppRetrofit.getClient(BASE_URL).create(ServiceRetrofit.class);
    }
}
