import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../models/Review';

@Injectable({
  providedIn: 'root',
})
export class BackendService {
  private baseUrl: string = 'http://localhost:8080';
  constructor(private http: HttpClient) {}
  private isLoggedIn = false;
  setIsLoggedIn(value: boolean): void {
    this.isLoggedIn = value;
  }
  getIsLoggedIn(): boolean {
    return this.isLoggedIn;
  }
  //User API
  registerUser(user: any) {
    return this.http.post(`${this.baseUrl}/register`, user).pipe();
  }
  loginUser(email: string, password: string): Observable<any> {
    const body = { email, password };
    return this.http.post<any>(`${this.baseUrl}/user/login`, body);
  }
  //Product API
  getAllProducts() {
    return this.http.get<any>(`${this.baseUrl}/product/getall`);
  }
  searchProduct(searchValue: string): Observable<any> {
    const params = new HttpParams().set('searchValue', searchValue);
    return this.http.post<any>(`${this.baseUrl}/product/search`, params);
  }
  //Review API
  getReviews(productCode: number): Observable<Review[]> {
    return this.http.get<any>(`${this.baseUrl}/reviews/search/${productCode}`);
  }
  addReview(review: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/reviews/addreview`, review);
  }

  getProductsCount(): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/noOfProducts`);
  }
  getUsersCount(): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/noOfUsers`);
  }
  getReviewsCount(): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/noOfReviews`);
  }
  getPendingReviews(): Observable<any> {
    const url = `${this.baseUrl}/reviews/pending`;
    return this.http.get(url);
  }

  approveReview(reviewId: number): Observable<any> {
    const url = `${this.baseUrl}/reviews/approve/${reviewId}`;
    return this.http.post(url, null);
  }

  rejectReview(reviewId: number): Observable<any> {
    const url = `${this.baseUrl}/reviews/reject/${reviewId}`;
    return this.http.post(url, null);
  }
}
