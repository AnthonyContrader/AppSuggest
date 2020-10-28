import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isAppCollapsed = false;
  isApptypeCollapsed = false;

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  appscollapse() {
    if (this.isAppCollapsed === false) {
      this.isAppCollapsed = true;
    } else { this.isAppCollapsed = false; }
  }
  apptypescollapse() {
    if (this.isApptypeCollapsed === false) {
      this.isApptypeCollapsed = true;
    } else { this.isApptypeCollapsed = false; }
  }
  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
