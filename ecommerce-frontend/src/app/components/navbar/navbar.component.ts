import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BackendService } from 'src/app/services/backend.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  isLoggedIn: boolean = false;
  constructor(private backendService: BackendService, private router: Router){}
  ngOnInit(): void {
    this.isLoggedIn = this.backendService.getIsLoggedIn();
    console.log('Checking ', this.backendService.getIsLoggedIn())
  }
  logout(): void {
    this.backendService.setIsLoggedIn(false);
    this.router.navigate(['/']);
  }
}
