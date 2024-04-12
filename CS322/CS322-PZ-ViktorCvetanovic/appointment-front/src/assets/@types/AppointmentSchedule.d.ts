import {Identifiable} from "./Identifiable";
import {User} from "./User";
import {Appointment} from "./Appointment";

export interface AppointmentSchedule extends Identifiable {
  id: number;
  user: User;
  appointment: Appointment;
  status: AppointmentSchedule.AppointmentScheduleStatusEnum;
}

export namespace AppointmentSchedule {
  export type AppointmentScheduleStatusEnum = 'ACCEPTED' | 'PAID' | 'CANCELED';
  // @ts-ignore
  export const AppointmentScheduleStatusEnum = {
    ACCEPTED: 'ACCEPTED' as AppointmentScheduleStatusEnum,
    PAID: 'PAID' as AppointmentScheduleStatusEnum,
    CANCELED: 'CANCELED' as AppointmentScheduleStatusEnum
  };
}
