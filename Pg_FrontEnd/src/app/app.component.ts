import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'owner-portal';

  constructor(private router:Router){}

  onLogout()
  {
    sessionStorage.removeItem('OwnerId')
    sessionStorage.removeItem('OwnerEmail')
    this.router.navigate(['/login'])
  }
}
