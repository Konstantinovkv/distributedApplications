import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../weather.service';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {

  weatherData: any;
  constructor(private weatherService: WeatherService) { }

  ngOnInit(): void {
    this.weatherService.getWeatherInfo().subscribe((data) => {
      console.log(data);
      this.weatherData = data;
    });
  }

  roundTemp(number: number): number{
    return Math.round(number);
  }

}
