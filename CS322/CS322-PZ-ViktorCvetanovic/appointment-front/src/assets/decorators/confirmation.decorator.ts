import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {ConfirmationDialogComponent} from "../../app/confirmation-dialog/confirmation-dialog.component";

// @ts-ignore
export function Confirmation<K extends string>(message: string = "Do you want deleted item?", input = false, dialog: K = "dialog") {
  return (target: Object, propertyKey: string, descriptor: PropertyDescriptor) => {
    const originalMethod = descriptor.value;
    descriptor.value = function (this: Record<K, MatDialog>, ...args: any[]) {

      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = true;
      dialogConfig.data = message;

      const dialogRef = this[dialog].open(ConfirmationDialogComponent, dialogConfig);
      return dialogRef
        .afterClosed()
        .toPromise().then((res: boolean) => {
          if (res) {
            originalMethod.apply(this, args);
          }
        });
    };
    return descriptor;
  };
}
