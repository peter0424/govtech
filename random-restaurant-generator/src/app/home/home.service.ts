import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  private baseUrl = `${environment.resourceUrl}/restaurant`;
  private addRestaurantUrl = `${this.baseUrl}/add-restaurant`;
  private getRandomRestaurantUrl = `${this.baseUrl}/get-random-restaurant`;
  private listRestaurantUrl = `${this.baseUrl}/get-restaurant-list`;

  constructor(private httpClient: HttpClient) { }

  addRestaurant(restaurant: string): Observable<string> {
    return this.httpClient.post<string>(`${this.addRestaurantUrl}`, restaurant);
  }

  getRandomRestaurant(): Observable<string> {
    return this.httpClient.get(`${this.getRandomRestaurantUrl}`, { responseType: 'text' });
  }

  listRestaurant(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.listRestaurantUrl}`);
  }
}
