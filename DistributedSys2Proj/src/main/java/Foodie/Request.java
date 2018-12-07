package Foodie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.ResponseEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    private final String id;
    private double lat;
    private double longi;
    private String FullAddress;
    private String Street;
    private String City;
    private String State;
    private Info Resturants;

    public Request(String id,String Street,String City,String State,double lat, double longi) {
        this.id = id;
        this.longi = longi;
        this.lat = lat;
        this.Street = Street;
        this.City = City;
        this.State = State;
        this.FullAddress = Street+" "+City+" "+State;
        this.Resturants = null;

    }
    public String getId() {
        return id;
    }
    public String getStreet(){
        return Street;
    }
    public String getCity(){
        return City;
    }
    public void setLongi(double longi) {
        this.longi = longi;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public Info getResturants(){
        return Resturants;
    }

    public void setResturants(Info resturants) {
        Resturants = resturants;
    }

    public double getLat() {
        return lat;
    }
    public double getLongi() {
        return longi;
    }

    public String getFullAddress() {
        return FullAddress;
    }

    public String getState() {
        return State;
    }
    @Override
    public String toString(){
        return "Id = "+id+"\n"+"Street = "+Street+"\n"+"City = "+City+"\n"+"State = "+State+"\n"+"Restaurants = "+Resturants.toString()+"\n";
    }
}