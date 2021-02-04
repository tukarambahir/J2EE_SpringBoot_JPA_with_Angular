import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { OwnerService } from './owner.service';
import { PgComponent } from './pg/pg.component';
import { PropertyDetailsComponent } from './property-details/property-details.component';
import { PropertyListComponent } from './property-list/property-list.component';
import { SignupComponent } from './signup/signup.component';
import {UpdatePropertyDetailsComponent} from './update-property-details/update-property-details.component'
import { WelcomeComponent } from './welcome/welcome.component';
import { PglistComponent } from './pglist/pglist.component';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { UserSignupService } from './user-signup.service';
import { AdminBookingsComponent } from './admin-bookings/admin-bookings.component';
import { AdminAllpgComponent } from './admin-allpg/admin-allpg.component';
import { AdminAllownersComponent } from './admin-allowners/admin-allowners.component';
import { SearchedPgListComponent } from './searched-pg-list/searched-pg-list.component';



const routes: Routes = [
  {path: '', redirectTo: 'welcome',pathMatch: 'full'},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent, canActivate: [OwnerService]},
  {path: 'pg', component: PgComponent, canActivate: [OwnerService]},
  {path: 'listpg', component: PropertyListComponent, canActivate: [OwnerService]},
  {path: 'pgdetail', component: PropertyDetailsComponent, canActivate: [OwnerService]},
  {path: 'updatepgdetail', component: UpdatePropertyDetailsComponent, canActivate: [OwnerService]},
  {path: 'userdashboard', component: UserDashboardComponent,canActivate: [UserSignupService]},
  {path: 'pglist',component: PglistComponent,canActivate: [UserSignupService]},
  {path: 'add-booking',component: AddBookingComponent,canActivate: [UserSignupService]},
  {path:'booking-list',component: BookingListComponent,canActivate: [UserSignupService]},
  {path:'admindashboard',component: AdminDashboardComponent},
  {path:'adminbookings',component:AdminBookingsComponent},
  {path:'adminpgs',component:AdminAllpgComponent},
  {path:'allowners',component: AdminAllownersComponent},
  {path: 'searchedCityPg', component: SearchedPgListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
