import { Component, OnInit } from '@angular/core';
import {NasaService} from '../nasa.service'
import { Nasa } from '../nasa';

@Component({
  selector: 'app-nasa',
  templateUrl: './nasa.component.html',
  styleUrls: ['./nasa.component.css']
})
export class NasaComponent implements OnInit {

  nasa: any;
  constructor(private nasaService: NasaService) { }

  ngOnInit(): void {
    this.nasaService.getNasaInfo().subscribe((data) => {
      console.log(data);
      this.nasa = data;
    });
  }
}