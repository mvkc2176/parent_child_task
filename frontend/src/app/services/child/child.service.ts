import { Injectable, inject } from '@angular/core';
import { UseQuery } from '@ngneat/query';
import { HttpClient } from '@angular/common/http';

const API_ENDPOINT = "http://10.10.14.15:8080/api" ;

interface IChildData {
  paidAmount: number;
  createdAt: string;
  parent: any;
}

@Injectable({
  providedIn: 'root'
})
export class ChildService {

  private useQuery = inject(UseQuery);
  private http = inject(HttpClient);

  constructor() { }

  // Retrieves child data for a given ID
  getChildData(id: number) {
    return this.useQuery(['getChildData'], () => {
      return this.http.get<IChildData[]>(
        `${API_ENDPOINT}/children/${id}`
      );
    }) as any;
  }
}
