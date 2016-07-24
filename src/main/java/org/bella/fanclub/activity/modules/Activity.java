package org.bella.fanclub.activity.modules;

import org.bella.fanclub.activity.enums.ActType;
import org.bella.fanclub.activity.enums.Location;
import org.kin.common.model.Entity;

import java.sql.Date;
import java.util.List;

/**
 * Created by kindai on 22/07/16.
 */
public class Activity extends Entity{

    User owner;
    List<User> attendees;
    String title;
    String desc;
    ActType type;
    Date startDate;
    Date endDate;
    Date endBookingDate;
    Integer MaxAttendant;
    Location loc;
    List<String> picUrls;

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public Integer getMaxAttendant() {
        return MaxAttendant;
    }

    public void setMaxAttendant(Integer maxAttendant) {
        MaxAttendant = maxAttendant;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ActType getType() {
        return type;
    }

    public void setType(ActType type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndBookingDate() {
        return endBookingDate;
    }

    public void setEndBookingDate(Date endBookingDate) {
        this.endBookingDate = endBookingDate;
    }

}
