import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Football } from './football';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FootballService {

  private footballUrl = "http://localhost:8080/football/info";

  constructor(private http: HttpClient) { }

  getFootballInfo(): Observable<Football[]>{
    return this.http.get<Football[]>(`${this.footballUrl}`)
  }
}
