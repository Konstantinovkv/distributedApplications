import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http'
import { AppComponent } from './app.component';
import { NasaComponent } from './nasa/nasa.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RouterModule, Routes } from '@angular/router';
import { FootballComponent } from './football/football.component';
import { WeatherComponent } from './weather/weather.component';
import { WeatherFormComponent } from './weather-form/weather-form.component';

const routes: Routes = [
  {path: 'nasa', component: NasaComponent},
  {path: 'football', component: FootballComponent},
  {path: 'weather', component: WeatherFormComponent},
  {path: 'city', component: WeatherComponent},
  {path: '', redirectTo: 'nasa', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    NasaComponent,
    FootballComponent,
    WeatherComponent,
    WeatherFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
