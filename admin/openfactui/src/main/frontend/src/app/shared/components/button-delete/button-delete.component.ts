import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';

import { AlertService } from './../../../core/alert/alert.service';
import { ModalDirective } from 'ng2-bootstrap';
import { Removeable } from './removeable';
import { Router } from '@angular/router';

@Component({
  selector: 'of-button-delete',
  templateUrl: './button-delete.component.html',
  styles: [``]
})
export class ButtonDeleteComponent implements OnInit {

  @ViewChild('childModal')
  childModal: ModalDirective;

  // Object to be deleted
  @Input()
  model: Removeable;

  // Resource Kind to delete (e.g., 'Pod' or 'ReplicationController').
  @Input()
  kind: string;

  // Optional display name for kind.
  @Input()
  typeDisplayName: string;

  // Optional display name of the resource to delete.
  @Input()
  displayName: string;

  // Name of the resource to delete.
  @Input()
  resourceName: string;

  // Set to true to disable the delete button.
  @Input()
  disableDelete = false;

  // Force the user to enter the name before we'll delete the resource (e.g. for projects).
  @Input()
  typeNameToConfirm = false;

  // Optional link label. Defaults to 'Delete'.
  @Input()
  label: string;

  // Only show a delete icon with no text.
  @Input()
  buttonOnly: boolean;

  // Stay on the current page without redirecting to the resource list.
  @Input()
  stayOnCurrentPage = true;

  // Optional callback when the delete succeeds
  @Output()
  success: EventEmitter<boolean> = new EventEmitter<boolean>();

  // Optional redirect URL when the delete succeeds
  @Input()
  redirectUrl: string;

  confirmName = '';

  constructor(
    private router: Router,
    private alertService: AlertService
  ) { }

  ngOnInit() {
  }

  isOrganization(): boolean {
    if (this.kind === 'Organization') {
      return true;
    }
    return false;
  }

  openDeleteModal(confirmDeleteContent: any): void {
    if (this.disableDelete) {
      return;
    }

    this.childModal.show();

    // opening the modal with settings scope as parent
    this.modalService.open(confirmDeleteContent).result.then(
      (result) => {
        this.model.delete().subscribe(
          (data) => {
            this.alertService.pop('success', 'Success', 'Success! The organization has been deleted.');

            // callback
            this.success.emit(true);

            // navigate
            if (!this.stayOnCurrentPage) {
              this.router.navigate([this.redirectUrl]);
            }
          }
        );
      },
      (reason) => { }
    );
  }

}
