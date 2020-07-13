package pl.kkogut.flightinfo.services;

import com.google.gson.Gson;

public class Service {

    Api api;

    Service(Api api){
        this.api = api;
    }
    <T extends Object> T getObjectFromJson(String result, Class<T> type) {
        return new Gson().fromJson(result, type);
    }
}
