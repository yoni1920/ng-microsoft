package ng.WaRoom.BL;

import ng.WaRoom.DAL.ActivitiesDAL;
import ng.WaRoom.model.Activity;

import java.util.List;

public class ActivitiesBL {

    public static List<Activity> allActivities(){
        return ActivitiesDAL.getActivities();
    }
}
