import {formatDate} from "@angular/common";

export const getTimeFromISODateString = (date: string) => {
  const defValue = "00:00:00";
  if (!date) {
    return defValue;
  }
  const parts = date.split("T");
  if (parts.length === 1) {
    return defValue;
  }
  return parts[1];
};

export const formatDatee = (date: any) => date.toLocaleDateString("en-GB", {
  day: "2-digit",
  month: "2-digit",
  year: "2-digit",
});

export const formatDateA = (date: any) => {
  return formatDate(date, "yyyy-MM-dd", "en");
}

// 2022-01-31T13:45:30
export const formatDateB = (date: any) => {
  return formatDate(date, "yyyy-MM-dd'T'hh:mm:ss", "en");
}

export const parseTime = (event: any)  => {
  const data = event.split(":");
  const hour = data[0] < 10 ? data[0] : data[0];
  const minute = data[1] < 10 ? data[1] : data[1];
  const second = data[2] ? data[2] : `00`;
  return `${hour}:${minute}:${second}`;
};
