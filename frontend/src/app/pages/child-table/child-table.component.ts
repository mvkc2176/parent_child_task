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
  id: string = this.route.snapshot.params['id'];

  // Retrieving child data using ChildService and assigning it to 'childData$' property
  childData$ = inject(ChildService).getChildData(parseInt(this.id)).result$;

  constructor(private route: ActivatedRoute) {}
}
