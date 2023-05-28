import { Injectable, inject } from '@angular/core';
import { UseQuery } from '@ngneat/query';
import { HttpClient } from '@angular/common/http';

const API_ENDPOINT = "http://localhost:8080/api" ;

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
  getChildData(parentId: number) {
    let page_num: number = 0;

    const queryKey = ['getChildData', page_num];

    const query =  this.useQuery(queryKey, () => {
      return this.http.post<IChildData[]>(
        `${API_ENDPOINT}/children/${page_num}`,
        {
          parentId
        }
      );
    }) as any;

    const invalidateQuery = (pageNum: number) => {
      page_num = pageNum;
      query.refetch();
    }
    
    return { query, invalidateQuery }
  }
}
