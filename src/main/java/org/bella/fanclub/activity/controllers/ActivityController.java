package org.bella.fanclub.activity.controllers;

import org.bella.fanclub.activity.modules.Activity;
import org.bson.types.ObjectId;
import org.kin.common.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kindai on 22/07/16.
 */
@CrossOrigin
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    @Qualifier("activityDao")
    DAO<Activity> activityDAO;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Activity> getActivity(){
        List<Activity> activitys = activityDAO.getAll();
        return activitys;
    }

    @RequestMapping(value = "/{uid}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Activity getActivity(@PathVariable String uid){
        Activity activitys = activityDAO.getObject(uid);
        return activitys;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Activity createActivity(@RequestBody Activity activity){
        return activityDAO.create(activity);
    }

    @RequestMapping(value = "/{uid}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Activity updateActivity(@PathVariable String uid, @RequestBody Activity activity){
        activity.set_id(new ObjectId(uid));
        activityDAO.update(activity);
        return activity;
    }

}
