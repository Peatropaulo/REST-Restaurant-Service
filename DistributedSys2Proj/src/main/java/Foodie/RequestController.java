package Foodie;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
public class RequestController {
    private static final String apiKeyGeo ="api_key=4455573350ee5e5112f2f53e53f5be4b021bb5e";
    private static final String apiKeyZom = "02e7bb7ac9b7fe59207f9eb1ab4b1907";
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private Booklet book = new Booklet();

    @RequestMapping("/restaurant")
    public ResponseEntity<?> ret(@Valid@RequestParam(value="User", defaultValue="Vince") String name) {
         Request r = book.getRequest(name);
         if(r == null)
         {

             throw new IllegalArgumentException("The 'User' parameter must exist and not be empty");
         }
         return new ResponseEntity<>(r.toString(),HttpStatus.ACCEPTED);
    }
    @RequestMapping(method=RequestMethod.POST,value="/restaurant")
    public ResponseEntity<?> addressList(@Valid @RequestBody Request address, HttpServletResponse response){

        if(address.getState()!=""&& address.getCity()!=""&&address.getStreet()!="") {
           RestTemplate restTemplate = new RestTemplate();
           String addr = restTemplate.getForObject(formStringRequestGeo(address), String.class);
            if(addr == null){
                return new ResponseEntity<>("Geocode Api is down"+HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);

            }
           Request temp = parseRet(address, addr);
            RestTemplate restTemplate2 = new RestTemplate();
           Info ret = restTemplate2.getForObject(formStringRequestZom(address),Info.class);
           if(ret == null){
               return new ResponseEntity<>("Zamato Api is down"+HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);

           }
           System.out.println(ret.toString());
           temp.setResturants(ret);
            Gson gson = new Gson();
            String json = gson.toJson(temp);
            return new ResponseEntity<>(json, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("No valid address given" +HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST);
    }



    private Request parseRet(Request addr, String temp){
        int latIndexB =temp.indexOf("lat");
        int lngIndexB =temp.indexOf("lng");
        int latIndexE = temp.indexOf(",",latIndexB);
        int lngIndexE = temp.indexOf(",",lngIndexB);
        addr.setLat(Double.parseDouble(temp.substring(latIndexB+5,latIndexE)));
        addr.setLongi(Double.parseDouble(temp.substring(lngIndexB+5,lngIndexE-1)));
        return addr;

    }
    private String formStringRequestGeo(Request address) {
        return "https://api.geocod.io/v1.3/geocode?street="+address.getStreet()+"&city="+address.getCity()+"&state="+address.getState()+"&"+apiKeyGeo;
    }
    private String formStringRequestZom(Request address){
        return "https://developers.zomato.com/api/v2.1/geocode?lat="+address.getLat()+"&"+"lon="+address.getLongi()+"&apikey="+apiKeyZom;
    }


}