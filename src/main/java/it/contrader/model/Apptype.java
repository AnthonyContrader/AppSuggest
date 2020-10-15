//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it.contrader.model;

public class Apptype {
    private int id;
    private String tag;

    public Apptype() {
    }

    public Apptype(String tag) {
        this.tag = tag;
    }

    public Apptype(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public String toString() {
        return this.id + "\t" + this.tag + "\t";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Apptype other = (Apptype)obj;
            if (this.id != other.id) {
                return false;
            } else {
                if (this.tag == null) {
                    if (other.tag != null) {
                        return false;
                    }
                } else if (!this.tag.equals(other.tag)) {
                    return false;
                }

                return true;
            }
        }
    }
}