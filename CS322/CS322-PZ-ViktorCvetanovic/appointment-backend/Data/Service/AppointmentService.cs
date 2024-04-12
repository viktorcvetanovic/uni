using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using Google.Protobuf.WellKnownTypes;
using Microsoft.AspNetCore.Mvc;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;

public interface AppointmentService
{
    Appointment GetById(int id);
    List<Appointment> GetAll();
    
    object GetAllAppointmentSchedule();
    Appointment Save(Appointment appointment);
    Appointment Update(Appointment appointment);

    void Delete(int appointmentId);
    
    List<Appointment> GetAllByDate(DateTime date);


}