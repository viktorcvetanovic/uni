using CS322_PZ_Viktor_Cvetanovic_4421.Data.Context;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Service.Impl;

public class AppointmentScheduleServiceImpl : AppointmentScheduleService
{
    private readonly AuditableContext context;
    private readonly AppointmentService appointmentService;

    public AppointmentScheduleServiceImpl(AuditableContext context, AppointmentService appointmentService)
    {
        this.context = context;
        this.appointmentService = appointmentService;
    }

    public AppointmentSchedule GetById(int id)
    {
        return context.AppointmentSchedules.Single(e => e.Id == id);
    }

    public List<AppointmentSchedule> GetAll()
    {
        return context.AppointmentSchedules.ToList();
    }


    public AppointmentSchedule Save(AppointmentSchedule appointmentSchedule)
    {
        EntityEntry<AppointmentSchedule> entry = context.AppointmentSchedules.Add(appointmentSchedule);
        context.SaveChanges();
        return entry.Entity;
    }


    public AppointmentSchedule Update(AppointmentSchedule appointmentSchedule)
    {
        AppointmentSchedule? existing = GetById(appointmentSchedule.Id);
        if (existing == null)
        {
            throw new Exception();
        }

        EntityEntry<AppointmentSchedule> entry = context.Entry(existing);
        entry.CurrentValues.SetValues(appointmentSchedule);
        entry.CurrentValues["CreatedDate"] = existing.CreatedDate;

        context.SaveChanges();
        return entry.Entity;
    }

    public List<AppointmentSchedule> GetAllWhenDateHasNotPassed()
    {
        List<AppointmentSchedule> appointmentSchedules = GetAll();
        List<AppointmentSchedule> appointmentSchedules1 = new List<AppointmentSchedule>();

        appointmentSchedules.ForEach(schedule =>
        {
            var appointment = appointmentService.GetById((int) schedule.AppointmentFk);
            if (appointment != null && (appointment.Date > DateTime.Now || appointment.Date.Equals(DateTime.Now)))
            {
                appointmentSchedules1.Add(schedule);
            }
        });

        return appointmentSchedules1;
    }

    public List<AppointmentSchedule> GetAllByUserId(int userId)
    {
        return context.AppointmentSchedules.Where(schedule => schedule.UserFk == userId).ToList();
    }

    public List<AppointmentSchedule> GetAllByUserIdAndAppointmentDateAndStatusIsNull(int userId, DateTime date)
    {
        var appointments = context.AppointmentSchedules
            .Where(schedule => schedule.UserFk == userId)
            .ToList();

        List<AppointmentSchedule> appointmentSchedules = new List<AppointmentSchedule>();

        appointments.ForEach(schedule =>
        {
            if (schedule.Status is null &&
                compareDate(((DateTime) appointmentService.GetById((int) schedule.AppointmentFk).Date)!) == compareDate(date))
            {
                appointmentSchedules.Add(schedule);
            }
        });

        return appointmentSchedules;
    }
    
    public void Delete(int appointmentScheduleId)
    {
        context.AppointmentSchedules.Remove(GetById(appointmentScheduleId));
        context.Entry(GetById(appointmentScheduleId)).State = EntityState.Deleted;
        context.SaveChanges();
    }

    public int compareDate(DateTime date)
    {
        return date.Year * 10000 + date.Month * 100 + date.Day;
    }
}