import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Weather } from './weather';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  city = "Plovdiv";
  postBody: any;

  private weatherUrl = "http://localhost:8080/weather/forecast";

  constructor(private http: HttpClient) { }

  getWeatherInfo(): Observable<Weather> {
    this.postBody = "{ \"city\": \""+this.city+"\"}";
    return this.http.post<Weather>(this.weatherUrl, JSON.parse(this.postBody));
  }
}
