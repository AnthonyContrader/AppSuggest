import {ApptypeDTO} from './apptypedto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend.
 *
 * @see Usertype
 *
 * @author Vittorio Valent
 */
export class AppDTO {

   id: number;

   appname: string;
   //  private int apptype_id;
   apptype: ApptypeDTO;
   //  private String tag;
   //   private Apptype apptype_tag;

}

