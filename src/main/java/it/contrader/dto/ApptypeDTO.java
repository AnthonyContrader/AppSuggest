//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it.contrader.dto;

public class ApptypeDTO {
    private int id;
    private String tag;

    public ApptypeDTO() {
    }

    public ApptypeDTO(String tag) {
        this.tag = tag;
    }

    public ApptypeDTO(int id, String tag) {
        this.id = id;
        this.tag = tag;

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return this.tag;
    }

    public String toString() {
        return this.id + "\t" + this.tag + "\t\t";
    }
}

