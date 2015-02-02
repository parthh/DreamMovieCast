package com.face3_test;

/**
 * Created by parth on 15-01-14.
 */

public class Actordetailcontroller {

    //private variables
    int _id;
    String _charname;
    String _actorname;
    String _charimgurl;
    String _actorimgurl;
    int _vote;
    String _movie;



    // Empty constructor
    public Actordetailcontroller(){

    }
    // constructor
    public Actordetailcontroller(int id, String charname,String charimgurl, String actorname,String actorimgurl ,int vote){
        this._id = id;
        this._charname = charname;
        this._actorname = actorname;
        this._charimgurl = charimgurl;
        this._actorimgurl = actorimgurl;
        this._vote = vote;


    }
    public Actordetailcontroller( String charname,String actorname, String charimgurl,String actorimgurl ,String movie){

        this._charname = charname;
        this._actorname = actorname;
        this._charimgurl = charimgurl;
        this._actorimgurl = actorimgurl;
        this._movie = movie;


    }

    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getcharname(){
        return this._charname;
    }

    // setting name
    public void setcharname(String name){
        this._charname = name;
    }

    // getting phone number
    public String getactorname(){
        return this._actorname;
    }

    // setting phone number
    public void setactorname(String actorname){
        this._actorname = actorname;
    }

    public void setcharimgurl(String imgname){
        this._charimgurl = imgname;
    }

    // getting phone number
    public String getcharimgurl(){
        return this._charimgurl;
    }
    public void setactorimgurl(String imgname){
        this._actorimgurl = imgname;
    }

    // getting phone number
    public String getactorimgurl(){
        return this._actorimgurl;
    }

    public void setlike(int vote){
        this._vote = vote;
    }

    // getting phone number
    public int getlike(){
        return this._vote;
    }

    public void setmovie(String movie){
        this._movie = movie;
    }

    // getting phone number
    public String getmovie(){
        return this._movie;
    }

}