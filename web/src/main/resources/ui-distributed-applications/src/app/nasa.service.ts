import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Nasa } from './nasa';

@Injectable({
  providedIn: 'root'
})
export class NasaService {

  private nasaUrl = "http://localhost:8080/nasa/picture";

  constructor(private http: HttpClient) { }

  getNasaInfo(): Observable<Nasa>{
    return this.http.get<Nasa>(`${this.nasaUrl}`)
  }

}
