using CS322_PZ_Viktor_Cvetanovic_4421.Data.Context;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;
using Google.Protobuf.WellKnownTypes;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Service.Impl;

public class AppointmentServiceImpl : AppointmentService
{
    private readonly AuditableContext context;


    public AppointmentServiceImpl(AuditableContext context) {
        this.context = context;
    }

    public Appointment GetById(int id) {
        return context.Appointments.Single(e => e.Id == id);
    }
	
    public List<Appointment> GetAll()
    {
        return context.Appointments.ToList();
    }

    public object GetAllAppointmentSchedule()
    {
        var appointments = (from a in context.Appointments
            join asc in context.AppointmentSchedules
                on a.Id equals asc.AppointmentFk into g 
            from asc in g.DefaultIfEmpty()
            select new
            {
                Id = a.Id,
                StartTime = a.StartTime,
                EndTime = a.EndTime,
                Status = a.Status,
                Date = a.Date
            }).ToList();

        return appointments;
    }


    public Appointment Save(Appointment appointment) {
        EntityEntry<Appointment> entry = context.Appointments.Add(appointment);
        context.SaveChanges();
        return entry.Entity;
    }

	
    public Appointment Update(Appointment appointment) {
        Appointment? existing = context.Appointments.Find(appointment.Id);
        if (existing == null) {
            throw new Exception();
        }

        EntityEntry<Appointment> entry = context.Entry(existing);
        entry.CurrentValues.SetValues(appointment);
        entry.CurrentValues["CreatedDate"] = existing.CreatedDate;
        context.SaveChanges();
        return entry.Entity;
    }
    
    public List<Appointment> GetAllByDate(DateTime date)
    {
        var appointments = context.Appointments
            .ToList();

        List<Appointment> appointmentList = new List<Appointment>();
        
        appointments.ForEach(appointment =>
        {
            if (compareDate(((DateTime) appointment.Date)!) ==  compareDate(date))
            {
                appointmentList.Add(appointment);
            }
        });

        return appointmentList;
    }

    public void Delete(int appointmentId)
    {
        context.Appointments.Remove(GetById(appointmentId));
        context.Entry(GetById(appointmentId)).State = EntityState.Deleted;
        context.SaveChanges();
    }
    
    
    public int compareDate(DateTime date)
    {
        return date.Year * 10000 + date.Month * 100 + date.Day;
    }
}