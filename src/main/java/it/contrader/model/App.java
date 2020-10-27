//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="app")
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String appname;

    //private int apptype_id;

   /* @ManyToOne()
    @JoinColumn(
            name = "apptype_join",
            referencedColumnName = "id"
    )*/
   @ManyToOne
   @JoinColumn(name ="apptype")
    private Apptype apptype;
   // private String tag;
    //@ManyToOne(fetch=FetchType.LAZY)
  //  @JoinColumn(name="APPTYPE_ID")
   // private Apptype apptype_tag;


}
