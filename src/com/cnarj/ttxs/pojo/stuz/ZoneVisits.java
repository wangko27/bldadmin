package com.cnarj.ttxs.pojo.stuz;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * ZoneVisits entity. @author MyEclipse Persistence Tools
 */

public class ZoneVisits  implements java.io.Serializable {


    // Fields    

     private String zonevisitsid;
     private Member memberByIntervieweesuserid; //被访问者
     private Member memberByVisitorsuserid; //访问者
     private String visitorsusername; //访问者姓名
     private String visitorspicture; //访问者头像
     private String visitip; //访问者IP
     private Date visitdate;


    // Constructors

    /** default constructor */
    public ZoneVisits() {
    }

    
    /** full constructor */
    public ZoneVisits(Member memberByIntervieweesuserid, Member memberByVisitorsuserid, String visitorsusername, String visitorspicture, String visitip, Date visitdate) {
        this.memberByIntervieweesuserid = memberByIntervieweesuserid;
        this.memberByVisitorsuserid = memberByVisitorsuserid;
        this.visitorsusername = visitorsusername;
        this.visitorspicture = visitorspicture;
        this.visitip = visitip;
        this.visitdate = visitdate;
    }

   
    // Property accessors

    public String getZonevisitsid() {
        return this.zonevisitsid;
    }
    
    public void setZonevisitsid(String zonevisitsid) {
        this.zonevisitsid = zonevisitsid;
    }

    public Member getMemberByIntervieweesuserid() {
        return this.memberByIntervieweesuserid;
    }
    
    public void setMemberByIntervieweesuserid(Member memberByIntervieweesuserid) {
        this.memberByIntervieweesuserid = memberByIntervieweesuserid;
    }

    public Member getMemberByVisitorsuserid() {
        return this.memberByVisitorsuserid;
    }
    
    public void setMemberByVisitorsuserid(Member memberByVisitorsuserid) {
        this.memberByVisitorsuserid = memberByVisitorsuserid;
    }

    public String getVisitorsusername() {
        return this.visitorsusername;
    }
    
    public void setVisitorsusername(String visitorsusername) {
        this.visitorsusername = visitorsusername;
    }

    public String getVisitorspicture() {
        return this.visitorspicture;
    }
    
    public void setVisitorspicture(String visitorspicture) {
        this.visitorspicture = visitorspicture;
    }

    public String getVisitip() {
        return this.visitip;
    }
    
    public void setVisitip(String visitip) {
        this.visitip = visitip;
    }

    public Date getVisitdate() {
        return this.visitdate;
    }
    
    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }
   








}