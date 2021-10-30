import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Football } from '../football';
import { FootballService } from '../football.service';

@Component({
  selector: 'app-football',
  templateUrl: './football.component.html',
  styleUrls: ['./football.component.css']
})
export class FootballComponent implements OnInit {

  footballs$!: Observable<Football[]>;

  constructor(private footballService: FootballService) { }

  ngOnInit() {
    this.footballs$ = this.footballService.getFootballInfo()
  }

}
