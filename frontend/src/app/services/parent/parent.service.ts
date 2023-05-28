import { Injectable, inject } from '@angular/core';
import { UseQuery } from '@ngneat/query';
import { HttpClient } from '@angular/common/http';

const API_ENDPOINT = "http://localhost:8080/api";

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
    let page_num: number = 0 ;

    const queryKey = ['getParentData', page_num];

    const query = this.useQuery(queryKey, () => {
      return this.http.get<IParentData[]>(
        `${API_ENDPOINT}/parents/${page_num}`
      );
    }) as any;

    const invalidateQuery = (pageNum: number) => {
      page_num = pageNum;
      query.refetch();
    };

    return { query, invalidateQuery };
  }
}
