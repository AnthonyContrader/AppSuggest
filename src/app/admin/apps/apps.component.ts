import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/service/app.service';
import { AppDTO } from 'src/dto/appdto';
import { ApptypeDTO } from 'src/dto/apptypedto';
import { ApptypeService } from 'src/service/apptype.service';

@Component({
  selector: 'app-apps',
  templateUrl: './apps.component.html',
  styleUrls: ['./apps.component.css']
})
export class AppsComponent implements OnInit {

  apps: AppDTO[];
  apptypes: ApptypeDTO[];
  apptoinsert: AppDTO = new AppDTO();

  constructor(private service: AppService, private  serviceApptype: ApptypeService) { }

  ngOnInit() {
    this.getApps();
    this.getApptypes();
  }

  getApptypes() {
    this.serviceApptype.getAll().subscribe(apptypes => this.apptypes = apptypes);
  }
  getApps() {
    this.service.getAll().subscribe(apps => this.apps = apps);
  }

  delete(app: AppDTO) {
    this.service.delete(app.id).subscribe(() => this.getApps());
  }

  update(app: AppDTO) {
    this.service.update(app).subscribe(() => this.getApps());
  }

  insert(app: AppDTO) {
    this.service.insert(app).subscribe(() => this.getApps());
  }

  clear(){
    this.apptoinsert = new AppDTO();
  }
}
