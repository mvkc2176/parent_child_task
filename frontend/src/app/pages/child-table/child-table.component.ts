import { ActivatedRoute } from '@angular/router';
import { Component, inject } from '@angular/core';
import { ChildService } from 'src/app/services/child/child.service';

@Component({
  selector: 'app-child-table',
  templateUrl: './child-table.component.html',
  styleUrls: ['./child-table.component.scss']
})
export class ChildTableComponent {
  // Extracting the 'id' parameter from the current route snapshot
  parentId: string = this.route.snapshot.params['id'];
  page_num: number = 0;

  // Retrieving child data using ChildService and assigning it to 'childData$' property
  getChildrenData = inject(ChildService).getChildData(parseInt(this.parentId));

  constructor(private route: ActivatedRoute) {

  }

  goToNextPage(total_num: number) {
    if(this.page_num == total_num - 1) {
      return
    }

    this.page_num += 1;
    this.getChildrenData.invalidateQuery(this.page_num);
  }

  goToPreviousPage() {
    if(!this.page_num) {
      return
    }

    this.page_num -= 1;
    this.getChildrenData.invalidateQuery(this.page_num);
  }
} 
