//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "App")
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "appname")
    private String appname;

    @Column(name = "apptype")
    private String apptype;

   // private String tag;
    //@ManyToOne(fetch=FetchType.LAZY)
  //  @JoinColumn(name="APPTYPE_ID")
   // private Apptype apptype_tag;


}