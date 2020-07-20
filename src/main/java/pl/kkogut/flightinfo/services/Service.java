package pl.kkogut.flightinfo.services;

import com.google.gson.Gson;

public class Service {
    Api api;

    Service(Api api){
        this.api = api;
    }
    /**
     * Gets object from json.
     * <p>Serves object of a given type from a json data. Uses Gson library.</p>
     * @param json Json data to convert to object.
     * @param type Type of object which is json converted to.
     * @return Object of given type.
     * @see com.google.gson.internal.$Gson$Types
     */
    <T extends Object> T getObjectFromJson(String json, Class<T> type) {
        return new Gson().fromJson(json, type);
    }
}
