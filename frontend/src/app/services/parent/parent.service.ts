import { Injectable, inject } from '@angular/core';
import { UseQuery } from '@ngneat/query';
import { HttpClient } from '@angular/common/http';

const API_ENDPOINT = "http://10.10.14.15:8080/api";

interface IParentData {
  sender: string;
  receiver: string;
  totalAmount: any;
  createdAt: string;
}

@Injectable({
  providedIn: 'root'
})
export class ParentService {

  // Injecting the 'UseQuery' and 'HttpClient' dependencies
  private useQuery = inject(UseQuery);
  private http = inject(HttpClient);

  constructor() { }

  getParentData() {
    // Using the 'UseQuery' hook to cache and manage the data retrieval
    return this.useQuery(['getParentData'], () => {
      return this.http.get<IParentData[]>(
        `${API_ENDPOINT}/parents`
      );
    }) as any;
  }
}
