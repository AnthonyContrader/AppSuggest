//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "Apptype")
public class Apptype {

  //  @Column(name="APPTYPE_ID")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private long id;

    @Column(name="tag")
    private String tag;


   // @OneToMany(mappedBy="apptype")
   // private List<App> app = new ArrayList<>();
}