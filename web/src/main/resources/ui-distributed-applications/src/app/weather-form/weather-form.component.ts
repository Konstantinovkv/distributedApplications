import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../weather.service';

@Component({
  selector: 'app-weather-form',
  templateUrl: './weather-form.component.html',
  styleUrls: ['./weather-form.component.css']
})
export class WeatherFormComponent implements OnInit {

  constructor(private weatherService: WeatherService) { }

  ngOnInit(): void {
  }

  getValue(val: any){
    console.warn(val);
    this.weatherService.city=val;
  }

}
