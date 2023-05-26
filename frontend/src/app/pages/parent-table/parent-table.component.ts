import { Component, inject } from '@angular/core';
import { ParentService } from 'src/app/services/parent/parent.service';

@Component({
  selector: 'app-parent-table',
  templateUrl: './parent-table.component.html',
  styleUrls: ['./parent-table.component.scss']
})
export class ParentTableComponent {

  // Declare parentData$ as a variable to store the result of the parent data
  parentData$ = inject(ParentService).getParentData().result$;

}
