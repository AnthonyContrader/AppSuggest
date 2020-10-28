import { Component, OnInit } from '@angular/core';
import { ApptypeDTO } from 'src/dto/apptypedto';
import { ApptypeService } from 'src/service/apptype.service';

@Component({
  selector: 'app-apptypes',
  templateUrl: './apptypes.component.html',
  styleUrls: ['./apptypes.component.css']
})
export class ApptypesComponent implements OnInit {

  apptypes: ApptypeDTO[];
  apptypetoinsert: ApptypeDTO = new ApptypeDTO();

  constructor(private  service: ApptypeService) { }

  ngOnInit() {
    this.getApptypes();
  }
  getApptypes() {
    this.service.getAll().subscribe(apptypes => this.apptypes = apptypes);
  }

  delete(apptype: ApptypeDTO) {
    this.service.delete(apptype.id).subscribe(() => this.getApptypes());
  }

  update(apptype: ApptypeDTO) {
    this.service.update(apptype).subscribe(() => this.getApptypes());
  }

  insert(apptype: ApptypeDTO) {
    this.service.insert(apptype).subscribe(() => this.getApptypes());
  }

  clear(){
    this.apptypetoinsert = new ApptypeDTO();
  }
}
