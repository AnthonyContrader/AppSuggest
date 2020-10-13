//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it.contrader.model;

public class App {
    private int id;
    private String appname;
    private String apptype;

    public App() {
    }

    public App(String appname, String apptype) {
        this.appname = appname;
        this.apptype = apptype;
    }

    public App(int id, String appname, String apptype) {
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
        return this.id + "\t" + this.appname + "\t\t" + this.apptype + "\t\t";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            App other = (App)obj;
            if (this.id != other.id) {
                return false;
            } else {
                if (this.apptype == null) {
                    if (other.apptype != null) {
                        return false;
                    }
                } else if (!this.apptype.equals(other.apptype)) {
                    return false;
                }

                if (this.appname == null) {
                    if (other.appname != null) {
                        return false;
                    }
                } else if (!this.appname.equals(other.appname)) {
                    return false;
                }

                return true;
            }
        }
    }
}