package Foodie;

import java.util.ArrayList;
import java.util.List;

public class Booklet {
    private List<Request> addressList = new ArrayList<>();


    public void addRequest(Request req) {
        int remove=-1;
        for (int i = 0;i<addressList.size();i++) {
            if(req.getId().compareToIgnoreCase(addressList.get(i).getId())==0){
                remove = i;
            }

        }
        if(remove !=-1) {
            addressList.remove(remove);
        }
        addressList.add(req);
    }
    public Request getRequest(String s){
        Request r;
        for (int i = 0;i<addressList.size();i++) {
            if(s.compareToIgnoreCase(addressList.get(i).getId())==0){
                return addressList.get(i);
            }
        }
        return null;
    }

}
