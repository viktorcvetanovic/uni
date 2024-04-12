import {Identifiable} from "./Identifiable";

export interface Appointment extends Identifiable {
  id: number;
  startTime: string;
  endTime: string;
  date: string;
  status: Appointment.AppointmentStatusEnum;
}


export namespace Appointment {
  export type AppointmentStatusEnum = 'ORDERED' | 'CANCELED' | 'CREATED';
  // @ts-ignore
  export const AppointmentStatusEnum = {
    ORDERED: 'ORDERED' as AppointmentStatusEnum,
    CANCELED: 'CANCELED' as AppointmentStatusEnum,
    CREATED: 'CREATED' as AppointmentStatusEnum,
  };
}
