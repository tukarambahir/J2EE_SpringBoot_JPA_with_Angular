import { OwnerService } from './owner.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AddPropertyService } from './add-property.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PgComponent } from './pg/pg.component';
import { PropertyListComponent } from './property-list/property-list.component';
import { PropertyDetailsComponent } from './property-details/property-details.component';
import { UpdatePropertyDetailsComponent } from './update-property-details/update-property-details.component';
 import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
 import { ToastrModule } from 'ngx-toastr';
import { UserService } from './user.service';
import { UserSignupService } from './user-signup.service';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { HeaderComponent } from './header/header.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { PglistComponent } from './pglist/pglist.component';
import { PgService } from './pg.service';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { BookingService } from './booking.service';
import { BookingListComponent } from './booking-list/booking-list.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminBookingsComponent } from './admin-bookings/admin-bookings.component';
import { AdminAllpgComponent } from './admin-allpg/admin-allpg.component';
import { AdminService } from './admin.service';
import { AdminAllownersComponent } from './admin-allowners/admin-allowners.component';
import { SearchedPgListComponent } from './searched-pg-list/searched-pg-list.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    DashboardComponent,
    PgComponent,
    PropertyListComponent,
    PropertyDetailsComponent,
    UpdatePropertyDetailsComponent,
    UserDashboardComponent,
    HeaderComponent,
    WelcomeComponent,
    PglistComponent,
    AddBookingComponent,
    BookingListComponent,
    AdminDashboardComponent,
    AdminBookingsComponent,
    AdminAllpgComponent,
    AdminAllownersComponent,
    SearchedPgListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot() 
  ],
  providers: [
    OwnerService,
    AddPropertyService,
    UserService,
    UserSignupService,
    PgService,
    BookingService,
    AdminService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
