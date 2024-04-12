using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Service.Impl;

public interface AppointmentScheduleService
{
    AppointmentSchedule GetById(int id);
    List<AppointmentSchedule> GetAll();

    void Delete(int appointmentScheduleId);

    AppointmentSchedule Save(AppointmentSchedule appointmentSchedule);
    AppointmentSchedule Update(AppointmentSchedule appointmentSchedule);
    
    List<AppointmentSchedule> GetAllWhenDateHasNotPassed();

    List<AppointmentSchedule> GetAllByUserId(int userId);
    
    List<AppointmentSchedule> GetAllByUserIdAndAppointmentDateAndStatusIsNull(int userId, DateTime date);

}