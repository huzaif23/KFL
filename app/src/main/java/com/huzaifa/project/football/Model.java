package com.huzaifa.project.football;

public class Model {
    public int type;
   public String name;
    public String email;
    public String pass;
    public String win;
    public String lose;
    public String draw;

    public Model(String name, String email, String pass,String draw,String win,String lose) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.draw = draw;
        this.win=win;
        this.lose = lose;
    }
    public Model() {

    }

}