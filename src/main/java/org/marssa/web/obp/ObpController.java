package org.marssa.web.obp;

import org.marssa.gps.GpsReceiver;
import org.marssa.obp.Realm;
import org.marssa.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Robert Jaremczak
 * Date: 2013-10-27
 */

@Controller
public class ObpController {

    @Autowired
    private Realm realm;

    @Autowired
    private GpsReceiver gpsReceiver;

    @RequestMapping("/realm/details")
    public String realmDetails(ModelMap model) {
        model.addAttribute("realm", realm);
        return "realmDetails";
    }

    @RequestMapping("/simple/start")
    public String simpleStart() {
        return "simpleStart";
    }

    @RequestMapping("/simple/view")
    public String simpleSelection() {
        return "simpleView";
    }

    @RequestMapping("/simple/positionDetails")
    public String simplePositionDetails() {
        return "simplePositionDetails";
    }

    @RequestMapping("/simple/map")
    public String simpleMap(ModelMap model) {
        model.addAttribute("latitude", gpsReceiver.getLatitude());
        model.addAttribute("longitude", gpsReceiver.getLongitude());
        return "simpleMap";
    }

    @ResponseBody
    @RequestMapping("/simple/viewDataFeed")
    public ViewDataFeed all() {
        ViewDataFeed dto = new ViewDataFeed();
        dto.latitude = gpsReceiver.getLatitude();
        dto.longitude = gpsReceiver.getLongitude();
        dto.position = gpsReceiver.getLatitude()+" "+gpsReceiver.getLongitude();
        dto.speed = Integer.toString((int)gpsReceiver.getVelocityOverGround());
        dto.heading = Integer.toString((int)gpsReceiver.getTrueNorthCourse());
        return dto;
    }
}
