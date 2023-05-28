import { Component, inject } from '@angular/core';
import { ParentService } from 'src/app/services/parent/parent.service';

@Component({
  selector: 'app-parent-table',
  templateUrl: './parent-table.component.html',
  styleUrls: ['./parent-table.component.scss']
})
export class ParentTableComponent {
  page_num: number = 0;
  
  // Declare parentData$ as a variable to store the result of the parent data
  getParentData = inject(ParentService).getParentData();

  goToNextPage(total_num: number) {
    if(this.page_num == total_num - 1) {
      return
    }

    this.page_num += 1;
    this.getParentData.invalidateQuery(this.page_num);
  }

  goToPreviousPage() {
    if(this.page_num == 0) {
      return
    }

    this.page_num -= 1;
    this.getParentData.invalidateQuery(this.page_num);
  }
}
