//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it.contrader.dto;

public class AppDTO {
    private int id;
    private String appname;
    private String apptype;

    public AppDTO() {
    }

    public AppDTO(String appname, String apptype) {
        this.appname = appname;
        this.apptype = apptype;
    }

    public AppDTO(int id, String appname, String apptype) {
        this.id = id;
        this.appname = appname;
        this.apptype = apptype;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApptype() {
        return this.apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppname() {
        return this.appname;
    }

    public String toString() {
        return this.id + "\t" + this.appname + "\t\t" + this.apptype;
    }
}

